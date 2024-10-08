package com.fpinjava.functions.exercise02_04;

public class FunctionExamples {

  public static final Function<Integer, Integer> triple = x -> x * 3;

  public static final Function<Integer, Integer> square = x -> x * x;

  public static final Function<Function<Integer, Integer>, Function<Function<Integer, Integer>,
                                        Function<Integer, Integer>>> compose =
          fa1 -> fa2 -> fr -> fa1.apply(fa2.apply(fr));

  public static final Function<Integer, Integer> f = compose.apply(square).apply(triple); //1rst tripled, 2nd squared
}
