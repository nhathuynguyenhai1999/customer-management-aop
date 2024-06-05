package com.codegym.module4.customermanagementthymeleaf.repository;

import com.codegym.module4.customermanagementthymeleaf.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
