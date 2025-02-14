package com.example.carRental.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "users")
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  private String username;
  private String password;

  @OneToMany(cascade = CascadeType.ALL)
  @JoinColumn(name = "user_id")
  private List<Role> roles;
}

//CREATE TABLE users (
//        id BIGINT PRIMARY KEY AUTO_INCREMENT,
//        username VARCHAR(100) NOT NULL,
//password VARCHAR(100) NOT NULL
//);