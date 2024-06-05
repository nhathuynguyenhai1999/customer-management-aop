package com.codegym.module4.customermanagementthymeleaf.dto;

import com.codegym.module4.customermanagementthymeleaf.model.Positions;

import java.util.Set;

public class PlayerDTO {
    private Long id;
    private String fistname;
    private String lastname;
    private Set<Positions> positionsSet;

    public PlayerDTO(Long id, String fistname, String lastname) {
        this.id = id;
        this.fistname = fistname;
        this.lastname = lastname;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFistname() {
        return fistname;
    }

    public void setFistname(String fistname) {
        this.fistname = fistname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Set<Positions> getPositionsSet() {
        return positionsSet;
    }

    public void setPositionsSet(Set<Positions> positionsSet) {
        this.positionsSet = positionsSet;
    }
}
