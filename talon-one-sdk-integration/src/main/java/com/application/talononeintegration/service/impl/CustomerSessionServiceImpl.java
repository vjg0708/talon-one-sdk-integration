package com.application.talononeintegration.service.impl;

import com.application.talononeintegration.DTO.CustomerSessionRequest;
import com.application.talononeintegration.service.CustomerSessionService;
import one.talon.ApiException;
import one.talon.api.IntegrationApi;
import one.talon.model.CartItem;
import one.talon.model.IntegrationRequest;
import one.talon.model.IntegrationStateV2;
import one.talon.model.NewCustomerSessionV2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.threeten.bp.OffsetDateTime;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerSessionServiceImpl implements CustomerSessionService {

    private final IntegrationApi integrationApi;

    @Autowired
    public CustomerSessionServiceImpl(IntegrationApi integrationApi) {
        this.integrationApi = integrationApi;
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
