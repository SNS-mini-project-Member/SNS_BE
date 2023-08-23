package com.example.sns.dto;

import org.springframework.security.core.GrantedAuthority;

public enum UserLevel implements GrantedAuthority {
    LEVEL_OK,
    LEVEL_NO,
    LEVEL_ADMIN;

    @Override
    public String getAuthority() {
        return name();
    }
}

