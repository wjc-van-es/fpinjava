package com.fpinjava.optionaldata.exercise06_08;

import static org.junit.jupiter.api.Assertions.*;

import com.fpinjava.common.Function;
import org.junit.jupiter.api.Test;;

public class OptionTest {

  private Function<Option<String>, Option<String>> upperOption = Option.lift(String::toUpperCase);

  @Test
  public void testLift() {
    assertEquals(Option.some("STRING").toString(), upperOption.apply(Option.some("string")).toString());
  }

  @Test
  public void testLiftNone() {
    assertEquals(Option.none(), upperOption.apply(Option.none()));
  }

}
