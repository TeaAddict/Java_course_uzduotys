package com.example.carRental.controller;

import com.example.carRental.dto.CarMapper;
import com.example.carRental.dto.CarRequestDTO;
import com.example.carRental.dto.CarResponseDTO;
import com.example.carRental.model.Car;
import com.example.carRental.service.CarService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class CarController {

  private final CarService carService;

  public CarController(CarService carService) {
    this.carService = carService;
  }

  @GetMapping("/cars")
  public ResponseEntity<List<Car>> getCars() {
    return ResponseEntity.ok(carService.findAllCars());
  }

  @PostMapping("/cars")
  public ResponseEntity<CarResponseDTO> saveCar(@Valid @RequestBody CarRequestDTO carRequestDTO) {
    Car savedCar = carService.saveCar(CarMapper.toCar(carRequestDTO));

    return ResponseEntity.created(
                    ServletUriComponentsBuilder.fromCurrentRequest()
                            .path("/{id}")
                            .buildAndExpand(savedCar.getId())
                            .toUri())
            .body(CarMapper.toCarResponseDTO(savedCar));
  }

  @PutMapping("/cars/{id}")
  public ResponseEntity<CarResponseDTO> updateCar(@PathVariable long id, @Valid @RequestBody CarRequestDTO carRequestDTO) {
    Optional<Car> car = carService.findCarById(id);

    if (car.isEmpty()) {
      return ResponseEntity.notFound().build();
    }

    CarMapper.updateCarFromDTO(car.get(), carRequestDTO);

    return ResponseEntity.ok(CarMapper.toCarResponseDTO(car.get()));
  }
}
