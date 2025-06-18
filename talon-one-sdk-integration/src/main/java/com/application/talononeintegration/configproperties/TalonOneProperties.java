package com.application.talononeintegration.configproperties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@Data
//@PropertySource("classpath:talon.yml")
@ConfigurationProperties(prefix="talon.api")
public class TalonOneProperties {

    private String baseUrl;
    private String key;
}
