package com.parking.domain.bill;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode
public class Bill {
    private final Double exactAmount;

    public Bill(Double exactAmount) {
        this.exactAmount = exactAmount;
    }

    public Double amountDue() {
        if (valueIsRound()) {
            return exactAmount;
        }
        return roundedDownValue() + 0.5;
    }

    private boolean valueIsRound() {
        return exactAmount % 0.5 == 0;
    }

    private double roundedDownValue() {
        return exactAmount - exactAmount % 0.5;
    }
}
