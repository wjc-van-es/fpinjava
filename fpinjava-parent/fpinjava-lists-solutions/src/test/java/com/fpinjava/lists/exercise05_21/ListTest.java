package com.fpinjava.lists.exercise05_21;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;;

public class ListTest {

  @Test
  public void testFlatMap() {
    assertEquals("[1, 1, 2, 2, 3, 3, NIL]", List.list(1,2,3).flatMap(i -> List.list(i,i)).toString());
  }

}
