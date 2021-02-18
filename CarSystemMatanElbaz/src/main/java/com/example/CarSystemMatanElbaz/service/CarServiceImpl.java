package com.example.CarSystemMatanElbaz.service;

import com.example.CarSystemMatanElbaz.controller.ex.CannotCreateException;
import com.example.CarSystemMatanElbaz.controller.ex.CarDoestExistsException;
import com.example.CarSystemMatanElbaz.model.Car;
import com.example.CarSystemMatanElbaz.repo.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class CarServiceImpl implements CarService {

    private CarRepository carRepository;

    @Autowired
    public CarServiceImpl(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Override
    public Car findCarById(long id) throws CarDoestExistsException {
        Optional<Car> car = carRepository.findById(id);
        if (!car.isPresent()) {
            throw new CarDoestExistsException(String.format("Car with id %d does not exists.", id));
        }
        return car.get();
    }


    @Override
    public List<Car> findAllCars() {
        return carRepository.findAll();
    }

    @Override
    public void deleteCarById(long id) throws CarDoestExistsException {
        boolean couponDeleted = false;
        for (Car car : carRepository.findAll()) {
            if (car.getCarId() == id) {
                carRepository.deleteById(id);
                couponDeleted = true;
            }
        }
        if (!couponDeleted) {
            throw new CarDoestExistsException(String.format("Car doesn't exists"));
        }
    }

    @Override
    public Car createCar(Car car) throws CannotCreateException {

        if (car != null) {
            for (Car c : carRepository.findAll()) {
                if (c.getLicensePlate().equals(car.getLicensePlate())) {
                    throw new CannotCreateException(String.format("Car with license plate %s already exists", car.getLicensePlate()));
                }
            }

            car.setEditDate(LocalDate.now());
            System.out.println(car.isSuv());
            return carRepository.save(car);
        }
        throw new CannotCreateException(String.format("Cannot create an empty Car"));
    }

    @Override
    public Car updateCar(long carId, Car car) throws CarDoestExistsException {
        Optional<Car> carById = carRepository.findById(carId);
        if (!carById.isPresent()) {
            throw new CarDoestExistsException(String.format("Car with id %d does not exists.", carId));
        }
        car.setCarId(carId);
        car.setEditDate(LocalDate.now());
        return carRepository.save(car);
    }
}
