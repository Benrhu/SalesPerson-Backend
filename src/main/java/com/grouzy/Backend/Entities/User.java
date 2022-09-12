package com.grouzy.Backend.Entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class User {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="userId")
    private Long userId;

    @Column(name="username")
    private String username;

    @Column(name="password")
    private String password;

    @Column(name="email")
    private String email;

    @Column(name="phone")
    private String phone;

    @Column(name="address")
    private String address;

    @Column(name="country")
    private String country;

    @Column(name="city")
    private String city;

    @Column(name="postalCode")
    private String postalCode;

    public User() {}

    public User(Long userId, String username, String password, String email, String phone, String address, String country, String city, String postalCode) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.country = country;
        this.city = city;
        this.postalCode = postalCode;
    }
}