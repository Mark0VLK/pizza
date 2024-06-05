package com.example.pizza.model;

import jakarta.persistence.*;

import java.security.Timestamp;

@Entity
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 30)
    private String country;

    @Column(nullable = false, length = 40)
    private String city;

    @Column(nullable = false, length = 30)
    private String street;

    @Column(nullable = false, length = 10)
    private String house;

    @Column
    private Integer floor;

    @Column(length = 10)
    private String flat;

    @Column(nullable = false)
    private Timestamp created;

    @Column(nullable = false)
    private Timestamp changed;
}
