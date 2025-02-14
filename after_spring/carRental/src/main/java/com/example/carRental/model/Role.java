package com.example.carRental.model;

import jakarta.persistence.*;

@Entity
@Table(name = "roles")
public class Role {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  private String name;

}

//CREATE TABLE roles (
//        id BIGINT PRIMARY KEY AUTO_INCREMENT,
//        name VARCHAR(100) NOT NULL
//);