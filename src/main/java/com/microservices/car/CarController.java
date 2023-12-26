package com.microservices.car;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cars")
public class CarController {
  private final List<Car> carInventory = new ArrayList<>();
  @Autowired
  private CarRepository carRepository;

  @GetMapping
  public List<Car> getAllCars() {
    return carInventory;
  }

  @GetMapping("/{id}")
  public ResponseEntity<Car> getCarById(@PathVariable Long id) {
    Optional<Car> car = carRepository.findById(id);
    return car.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
  }

  @PostMapping
  public ResponseEntity<String> addCar(@RequestBody Car car) {
    car.setId_car(generateCarId()); // Assigning ID (for demo purposes)
    carRepository.save(car);
    return ResponseEntity.ok("Car added successfully!");
  }

  @PutMapping("/{id}")
  public ResponseEntity<String> updateCar(@PathVariable Long id, @RequestBody Car updatedCar) {
    for (Car car : carInventory) {
      if (car.getId_car().equals(id)) {
        car.setMake(updatedCar.getMake());
        car.setModel(updatedCar.getModel());
        car.setYear(updatedCar.getYear());
        car.setAvailable(updatedCar.isAvailable());
        return ResponseEntity.ok("Car updated successfully!");
      }
    }
    return ResponseEntity.notFound().build();
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<String> deleteCar(@PathVariable Long id) {
    Iterator<Car> iterator = carInventory.iterator();
    while (iterator.hasNext()) {
      Car car = iterator.next();
      if (car.getId_car().equals(id)) {
        iterator.remove();
        return ResponseEntity.ok("Car deleted successfully!");
      }
    }
    return ResponseEntity.notFound().build();
  }

  private Long generateCarId() {
    // Logic to generate a unique ID for a new car (simulation)
    return (long) (carInventory.size() + 1);
  }
}
