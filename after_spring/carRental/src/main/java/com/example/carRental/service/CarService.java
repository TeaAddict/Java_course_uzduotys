package com.example.carRental.service;

import com.example.carRental.dto.CarRequestDTO;
import com.example.carRental.model.Car;
import com.example.carRental.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {

  private final CarRepository carRepository;

  @Autowired
  public CarService(CarRepository carRepository) {
    this.carRepository = carRepository;
  }

  public List<Car> findAllCars() {
    return carRepository.findAll();
  }

  public Car saveCar(Car car) {
    return carRepository.save(car);
  }
}
