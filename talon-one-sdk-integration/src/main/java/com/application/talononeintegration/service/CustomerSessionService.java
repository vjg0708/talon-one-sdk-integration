package com.application.talononeintegration.service;

import com.application.talononeintegration.DTO.CustomerSessionRequest;
import one.talon.ApiException;
import one.talon.model.IntegrationStateV2;

public interface CustomerSessionService {

    public IntegrationStateV2 updateCustomerSession(
            CustomerSessionRequest customerSession
    ) throws ApiException;
}
