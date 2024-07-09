package com.fpinjava.lists.exercise05_20;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;;

public class ListTest {

  @Test
  public void testFilter() {
    assertEquals("[2, 4, 6, NIL]", List.list(1, 2, 3, 4, 5, 6).filter(x -> x % 2 == 0).toString());
  }

}
