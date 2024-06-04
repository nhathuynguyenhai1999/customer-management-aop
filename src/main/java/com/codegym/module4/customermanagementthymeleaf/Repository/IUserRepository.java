package com.codegym.module4.customermanagementthymeleaf.Repository;

import com.codegym.module4.customermanagementthymeleaf.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
