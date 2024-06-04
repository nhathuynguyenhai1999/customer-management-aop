package com.codegym.module4.customermanagementthymeleaf.Configuration.service;

import com.codegym.module4.customermanagementthymeleaf.Model.User;
import com.codegym.module4.customermanagementthymeleaf.Repository.IPlayerRepository;
import com.codegym.module4.customermanagementthymeleaf.Repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    private IUserRepository userRepository;

    public User findByUsername(String name) {
        return userRepository.findByUsername(name);
    }

    public UserDetails loadUserByUsername(String username) {
        return UserPrinciple.build(userRepository.findByUsername(username));
    }
}
