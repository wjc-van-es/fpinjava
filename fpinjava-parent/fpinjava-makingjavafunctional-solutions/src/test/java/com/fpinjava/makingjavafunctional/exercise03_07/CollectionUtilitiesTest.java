package com.fpinjava.makingjavafunctional.exercise03_07;

import static org.junit.jupiter.api.Assertions.*;
import static com.fpinjava.makingjavafunctional.exercise03_07.CollectionUtilities.*;

import java.util.List;

import org.junit.jupiter.api.Test;;

import com.fpinjava.common.Function;

public class CollectionUtilitiesTest {

  private static String addIS(Integer i, String s) {
    return "(" + i + " + " + s + ")";
  }

  @Test
  public void testFoldRight() {
    List<Integer> list = list(1, 2, 3, 4, 5);
    String identity = "0";
    Function<Integer, Function<String, String>> f = x -> y -> addIS(x, y);
    assertEquals("(1 + (2 + (3 + (4 + (5 + 0)))))", foldRight(list, identity, f));
  }

}
