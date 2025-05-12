package com.scaler.userservicejan25.security.services;

import com.scaler.userservicejan25.models.Role;
import org.springframework.security.core.GrantedAuthority;

public class CustomGrantedAuthority implements GrantedAuthority {
    private String role;

    public CustomGrantedAuthority(Role role) {
        this.role = role.getValue();
    }

    @Override
    public String getAuthority() {
        return role;
    }
}
