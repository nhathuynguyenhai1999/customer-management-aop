package com.codegym.module4.customermanagementthymeleaf.Service.iml;

import com.codegym.module4.customermanagementthymeleaf.Exception.DuplicateEmailException;
import com.codegym.module4.customermanagementthymeleaf.Exception.DuplicateProductCodeException;
import com.codegym.module4.customermanagementthymeleaf.Exception.EntityNotFoundException;
import com.codegym.module4.customermanagementthymeleaf.Model.Player;
import com.codegym.module4.customermanagementthymeleaf.Model.Positions;
import com.codegym.module4.customermanagementthymeleaf.Repository.IPlayerRepository;
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

    /*
    @Override
    public void save(Player customer) throws DuplicateEmailException {
        try {
            iCustomerRepository.save(customer);
        } catch (DataIntegrityViolationException e){
            throw new DuplicateEmailException();
        }
    }

     */
    @Override
    public Player save(Player player) {
        if(iCustomerRepository.existsById(player.getId())) {
            throw new DuplicateProductCodeException("Player id already exists" + player.getId());
        }
        return iCustomerRepository.save(player);
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
    // add aop exception
    public Player findByID(Long id){
        return iCustomerRepository.findById(id).orElseThrow(()-> new EntityNotFoundException("Cầu thủ có ID như thế đéo thấy" + id));
    }
}
