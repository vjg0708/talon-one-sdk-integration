package com.application.talononeintegration.service.impl;

import com.application.talononeintegration.DTO.CustomerProfileRequest;
import com.application.talononeintegration.DTO.CustomerSessionRequest;
import com.application.talononeintegration.service.CustomerProfileService;
import one.talon.ApiException;
import one.talon.api.IntegrationApi;
import one.talon.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.threeten.bp.OffsetDateTime;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerProfileServiceImpl implements CustomerProfileService {

    private final IntegrationApi integrationApi;

    @Autowired
    public CustomerProfileServiceImpl(IntegrationApi integrationApi) {

        this.integrationApi = integrationApi;
    }


    @Override
    public CustomerProfileIntegrationResponseV2 updateCustomerProfile(CustomerProfileRequest customerProfile) throws ApiException {

        CustomerProfileIntegrationRequestV2 request = new CustomerProfileIntegrationRequestV2();
        request.setAttributes(customerProfile.getAttributes());
        request.responseContent(List.of(CustomerProfileIntegrationRequestV2.ResponseContentEnum.CUSTOMERPROFILE));

        boolean enableRuleEngine = true;
        boolean dryRun = true;

        return integrationApi.updateCustomerProfileV2(
                customerProfile.getIntegrationId(),
                request,
                enableRuleEngine,
                dryRun
        );
    }



}
