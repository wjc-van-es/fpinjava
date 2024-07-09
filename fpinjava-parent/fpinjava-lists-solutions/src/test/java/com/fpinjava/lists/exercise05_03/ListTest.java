package com.fpinjava.lists.exercise05_03;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;;
import static com.fpinjava.lists.exercise05_03.List.*;

public class ListTest {

  @Test
  public void testToString() {
    assertEquals("[NIL]", list().toString());
    assertEquals("[1, 2, 3, NIL]", list(1, 2, 3).toString());
  }

}
