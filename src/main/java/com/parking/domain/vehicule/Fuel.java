package com.parking.domain.vehicule;

public enum Fuel {
    PETROL(1.0),
    LPG(1.07);

    private final double rateToBePaid;

    Fuel(double rateToBePaid) {
        this.rateToBePaid = rateToBePaid;
    }

    public double rateToBePaid() {
        return rateToBePaid;
    }
}
