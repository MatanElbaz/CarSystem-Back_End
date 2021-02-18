package com.example.CarSystemMatanElbaz.repo;

import com.example.CarSystemMatanElbaz.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {
}
