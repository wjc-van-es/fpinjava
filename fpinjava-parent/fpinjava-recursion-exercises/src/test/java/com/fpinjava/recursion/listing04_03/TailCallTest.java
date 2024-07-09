package com.fpinjava.recursion.listing04_03;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;;

public class TailCallTest {

  @Test
  public void test() {
    assertEquals(Integer.valueOf(100000003), Add.add(3, 100000000).eval());
  }

}
