package com.company.CloudStorage.domain;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    ;

    @Override
    public String getAuthority() {
        return null;
    }
}