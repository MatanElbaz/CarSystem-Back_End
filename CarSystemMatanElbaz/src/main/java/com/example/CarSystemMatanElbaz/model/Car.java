package com.example.CarSystemMatanElbaz.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "car")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long carId;

    private String licensePlate;

    private int carType;

    @Column(name = "4x4")
    private boolean is4x4;

    private int engineCapacity;

    private int year;

    private String note;

    private int status;

    private LocalDate careDate;

    private LocalDate editDate;

    public Car() {
    }

    public Car(long carId) {
        this.carId = carId;
    }

    public long getCarId() {
        return carId;
    }

    public void setCarId(long carId) {
        this.carId = carId;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public int getCarType() {
        return carType;
    }

    public void setCarType(int carType) {
        this.carType = carType;
    }

    public boolean is4x4() {
        return is4x4;
    }

    public void set4x4(boolean SUV) {
        this.is4x4 = SUV;
    }

    public int getEngineCapacity() {
        return engineCapacity;
    }

    public void setEngineCapacity(int engineCapacity) {
        this.engineCapacity = engineCapacity;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public LocalDate getCareDate() {
        return careDate;
    }

    public void setCareDate(LocalDate careDate) {
        this.careDate = careDate;
    }

    public LocalDate getEditDate() {
        return editDate;
    }


    public void setEditDate(LocalDate editDate) {
        this.editDate = editDate;
    }
}
