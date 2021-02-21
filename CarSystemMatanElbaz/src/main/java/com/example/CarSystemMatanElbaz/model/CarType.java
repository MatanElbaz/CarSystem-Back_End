package com.example.CarSystemMatanElbaz.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CarType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    public CarType() {

    }


}
