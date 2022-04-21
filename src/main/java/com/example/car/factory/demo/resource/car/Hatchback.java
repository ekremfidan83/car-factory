package com.example.car.factory.demo.resource.car;

public class Hatchback implements ICar {


    private String type;

    @Override
    public String getType() {
        return "Hatchback Car has produced.";
    }
}
