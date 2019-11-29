package com.parking.domain;

import com.parking.domain.bill.Bill;
import com.parking.domain.bill.BillFactory;
import com.parking.domain.vehicule.Fuel;
import com.parking.domain.vehicule.Motorbike;
import com.parking.domain.duration.ParkingDuration;
import com.parking.domain.vehicule.Car;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import java.time.LocalDateTime;
import java.time.LocalTime;

public class CompleteRealisticTest {

    /******************************************************
     * >>> TESTS ONLY FOR THE EXERCISE (not prod ready) >>>
     ******************************************************/
    
    /*
    1 voiture essence arrivée à 13h24 et repartie à 15h10

    Output 1
    - véhicule : voiture essence
    - temps passé : 1h46
    - montant dû  : 2 euros
    */
    @Test
    public void a_car_using_petrol_that_parks_1h46_should_pay_2€() {
        LocalTime arrivalTime = LocalTime.of(13, 24);
        LocalTime departureTime = LocalTime.of(15, 10);
        ParkingDuration duration = ParkingDuration.from(arrivalTime, departureTime);

        Bill bill = BillFactory.from(duration, new Car(Fuel.PETROL));
        Double amountDue = bill.amountDue();

        Assertions.assertThat(amountDue).isEqualTo(2.0);
    }

    /*
    1 moto essence arrivée à 19h30 et repartie à 00h37

    Output 2
    - véhicule : moto essence
    - temps passé : 5h07
    - montant dû : 5,5 euros
    */
    @Test
    public void a_moto_using_petrol_that_park_5h07_should_pay_5€50() {
        LocalDateTime arrivalTime = LocalDateTime.of(2019, 12, 31, 19, 30);
        LocalDateTime departureTime = LocalDateTime.of(2020, 01, 01, 00, 37);
        ParkingDuration duration = ParkingDuration.from(arrivalTime, departureTime);

        Bill bill = BillFactory.from(duration, new Motorbike(Fuel.PETROL));
        Double amountDue = bill.amountDue();

        Assertions.assertThat(amountDue).isEqualTo(5.5);
    }

    /*
    1 voiture GPL arrivée à  7h43 et repartie à 15h10

    Output 3
    - véhicule : voiture GPL
    - temps passé : 7h27
    - montant dû : 18 euros
    */
    @Test
    public void a_car_using_lpg_that_park_7h27_should_pay_18€() {
        LocalTime arrivalTime = LocalTime.of(7, 43);
        LocalTime departureTime = LocalTime.of(15, 10);
        ParkingDuration duration = ParkingDuration.from(arrivalTime, departureTime);

        Bill bill = BillFactory.from(duration, new Car(Fuel.LPG));
        Double amountDue = bill.amountDue();

        Assertions.assertThat(amountDue).isEqualTo(18);
    }
}
