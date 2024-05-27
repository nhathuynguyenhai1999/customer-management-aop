package com.codegym.module4.customermanagementthymeleaf.Repository;

import com.codegym.module4.customermanagementthymeleaf.Model.Player;
import com.codegym.module4.customermanagementthymeleaf.Model.Positions;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

public interface IPlayerRepository extends CrudRepository<Player,Long> {
    Iterable<Player> findAllByProvince(Positions province);

    Page<Player> findAll(Pageable pageable);

    Page<Player> findAllByFirstNameContainingOrLastNameContaining(Pageable pageable, String firstName, String lastName);

    boolean existsById(Long id);
}
