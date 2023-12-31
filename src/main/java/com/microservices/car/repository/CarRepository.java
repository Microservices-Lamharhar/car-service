package com.microservices.car.repository;
import com.microservices.car.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * BookingRepository
 */
@Repository
public interface CarRepository extends JpaRepository<Car, Long> {

}
