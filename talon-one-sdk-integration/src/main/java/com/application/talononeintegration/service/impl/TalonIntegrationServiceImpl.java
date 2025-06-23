package com.application.talononeintegration.service.impl;

import com.application.talononeintegration.DTO.CustomerProfileRequest;
import com.application.talononeintegration.DTO.CustomerSessionRequest;
import com.application.talononeintegration.service.TalonIntegrationService;
import one.talon.ApiException;
import one.talon.api.IntegrationApi;
import one.talon.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.threeten.bp.OffsetDateTime;

import java.util.ArrayList;
import java.util.List;

@Service
public class TalonIntegrationServiceImpl implements TalonIntegrationService {

    private final IntegrationApi integrationApi;

    @Autowired
    public TalonIntegrationServiceImpl(IntegrationApi integrationApi) {
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


    @Override
    public IntegrationStateV2 updateCustomerSession(CustomerSessionRequest customerSession) throws ApiException {

        List<CartItem> cartItems = new ArrayList<>();

        cartItems = customerSession.getCartItems()
                .stream()
                .map(cartItem ->{
                    return new CartItem()
                            .sku(cartItem.getSku())
                            .quantity(cartItem.getQuantity())
                            .price(cartItem.getPrice())
                            .name(cartItem.getProductName())
                            .category(cartItem.getCategory())
                            .attributes(cartItem.getAttributes());

                }).toList();



        NewCustomerSessionV2 session = new NewCustomerSessionV2();
        session.profileId(customerSession.getProfileId());
        session.couponCodes(customerSession.getCouponCodes());
        session.cartItems(cartItems);
        session.state(NewCustomerSessionV2.StateEnum
                .valueOf(String.valueOf(customerSession.getState())));

        IntegrationRequest request = new IntegrationRequest();
        request.customerSession(session);

        return integrationApi.updateCustomerSessionV2(
                customerSession.getSessionId(),
                request,
                true,
                OffsetDateTime.now()
        );
    }
}
