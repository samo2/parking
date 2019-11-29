package com.parking.domain.bill;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BillTest {

    @Test
    public void amount_due_is_the_exact_ammount_of_the_bill_for_round_value() {
        assertThat(new Bill(1.00).amountDue()).isEqualTo(1.0);
    }

    @Test
    public void amount_due_is_the_exact_ammount_of_the_bill_for_round_value_plus_50_cent() {
        assertThat(new Bill(1.50).amountDue()).isEqualTo(1.50);
    }

    @DataProvider
    public static Object[][] notRoundAmountsAndTheAmountDueCorresponding() {
        return new Object[][]{
                {1.01, 1.50},
                {1.49, 1.50},
                {1.51, 2.00},
                {1.99, 2.00},
        };
    }

    @Test(dataProvider = "notRoundAmountsAndTheAmountDueCorresponding")
    public void the_amount_due_is_rounded_up_to_the_next_50_centimes_otherwise(double exactAmount, double expectedAmountDue) {
        Bill bill = new Bill(exactAmount);

        Double amountDue = bill.amountDue();

        assertThat(amountDue).isEqualTo(expectedAmountDue);
    }

    @Test
    public void realisticTest() {

    }
}
