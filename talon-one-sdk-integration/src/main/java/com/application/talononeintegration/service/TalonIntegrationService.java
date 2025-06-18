package com.application.talononeintegration.service;

import com.application.talononeintegration.DTO.CustomerProfileRequest;
import com.application.talononeintegration.DTO.CustomerSessionRequest;
import one.talon.ApiException;
import one.talon.model.CustomerProfileIntegrationResponseV2;
import one.talon.model.IntegrationStateV2;

public interface TalonIntegrationService {

    public CustomerProfileIntegrationResponseV2 updateCustomerProfile(
            CustomerProfileRequest customerProfile
    ) throws ApiException;

    public IntegrationStateV2 updateCustomerSession(
            CustomerSessionRequest customerSession
    ) throws ApiException;
}
