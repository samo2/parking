package com.parking.domain.bill;

import com.parking.domain.vehicule.Fuel;
import com.parking.domain.vehicule.Motorbike;
import com.parking.domain.duration.ParkingDuration;
import com.parking.domain.vehicule.Car;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

public class BillFactoryTest {

    @Test
    public void motorbike_pay_50_percent() {
        ParkingDuration duration = mock(ParkingDuration.class);
        given(duration.getBasePrice()).willReturn(100.0);

        Bill bill = BillFactory.from(duration, new Motorbike(Fuel.PETROL));

        assertThat(bill).isEqualTo(new Bill(50.0));
    }

    @Test
    public void gpl_vehicul_pay_107_percent() {
        ParkingDuration duration = mock(ParkingDuration.class);
        given(duration.getBasePrice()).willReturn(100.0);

        Bill bill = BillFactory.from(duration, new Car(Fuel.LPG));

        assertThat(bill).isEqualTo(new Bill(107.0));
    }
}
