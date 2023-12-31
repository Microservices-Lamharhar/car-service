package com.microservices.car.controller;



import com.microservices.car.model.Car;
import com.microservices.car.service.ICarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cars")
public class CarController {
  @Autowired
  private ICarService carService;

  @GetMapping("")
  public ResponseEntity<?> getAllCars() {
    return new ResponseEntity<>(carService.findAll(), HttpStatus.OK);
  }

  @PostMapping("/save")
  public ResponseEntity<?> addCar(@RequestBody Car car) {
    // Assigning ID (for demo purposes)
    var savedCar = carService.save(car);

    return new ResponseEntity<>(savedCar, HttpStatus.OK);
  }

  @GetMapping("/get/{id}")
  public ResponseEntity<?> getCarById(@PathVariable Long id) {
    return new ResponseEntity<>(carService.findById(id), HttpStatus.OK);
  }

  @PutMapping("/update")
  public ResponseEntity<?> updateCar(@RequestBody Car updatedCar) {
    return new ResponseEntity<>(carService.update(updatedCar), HttpStatus.OK);
  }

  @DeleteMapping("/delete/{id}")
  public ResponseEntity<String> deleteCar(@PathVariable Long id) {
    // update car availability
    // interaction with car service
    carService.deleteById(id);
    return ResponseEntity.ok("Car deleted successfully!");
  }
}
