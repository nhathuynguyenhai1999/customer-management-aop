package com.codegym.module4.customermanagementthymeleaf.Service.iml;

import com.codegym.module4.customermanagementthymeleaf.exception.DuplicateEmailException;
import com.codegym.module4.customermanagementthymeleaf.model.Player;
import com.codegym.module4.customermanagementthymeleaf.model.Positions;
import com.codegym.module4.customermanagementthymeleaf.repository.IPlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class PlayerService implements IPlayerService {
    @Autowired
    private IPlayerRepository iCustomerRepository;


    @Override
    public Iterable<Player> findAll() {
        return iCustomerRepository.findAll();
    }

    @Override
    public void save(Player customer) throws DuplicateEmailException {
        try {
            iCustomerRepository.save(customer);
        } catch (DataIntegrityViolationException e){
            throw new DuplicateEmailException();
        }
    }

    @Override
    public Optional<Player> findById(Long id) {
        return iCustomerRepository.findById(id);
    }

    @Override
    public void remove(Long id) {
        iCustomerRepository.deleteById(id);
    }

    @Override
    public Iterable<Player> findAllByProvince(Positions province) {
        return iCustomerRepository.findAllByProvince(province);
    }

    @Override
    public Page<Player> findAll(Pageable pageable) {
        return iCustomerRepository.findAll(pageable);
    }

    @Override
    public List<Player> findAll1() throws Exception {
        throw new Exception("a dummy exception");
    }

    @Override
    public Player findOne(Long id) throws Exception {
        Player player = iCustomerRepository.findById(id).get();
        if (player.getFirstName() == null || player.getLastName() == null){
            throw new Exception("Player not found!");
        }
        return player;
    }

    @Override
    public Page<Player> findAllByFirstNameContaining(Pageable pageable, String name) {
        return iCustomerRepository.findAllByFirstNameContainingOrLastNameContaining(pageable, name, name);
    }
}
