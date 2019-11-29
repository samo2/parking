package com.parking.domain.vehicule;

public class Motorbike implements Vehicule {

    private final Fuel fuel;

    public Motorbike(Fuel fuel) {
        this.fuel = fuel;
    }

    @Override
    public Type getType() {
        return Type.MOTORBIKE;
    }

    @Override
    public Fuel getFuel() {
        return fuel;
    }
}
