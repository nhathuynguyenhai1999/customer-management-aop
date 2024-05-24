package com.codegym.module4.customermanagementthymeleaf.Service.iml;

import com.codegym.module4.customermanagementthymeleaf.Model.Player;
import com.codegym.module4.customermanagementthymeleaf.Model.Positions;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IPlayerService extends IGenerateService<Player> {
    Iterable<Player> findAllByProvince(Positions province);
    Page<Player> findAll(Pageable pageable);
    List<Player> findAll1() throws Exception;
    Player findOne(Long id) throws Exception;
    Page<Player> findAllByFirstNameContaining(Pageable pageable, String name);
}
