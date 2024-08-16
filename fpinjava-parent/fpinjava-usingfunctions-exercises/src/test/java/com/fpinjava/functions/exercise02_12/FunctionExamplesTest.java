package com.fpinjava.functions.exercise02_12;

import static org.junit.jupiter.api.Assertions.*;
import static com.fpinjava.functions.exercise02_12.FunctionExamples.*;

import org.junit.jupiter.api.Test;;

public class FunctionExamplesTest {

  @Test
  public void test() {
    assertEquals(Integer.valueOf(3628800), new FunctionExamples().factorial0.apply(10));
    assertEquals(Integer.valueOf(3628800), factorial1.apply(10));
    FunctionExamples x = new FunctionExamples();
    assertEquals(Integer.valueOf(3628800), x.factorial2.apply(10));
    assertEquals(Integer.valueOf(3628800), x.factorial3.apply(10));
  }

}
