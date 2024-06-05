package com.codegym.module4.customermanagementthymeleaf.model;

import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import java.util.Set;

public class PlayerForm {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;

    @ManyToOne
    @JoinColumn(name = "positions_id")
    private Positions province;
    private MultipartFile img;

    private Set<Positions> positionsSet;

    public MultipartFile getImg() {
        return img;
    }

    public void setImg(MultipartFile img) {
        this.img = img;
    }

    public PlayerForm(){}

    public PlayerForm(Long id, String firstName, String lastName, Positions province, MultipartFile img, Set<Positions> positionsSet) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.province = province;
        this.img = img;
        this.positionsSet = positionsSet;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Positions getProvince() {
        return province;
    }

    public void setProvince(Positions province) {
        this.province = province;
    }
}
