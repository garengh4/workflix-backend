package com.infy.workflix;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

public class WorkflixConfig {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
