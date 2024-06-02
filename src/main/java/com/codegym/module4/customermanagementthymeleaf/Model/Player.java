package com.codegym.module4.customermanagementthymeleaf.Model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "players")
public class Player {
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
    private String img;
    @Column(name = "image_path")
    private String imagePath;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "player_positions",
            joinColumns = @JoinColumn(name = "player_id"),
            inverseJoinColumns = @JoinColumn(name = "position_id")
    )

    private Set<Positions> positionsSet;


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

    public Set<Positions> getPositionsSet() {
        return positionsSet;
    }

    public void setPositionsSet(Set<Positions> positionsSet) {
        this.positionsSet = positionsSet;
    }
}