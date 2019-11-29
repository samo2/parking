package com.parking.domain.vehicule;

public enum Type {
    CAR(1.0),
    MOTORBIKE(0.5);

    private final double rateToBePaid;

    Type(double rateToBePaid) {
        this.rateToBePaid = rateToBePaid;
    }

    public double rateToBePaid() {
        return rateToBePaid;
    }
}
