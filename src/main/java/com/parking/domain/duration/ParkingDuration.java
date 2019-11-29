package com.parking.domain.duration;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class ParkingDuration {
    private final Duration duration;

    public ParkingDuration(Duration duration) {
        this.duration = duration;
    }

    public static ParkingDuration from(LocalTime arrivalTime, LocalTime departureTime) {
        return new ParkingDuration(Duration.between(arrivalTime, departureTime));
    }

    public static ParkingDuration from(LocalDateTime arrivalTime, LocalDateTime departureTime) {
        return new ParkingDuration(Duration.between(arrivalTime, departureTime));
    }

    public double getBasePrice() {
        if (lessThanOneHour()) {
            return 0;
        }
        return  getHoursStartedBefore4hours() * 2 +
                getHalfHoursStartedAfter4hours() * 1.5;
    }

    private long getHoursStartedBefore4hours() {
        if (duration.toHours() > 3) {
            return 3;
        }
        return duration.toHours();
    }

    private long getHalfHoursStartedAfter4hours() {
        if (duration.toHours() >= 4) {
            long minutesStartedAfter4h = duration.toMinutes() - 60 * 4;
            return minutesStartedAfter4h / 30 + 1;
        }
        return 0;
    }

    private boolean lessThanOneHour() {
        return duration.toHours() == 0;
    }
}
