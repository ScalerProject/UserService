package com.scaler.userservicejan25.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfiguration {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        try {
            httpSecurity
                    .authorizeHttpRequests((requests) -> requests
                            .anyRequest().permitAll()
                    )
                    .cors(cors -> cors.disable())
                    .csrf(csrf -> csrf.disable());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return httpSecurity.build();
    }
}