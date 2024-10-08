package com.fpinjava.lists.exercise05_01;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;;

import static com.fpinjava.lists.exercise05_01.List.*;

public class ListTest {

  @Test
  public void testCons() {
    assertEquals("a", list().cons("a").head());
    assertEquals("a", list("b", "c", "d").cons("a").head());
    assertEquals("b", list("b", "c", "d").cons("a").tail().head());
  }

}
