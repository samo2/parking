package com.parking.domain.duration;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.assertj.core.api.Assertions.assertThat;

public class ParkingDurationTest {

    @DataProvider
    public static Object[][] lessThan1hour() {
        return new Object[][]{
                {Duration.ofMinutes(00)},
                {Duration.ofMinutes(29)},
                {Duration.ofMinutes(59)},
        };
    }

    @Test(dataProvider = "lessThan1hour")
    public void the_first_hour_is_free(Duration duration) {
        ParkingDuration parkingDuration = new ParkingDuration(duration);

        double basePrice = parkingDuration.getBasePrice();

        assertThat(basePrice).isEqualTo(0);
    }

    @DataProvider
    public static Object[][] basePriceCorrespondingToDurationBetween1hourAnd4hours() {
        return new Object[][]{
                {Duration.ofMinutes(1*60 + 00), 2.0},
                {Duration.ofMinutes(1*60 + 59), 2.0},
                {Duration.ofMinutes(2*60 + 00), 4.0},
                {Duration.ofMinutes(2*60 + 59), 4.0},
                {Duration.ofMinutes(3*60 + 00), 6.0},
                {Duration.ofMinutes(3*60 + 59), 6.0},
        };
    }

    @Test(dataProvider = "basePriceCorrespondingToDurationBetween1hourAnd4hours")
    public void between_1h_and_4h_each_hour_started_cost_2€(Duration duration, double expectedBasePriceValue) {
        ParkingDuration parkingDuration = new ParkingDuration(duration);

        double actualBasePrice = parkingDuration.getBasePrice();

        assertThat(actualBasePrice).isEqualTo(expectedBasePriceValue);
    }

    @DataProvider
    public static Object[][] basePriceCorrespondingToDuration4hoursAndAfter() {
        return new Object[][]{
                {Duration.ofMinutes(4*60 + 00), 7.5},
                {Duration.ofMinutes(4*60 + 29), 7.5},
                {Duration.ofMinutes(4*60 + 30), 9.0},
                {Duration.ofMinutes(4*60 + 59), 9.0},
                {Duration.ofMinutes(5*60 + 00), 10.5}
        };
    }

    @Test(dataProvider = "basePriceCorrespondingToDuration4hoursAndAfter")
    public void each_half_hour_started_after_4_hours_cost_1€5(Duration duration, double expectedBasePriceValue) {
        ParkingDuration parkingDuration = new ParkingDuration(duration);

        double actualBasePrice = parkingDuration.getBasePrice();

        assertThat(actualBasePrice).isEqualTo(expectedBasePriceValue);
    }
}
