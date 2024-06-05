package com.codegym.module4.customermanagementthymeleaf.repository;

import com.codegym.module4.customermanagementthymeleaf.model.Player;
import com.codegym.module4.customermanagementthymeleaf.model.Positions;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPlayerRepository extends CrudRepository<Player,Long> {
    Iterable<Player> findAllByProvince(Positions province);

    Page<Player> findAll(Pageable pageable);

    Page<Player> findAllByFirstNameContainingOrLastNameContaining(Pageable pageable, String firstName, String lastName);

    boolean existsById(Long id);

    Player findByUsername(String username);
}
