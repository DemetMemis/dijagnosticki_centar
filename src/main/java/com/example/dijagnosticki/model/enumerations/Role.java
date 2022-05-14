package com.example.dijagnosticki.model.enumerations;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    ROLE_DOKTOR,
    ROLE_PACIENT,
    ROLE_ADMIN;

    @Override
    public String getAuthority() {
        return name();
    }
}
