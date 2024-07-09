package com.fpinjava.functions.exercise02_04;

import static com.fpinjava.functions.exercise02_04.FunctionExamples.f;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;;

public class FunctionExamplesTest {

  @Test
  public void test() {
    assertEquals(Integer.valueOf(81), f.apply(3));
  }

}
