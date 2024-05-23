package com.codegym.module4.customermanagementthymeleaf.Service.iml;

import com.codegym.module4.customermanagementthymeleaf.Model.Player;
import com.codegym.module4.customermanagementthymeleaf.Model.Positions;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ICustomerService extends IGenerateService<Player> {
    Iterable<Player> findAllByProvince(Positions province);
    Page<Player> findAll(Pageable pageable);
    Page<Player> findAllByFirstNameContaining(Pageable pageable, String name);
}
