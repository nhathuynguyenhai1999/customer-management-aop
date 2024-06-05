package com.codegym.module4.customermanagementthymeleaf.model;

import javax.persistence.*;

@Entity
@Table(name = "players")
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;

    @ManyToOne
    @JoinColumn(name = "positions_id")
    private Positions province;
    private String img;
    private String imagePath;

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Player() {
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

    public String getImagePath(){
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }
}