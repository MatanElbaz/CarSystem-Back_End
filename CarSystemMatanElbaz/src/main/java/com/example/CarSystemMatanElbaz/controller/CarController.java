package com.example.CarSystemMatanElbaz.controller;

import com.example.CarSystemMatanElbaz.controller.ex.CannotCreateException;
import com.example.CarSystemMatanElbaz.controller.ex.CarDoestExistsException;
import com.example.CarSystemMatanElbaz.model.Car;
import com.example.CarSystemMatanElbaz.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"http://localhost:4200"}, allowCredentials = "true")
@RestController
@RequestMapping("/api")
public class CarController {
    CarService carService;

    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("/car/{id}")
    public ResponseEntity<Car> findCarById(@PathVariable long id)
            throws CarDoestExistsException {
        Car carById = carService.findCarById(id);
        if (!(carById != null)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(carById);
    }

    @GetMapping("/cars/all")
    public ResponseEntity<List<Car>> findAllCars() throws CarDoestExistsException {
        List<Car> allCars = carService.findAllCars();
        if (allCars.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(allCars);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteCarById(@PathVariable long id) throws CarDoestExistsException {
        carService.deleteCarById(id);
        return "Car deleted";
    }

    @PutMapping("/add")
    public ResponseEntity<Car> createCar(@RequestBody Car car) throws CarDoestExistsException,
            CannotCreateException {
        Car newCar = carService.createCar(car);

        return ResponseEntity.ok(newCar);
    }

    @PutMapping("/update/{carId}")
    public ResponseEntity<Car> updateCar(@PathVariable long carId,@RequestBody Car car) throws CarDoestExistsException{
        Car updatedCar = carService.updateCar(carId, car);
        return ResponseEntity.ok(updatedCar);
    }


}
