package com.example.CRUD.APP.user;

import jakarta.persistence.*;


@Entity
@Table(name ="users")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    private String email;

    // Default constructor (no arguments)
    public Users() {
        // No-argument constructor for JPA
    }

    public Users(long id, String name , String email){
        this.email=email;
        this.name=name;
        this.id=id;
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

