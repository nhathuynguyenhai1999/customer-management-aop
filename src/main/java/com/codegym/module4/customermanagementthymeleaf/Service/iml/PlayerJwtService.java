package com.codegym.module4.customermanagementthymeleaf.Service.iml;

import com.codegym.module4.customermanagementthymeleaf.DTO.PlayerDTO;
import com.codegym.module4.customermanagementthymeleaf.Model.Player;
import com.codegym.module4.customermanagementthymeleaf.Model.PlayerPrinciple;
import com.codegym.module4.customermanagementthymeleaf.Repository.IPlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PlayerJwtService implements PlayerJwtService1 {
    @Autowired
    private IPlayerRepository playerRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public List<PlayerDTO> findAll() {
        List<PlayerDTO> playerDTOs = new ArrayList<>();
        for (Player player : playerRepository.findAll()) {
            playerDTOs.add(toDTO(player));
        }
        return playerDTOs;
    }

    public PlayerDTO findById(Long id) {
        Optional<Player> playerOptional = playerRepository.findById(id);
        return playerOptional.map(this::toDTO).orElse(null);
    }

    public Player findByUsername(String username) {
        return playerRepository.findByUsername(username);
    }

    public boolean add(Player player) {
        String encodedPassword = passwordEncoder.encode(player.getLastName());
        player.setLastName(encodedPassword);
        playerRepository.save(player);
        return true;
    }

    public void delete(Long id) {
        playerRepository.deleteById(id);
    }

    /*
    public UserDetails loadUserByUsername(String username) {
        Player = playerRepository.findByUsername(username);
        if (player != null) {
            return PlayerPrinciple.build(player);
        }
        return null;
    }

     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Player user = playerRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
        return new org.springframework.security.core.userdetails.User(
                user.getFirstName(),
                user.getLastName(),
                // You may need to map your roles to GrantedAuthority objects here
                AuthorityUtils.createAuthorityList("ROLE_ADMIN", "ROLE_USER")
        );
    }

    public PlayerDTO toDTO(Player player) {
        return new PlayerDTO(player.getId(), player.getFirstName(), player.getLastName());
    }
}
