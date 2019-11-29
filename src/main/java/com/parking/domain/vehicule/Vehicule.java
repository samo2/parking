package com.parking.domain.vehicule;

public interface Vehicule {

    Type getType();
    Fuel getFuel();

    default double getRateToBePaid() {
        return getType().rateToBePaid() * getFuel().rateToBePaid();
    }

}
