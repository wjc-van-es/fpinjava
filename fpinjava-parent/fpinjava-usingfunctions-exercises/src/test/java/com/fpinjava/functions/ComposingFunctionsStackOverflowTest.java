package com.fpinjava.functions;

import static com.fpinjava.functions.ComposingFunctionsStackOverflow.*;

import org.junit.jupiter.api.Test;;

public class ComposingFunctionsStackOverflowTest {

  //@Test(expected=StackOverflowError.class)
  public void test() {
      g.apply(0);
  }
}
