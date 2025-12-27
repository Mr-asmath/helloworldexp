package com.example.helloworldexp.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "username")
public class Username {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String name;

    // Default constructor (required by JPA)
    public Username() {}

    // Constructor
    public Username(String name) {
        this.name = name;
    }

    // Getters & Setters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
