package com.fpinjava.lists.exercise05_17;

import com.fpinjava.lists.exercise05_16.List;
import org.junit.jupiter.api.Test;;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TripleTest {

  @Test
  public void testAdd1() {
    assertEquals("[3, 6, 9, 12, NIL]", Triple.triple(List.list(1, 2, 3, 4)).toString());
  }

}
