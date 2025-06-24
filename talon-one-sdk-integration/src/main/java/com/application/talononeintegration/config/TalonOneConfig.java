package com.application.talononeintegration.config;

import com.application.talononeintegration.configproperties.TalonOneProperties;
import one.talon.ApiClient;
import one.talon.api.IntegrationApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TalonOneConfig {

    private final TalonOneProperties properties;

    @Autowired
    public TalonOneConfig(TalonOneProperties properties) {

        this.properties = properties;
    }

    @Bean
    public IntegrationApi integrationApi(){

        ApiClient apiClient = new ApiClient("api_key_v1");
        apiClient.setBasePath(properties.getBaseUrl());
        apiClient.setApiKeyPrefix("ApiKey-v1");
        apiClient.setApiKey(properties.getKey());

        return new IntegrationApi(apiClient);
    }
}
