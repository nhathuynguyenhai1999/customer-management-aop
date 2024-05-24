package com.codegym.module4.customermanagementthymeleaf.Model;

import javax.persistence.*;

@Entity
@Table(name = "positions")
public class Positions {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    private String name;

    public Positions() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(unique = true)


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}