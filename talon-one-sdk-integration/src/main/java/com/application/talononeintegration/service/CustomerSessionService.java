package com.application.talononeintegration.service;

import com.application.talononeintegration.DTO.CustomerSessionRequest;
import one.talon.ApiException;
import one.talon.model.CustomerSessionV2;
import one.talon.model.IntegrationCustomerSessionResponse;
import one.talon.model.IntegrationStateV2;

public interface CustomerSessionService {

    public IntegrationStateV2 updateCustomerSession(
            CustomerSessionRequest customerSession
    ) throws ApiException;

    public CustomerSessionV2 getCustomerSession(String sessionId) throws ApiException;
}
