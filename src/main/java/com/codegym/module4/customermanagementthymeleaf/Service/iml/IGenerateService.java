package com.codegym.module4.customermanagementthymeleaf.Service.iml;

import com.codegym.module4.customermanagementthymeleaf.exception.DuplicateEmailException;

import java.util.Optional;

public interface IGenerateService<T> {
    Iterable<T> findAll();

    T save(T t) throws DuplicateEmailException;

    T update(T t);

    Optional<T> findById(Long id);

    void remove(Long id);
}
