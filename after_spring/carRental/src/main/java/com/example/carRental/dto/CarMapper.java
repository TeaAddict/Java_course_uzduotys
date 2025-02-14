package com.example.carRental.dto;

import com.example.carRental.model.Car;

public class CarMapper {

  public static Car toCar(CarRequestDTO carRequestDTO) {
    return new Car(
            carRequestDTO.brand(),
            carRequestDTO.model(),
            carRequestDTO.year(),
            carRequestDTO.status()
    );
  }

}
//private String brand;
//private String model;
//private int year;
//private String status;