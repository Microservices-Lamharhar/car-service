package com.microservices.car;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Car {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id_car;
  private String make;
  private String model;
  private int year;
  private boolean available;

  public Long getId_car() {
    return id_car;
  }

  public void setId_car(Long id_car) {
    this.id_car = id_car;
  }

  public String getMake() {
    return make;
  }

  public void setMake(String make) {
    this.make = make;
  }

  public String getModel() {
    return model;
  }

  public void setModel(String model) {
    this.model = model;
  }

  public int getYear() {
    return year;
  }

  public void setYear(int year) {
    this.year = year;
  }

  public boolean isAvailable() {
    return available;
  }

  public void setAvailable(boolean available) {
    this.available = available;
  }

}
