package com.fpinjava.advancedlisthandling.exercise08_04;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;;

public class ListTest {

  @Test
  public void testHeadOptionEmpty() {
    assertEquals("Empty()", List.list().headOption().toString());
  }

  @Test
  public void testHeadOptionNonEmpty() {
    assertEquals("Success(1)", List.list(1, 2, 3).headOption().toString());
  }
}
