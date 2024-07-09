package com.fpinjava.lists.exercise05_15;

import static org.junit.jupiter.api.Assertions.*;
import static com.fpinjava.lists.exercise05_15.List.*;
import org.junit.jupiter.api.Test;;

public class ListTest {

  @Test
  public void testConcat() {
    assertEquals("[4, 5, 6, NIL]", List.concat(list(), list(4, 5, 6)).toString());
    assertEquals("[1, 2, 3, NIL]", List.concat(list(1, 2, 3), list()).toString());
    assertEquals("[1, 2, 3, 4, 5, 6, NIL]", List.concat(list(1, 2, 3), list(4, 5, 6)).toString());
  }

}
