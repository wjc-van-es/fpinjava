package com.fpinjava.lists.exercise05_08;

import static com.fpinjava.lists.exercise05_06.List.list;
import static com.fpinjava.lists.exercise05_08.Product.product;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;;

public class ProductTest {

  @Test
  public void testSum() {
    assertEquals(Double.valueOf(1.0), product(list()));
    assertEquals(Double.valueOf(30.0), product(list(1.0, 2.0, 3.0, 5.0)));
  }

}
