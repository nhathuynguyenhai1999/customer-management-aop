package com.codegym.module4.customermanagementthymeleaf.jwt;

import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

public class JwtResponse {
    private Long id;
    private String first_name;
    private String last_name;
    private String token;
    private final Collection<? extends GrantedAuthority> authorities;

    public JwtResponse(Collection<? extends GrantedAuthority> authorities, Long id, String first_name, String last_name, String token) {
        this.authorities = authorities;
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.token = token;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public JwtResponse(Collection<? extends GrantedAuthority> authorities) {
        this.authorities = authorities;
    }
}
