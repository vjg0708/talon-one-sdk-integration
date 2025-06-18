package com.application.talononeintegration.DTO;

import com.fasterxml.jackson.databind.annotation.EnumNaming;
import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class CustomerProfileRequest {

    private String integrationId;

    private Map<String, Object> attributes;

    private List<ResponseContent> responseContents;

    private enum ResponseContent{

        customerProfile, triggeredCampaigns, loyalty, event, integration_state
    }

}
