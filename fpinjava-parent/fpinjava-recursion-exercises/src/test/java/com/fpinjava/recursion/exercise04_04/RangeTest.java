package com.fpinjava.recursion.exercise04_04;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;;

public class RangeTest {

  @Test
  public void testRange() {
    assertEquals("[]", Range.range(0, 0).toString());
    assertEquals("[0]", Range.range(0, 1).toString());
    assertEquals("[0, 1, 2, 3, 4]", Range.range(0, 5).toString());
    assertEquals("[]", Range.range(5, 1).toString());
  }

}
