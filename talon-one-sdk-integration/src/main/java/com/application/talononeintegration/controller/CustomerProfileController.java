package com.application.talononeintegration.controller;

import com.application.talononeintegration.DTO.CustomerProfileRequest;
import com.application.talononeintegration.DTO.CustomerSessionRequest;
import com.application.talononeintegration.service.CustomerProfileService;
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
@RequestMapping("/api/v1/talonOneSdk/customer")
public class CustomerProfileController {

    private final CustomerProfileService profileService;

    @Autowired
    public CustomerProfileController(CustomerProfileService profileService) {

        this.profileService = profileService;
    }

    @PostMapping("/profile")
    public ResponseEntity<CustomerProfileIntegrationResponseV2> updateProfile(
            @RequestBody CustomerProfileRequest customerProfile) throws ApiException {

        return ResponseEntity.ok(profileService.updateCustomerProfile(customerProfile));
    }
}
