package com.application.talononeintegration.DTO;

import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class CustomerSessionRequest {

    private String sessionId;
    private String profileId;
    private List<String> couponCodes;
    private List<CartItem> cartItems;
    private State state;
    private List<ResponseContent> responseContents;

    private enum State{

        open, closed, partially_returned, cancelled
    }

    private enum ResponseContent{

        customerSession, customerProfile, triggeredCampaigns, loyalty, event
    }

}
