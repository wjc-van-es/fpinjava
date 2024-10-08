package com.fpinjava.optionaldata.exercise06_03;

import org.junit.jupiter.api.Test;;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OptionTest {

  @Test
  public void testMap() {
    Option<Integer> option = Option.some(2);
    assertEquals("Some(4)", option.map(x -> x * 2).toString());
  }

  @Test
  public void testMapNone() {
    Option<Integer> option = Option.none();
    assertEquals("None", option.map(x -> x * 2).toString());
  }
}
