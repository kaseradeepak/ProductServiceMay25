package com.scaler.productservicemay25.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ApplicationConfig {
    @Bean
    public RestTemplate createRestTemplateBean() {
        return new RestTemplate();
    }
}
