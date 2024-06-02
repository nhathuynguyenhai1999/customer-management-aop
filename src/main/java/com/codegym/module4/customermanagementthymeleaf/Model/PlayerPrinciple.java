package com.codegym.module4.customermanagementthymeleaf.Model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


public class PlayerPrinciple implements UserDetails {

    private static final long serialVersionUID = 1L;
    private final String firstname;
    private final String lastname;
    private Collection<? extends GrantedAuthority> roles;

    public PlayerPrinciple(String firstname, String lastname, List<GrantedAuthority> authorities) {
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public static PlayerPrinciple build(Player user) {
        List<GrantedAuthority> authorities = new ArrayList<>();
        for (Positions role : user.getPositionsSet()) {
            authorities.add(new SimpleGrantedAuthority(role.getName()));
        }

        return new PlayerPrinciple(user.getFirstName(),
                user.getLastName(),
                authorities);
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles;
    }

    @Override
    public String getPassword() {
        return lastname;
    }

    @Override
    public String getUsername() {
        return firstname;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
