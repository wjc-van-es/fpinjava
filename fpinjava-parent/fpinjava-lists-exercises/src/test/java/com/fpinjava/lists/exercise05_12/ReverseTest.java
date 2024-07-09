package com.fpinjava.lists.exercise05_12;

import static com.fpinjava.lists.exercise05_10.List.*;
import static com.fpinjava.lists.exercise05_12.Reverse.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;;

public class ReverseTest {

  @Test
  public void testReverseViaFoldLeft() {
    assertEquals("[NIL]", reverseViaFoldLeft(list()).toString());
    assertEquals("[3, 2, 1, NIL]", reverseViaFoldLeft(list(1, 2, 3)).toString());
  }

}
