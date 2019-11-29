package com.parking.domain.vehicule;

public class Car implements Vehicule {
    private final Fuel fuel;

    public Car(Fuel fuel) {
        this.fuel = fuel;
    }

    @Override
    public Type getType() {
        return Type.CAR;
    }

    @Override
    public Fuel getFuel() {
        return fuel;
    }
}
