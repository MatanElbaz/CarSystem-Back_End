package com.example.CarSystemMatanElbaz.model;

import javax.persistence.*;

@Entity
public class CarType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    public CarType() {

    }


}
