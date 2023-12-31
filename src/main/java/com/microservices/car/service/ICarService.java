package com.microservices.car.service;

import com.microservices.car.model.Car;

import java.util.List;

public interface ICarService {
    List<Car> findAll();
    Car findById(Long carId);
    Car save(Car car);
    Car update(Car car);
    void deleteById(Long carId);
}
