package com.codegym.module4.customermanagementthymeleaf.Repository;

import com.codegym.module4.customermanagementthymeleaf.Model.Positions;
import org.springframework.data.repository.CrudRepository;

public interface IPositionRepository extends CrudRepository<Positions, Long> {
}