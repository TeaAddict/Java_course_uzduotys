package com.example.carRental.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "rentals")
public class Rental {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  @ManyToOne
  @JoinColumn(name = "car_id")
  private Car car;

  @ManyToOne
  @JoinColumn(name = "user_id")
  private User user;

  private Date rentalStart;
  private Date rentalEnd;
  private BigDecimal price;

}

//CREATE TABLE rentals (
//        id BIGINT PRIMARY KEY AUTO_INCREMENT,
//        user_id BIGINT NOT NULL,
//        car_id BIGINT NOT NULL,
//        rental_start DATE NOT NULL,
//        rental_end DATE NOT NULL,
//        price DECIMAL NOT NULL
//);