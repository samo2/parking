package com.parking.domain.bill;

import com.parking.domain.duration.ParkingDuration;
import com.parking.domain.vehicule.Vehicule;

public class BillFactory {

    private BillFactory() {
    }

    public static Bill from(ParkingDuration duration, Vehicule vehicule) {
        return new Bill(getRealPrice(duration, vehicule));
    }

    private static double getRealPrice(ParkingDuration duration, Vehicule vehicule) {
        return duration.getBasePrice() * vehicule.getRateToBePaid();
    }

}
