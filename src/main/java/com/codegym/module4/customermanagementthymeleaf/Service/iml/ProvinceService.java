package com.codegym.module4.customermanagementthymeleaf.Service.iml;

import com.codegym.module4.customermanagementthymeleaf.Repository.IPositionRepository;
import com.codegym.module4.customermanagementthymeleaf.Model.Positions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class ProvinceService implements IPositionService {

    @Autowired
    private IPositionRepository iProvinceRepository;

    @Override
    public Iterable<Positions> findAll() {
        return iProvinceRepository.findAll();
    }

    @Override
    public Positions save(Positions province) {
         return iProvinceRepository.save(province);
    }

    @Override
    public Optional<Positions> findById(Long id) {
        return iProvinceRepository.findById(id);
    }

    @Override
    public void remove(Long id) {
        iProvinceRepository.deleteById(id);
    }
}
