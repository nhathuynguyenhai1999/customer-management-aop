package com.codegym.module4.customermanagementthymeleaf.Service.iml;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface PlayerJwtService1 {
    /*
        public UserDetails loadUserByUsername(String username) {
            Player = playerRepository.findByUsername(username);
            if (player != null) {
                return PlayerPrinciple.build(player);
            }
            return null;
        }

         */
    UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;
}
