package com.fpinjava.introduction.listing01_06;

import org.junit.jupiter.api.Test;


import static com.fpinjava.introduction.listing01_06.Payment.combine;
import static org.junit.jupiter.api.Assertions.*;

public class PaymentCombineTest {
    CreditCard cc = new CreditCard();
    Payment payment0 = new Payment(cc, 50);
    Payment payment1 = new Payment(cc, 100);
    Payment payment2 = new Payment(cc, 150);
    Payment payment3 = new Payment(cc, 200);

    @Test
    public void testInstanceCombine(){
        // method chaining with instance methods is easy to read
        // each combine returns a new Payment instance on which combine can be called again.
        assertEquals(500, payment0.combine(payment1).combine(payment2).combine(payment3).amount);
    }

    @Test
    public void testClassCombine(){
        // method chaining with class methods becomes increasingly difficult to read with each new combine call
        assertEquals(500, combine(combine(combine(payment0, payment1),payment2),payment3).amount);
    }

    @Test
    public void testAttemptToCombinePaymentsOfDifferentCreditCards(){
        var exception = assertThrows(IllegalStateException.class,
                () -> new Payment(new CreditCard(), 20).combine(payment0));
        assertEquals("Cards don't match.", exception.getMessage());
    }

    @Test
    public void testInstanceCombineSameCard(){

        // We can only combine payments that use the same credit card
        // The resulting combined payment should have the same card as well
        assertSame(cc, payment0.combine(payment1).combine(payment2).combine(payment3).creditCard);

        // as the CreditCard has no hashcode and equals state comparison methods equals is based on sameness
        assertEquals(cc, payment0.combine(payment1).combine(payment2).combine(payment3).creditCard);
    }

}
