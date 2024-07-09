package com.fpinjava.lists.exercise05_02;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;;

import static com.fpinjava.lists.exercise05_02.List.*;

public class ListTest {

  //@Test(expected=IllegalStateException.class)
  public void testSetHeadNil() {
    list().setHead("d");
  }

  @Test
  public void testSetHead() {
    assertEquals("d", list("a", "b", "c").setHead("d").head());
    assertEquals("b", list("a", "b", "c").setHead("d").tail().head());
  }

}
