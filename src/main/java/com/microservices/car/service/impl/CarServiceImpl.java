package com.microservices.car.service.impl;

import com.microservices.car.exceptions.CarNotFoundException;
import com.microservices.car.model.Car;
import com.microservices.car.repository.CarRepository;
import com.microservices.car.service.ICarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarServiceImpl implements ICarService {
    @Autowired
    private CarRepository carRepository;

    @Override
    public List<Car> findAll() {
        return carRepository.findAll();
    }

    @Override
    public Car findById(Long carId) {
        return carRepository.findById(carId).orElseThrow(() -> new CarNotFoundException(carId));
    }

    @Override
    public Car save(Car car) {
        return carRepository.save(car);
    }

    @Override
    public Car update(Car car) {
        return carRepository.save(car);
    }

    @Override
    public void deleteById(Long carId) {
        carRepository.deleteById(carId);
    }
}
