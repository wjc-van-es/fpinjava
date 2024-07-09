package com.fpinjava.advancedtrees.listing11_03;

import org.junit.jupiter.api.Test;;


import static org.junit.jupiter.api.Assertions.assertTrue;


public class HeapTest {

  @Test
  public void testIsEmpty() {
    Heap<Integer> queue = Heap.empty();
    assertTrue(queue.isEmpty());
  }
}
