package com.application.talononeintegration.controller;

import com.application.talononeintegration.DTO.CustomerProfileRequest;
import com.application.talononeintegration.DTO.CustomerSessionRequest;
import com.application.talononeintegration.service.TalonIntegrationService;
import one.talon.ApiException;
import one.talon.model.CustomerProfileIntegrationResponseV2;
import one.talon.model.IntegrationStateV2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/talonOneSdk")
public class TalonOneIntegrationController {

    private final TalonIntegrationService talonService;

    @Autowired
    public TalonOneIntegrationController(TalonIntegrationService talonService) {
        this.talonService = talonService;
    }

    @PostMapping("/profile")
    public ResponseEntity<CustomerProfileIntegrationResponseV2> updateProfile(
            @RequestBody CustomerProfileRequest customerProfile) throws ApiException {

        return ResponseEntity.ok(talonService.updateCustomerProfile(customerProfile));
    }

    @PostMapping("/session")
    public ResponseEntity<IntegrationStateV2> updateSession(
            @RequestBody CustomerSessionRequest customerSession) throws ApiException {

        return ResponseEntity.ok(talonService.updateCustomerSession(customerSession));
    }
}
