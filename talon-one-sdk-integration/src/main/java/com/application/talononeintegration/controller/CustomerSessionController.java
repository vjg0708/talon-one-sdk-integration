package com.application.talononeintegration.controller;

import com.application.talononeintegration.DTO.CustomerSessionRequest;
import com.application.talononeintegration.service.CustomerSessionService;
import one.talon.ApiException;
import one.talon.model.CustomerSessionV2;
import one.talon.model.IntegrationCustomerSessionResponse;
import one.talon.model.IntegrationStateV2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/talonOneSdk/customer")
public class CustomerSessionController {

    private final CustomerSessionService sessionService;

    @Autowired
    public CustomerSessionController(CustomerSessionService sessionService) {
        this.sessionService = sessionService;
    }


    @PostMapping("/addSession")
    public ResponseEntity<IntegrationStateV2> updateSession(
            @RequestBody CustomerSessionRequest customerSession) throws ApiException {

        return ResponseEntity.ok(sessionService.updateCustomerSession(customerSession));
    }

    @GetMapping("/getSession/{sessionId}")
    public ResponseEntity<CustomerSessionV2> getSession(
            @PathVariable("sessionId") String sessionId
    ) throws ApiException {

        return ResponseEntity.ok(sessionService.getCustomerSession(sessionId));
    }
}
