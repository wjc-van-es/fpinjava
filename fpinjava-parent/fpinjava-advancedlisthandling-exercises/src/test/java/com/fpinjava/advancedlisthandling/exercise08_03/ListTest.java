package com.fpinjava.advancedlisthandling.exercise08_03;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;;

public class ListTest {

  @Test
  public void testLastOptionEmpty() {
    assertEquals("Empty()", List.list().lastOption().toString());
  }

  @Test
  public void testLastOptionNonEmpty() {
    assertEquals("Success(3)", List.list(1, 2, 3).lastOption().toString());
  }

}
