package com.example.CarSystemMatanElbaz.service;

import com.example.CarSystemMatanElbaz.controller.ex.CannotCreateException;
import com.example.CarSystemMatanElbaz.controller.ex.CarDoestExistsException;
import com.example.CarSystemMatanElbaz.model.Car;

import java.util.List;

public interface CarService {

    /**
     * Find car by id.
     *
     * @param id the id of the car.
     * @return The cae to find.
     */
    Car findCarById(long id) throws CarDoestExistsException;

    /**
     * Find all cars from data base.
     *
     * @return List of all cars .
     */
    List<Car> findAllCars();

    void deleteCarById(long id) throws CarDoestExistsException;

    /**
     * Add a new car , the car will be insert to the data
     * base, the editDate must changed to current date.
     *
     * @param car the car to create.
     * @return The created Car
     */
    Car createCar(Car car) throws CannotCreateException;

    Car updateCar(long carId, Car car) throws CarDoestExistsException;

}
