package com.codegym.module4.customermanagementthymeleaf.repository;

import com.codegym.module4.customermanagementthymeleaf.model.Positions;
import org.springframework.data.repository.CrudRepository;

public interface IPositionRepository extends CrudRepository<Positions, Long> {
}
