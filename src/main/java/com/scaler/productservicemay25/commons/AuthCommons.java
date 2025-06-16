package com.scaler.productservicemay25.commons;

import com.scaler.productservicemay25.dtos.UserDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class AuthCommons {
    private RestTemplate restTemplate;

    public AuthCommons(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public UserDto validateToken(String tokenValue) {
        ResponseEntity<UserDto> responseEntity = restTemplate.getForEntity(
                "http://localhost:8080/auth/validate/" + tokenValue,
                UserDto.class
        );

        return responseEntity.getBody();
    }
}
