package com.microservices.car.exceptions;

public class CarNotFoundException extends RuntimeException{
    public CarNotFoundException(Long id) {
        super("Car With id : " + id + " not found !");
    }
}
