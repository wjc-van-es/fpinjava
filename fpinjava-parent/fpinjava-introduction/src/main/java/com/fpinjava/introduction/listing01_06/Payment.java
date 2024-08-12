package com.fpinjava.introduction.listing01_06;

import com.fpinjava.common.List;

public class Payment {

    public final CreditCard creditCard;
    public final int amount;

    public Payment(CreditCard creditCard, int amount) {
        this.creditCard = creditCard;
        this.amount = amount;
    }

    public Payment combine(Payment payment) {
        if (creditCard.equals(payment.creditCard)) {
            return new Payment(creditCard, amount + payment.amount);
        } else {
            throw new IllegalStateException("Cards don't match.");
        }
    }

    public static Payment combine(Payment payment1, Payment payment2) {
        if (payment1.creditCard.equals(payment2.creditCard)) {
            return new Payment(payment1.creditCard, payment1.amount + payment2.amount);
        } else {
            throw new IllegalStateException(
                    "Can't combine payments to different cards");
        }
    }

    public static List<Payment> groupByCard(List<Payment> payments) {
        return payments
                .groupBy(x -> x.creditCard)
                .values()
                .map(x -> x.reduce(c1 -> c1::combine));
    }
}
