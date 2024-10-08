package com.fpinjava.optionaldata.exercise06_04;

import org.junit.jupiter.api.Test;;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OptionTest {

  @Test
  public void testFlatMap() {
    Option<Integer> option = Option.some(2);
    assertEquals("Some(4)", option.flatMap(x -> Option.some(x * 2)).toString());
  }

  @Test
  public void testFlatMapNone() {
    Option<Integer> option = Option.none();
    assertEquals("None", option.flatMap(x -> Option.some(x * 2)).toString());
  }

}
