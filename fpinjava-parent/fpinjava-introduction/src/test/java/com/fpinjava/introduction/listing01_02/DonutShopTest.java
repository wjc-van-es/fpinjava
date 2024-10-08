package com.fpinjava.introduction.listing01_02;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;;

public class DonutShopTest {

  @Test
  public void testBuyDonut() {
    CreditCard creditCard = new CreditCard();
    Tuple<Donut, Payment> purchase = DonutShop.buyDonut(creditCard);
    assertEquals(Donut.price, purchase._2.amount);
    assertEquals(creditCard, purchase._2.creditCard);
  }
}
