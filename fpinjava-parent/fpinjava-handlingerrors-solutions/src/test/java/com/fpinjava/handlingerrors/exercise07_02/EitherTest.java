package com.fpinjava.handlingerrors.exercise07_02;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;;

public class EitherTest {

  @Test
  public void testFlatMapRight() {
    Either<String, Integer> either = Either.right(2);
    assertEquals("Right(4)", either.flatMap(x -> Either.right(x * 2)).toString());
  }

  @Test
  public void testFlatMapLeft() {
    Either<String, Integer> either = Either.left("error");
    assertEquals("Left(error)", either.flatMap(x -> Either.right(x * 2)).toString());
  }

}
