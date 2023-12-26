package com.microservices.car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * BookingRepository
 */
@Repository
public interface CarRepository extends JpaRepository<Car, Long> {

}
