package com.example.periodicals.dao.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;

@Getter
@AllArgsConstructor
public enum Role implements GrantedAuthority {
    ROLE_USER("Пользователь"),
    ROLE_ADMIN("Администратор");

    private String name;

    @Override
    public String getAuthority() {
        return name();
    }
}
