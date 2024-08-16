package com.fpinjava.functions.exercise02_06;


public interface Function<T, U> {

  U apply(T arg);

  // Understanding the generics:
  // we are implementing f ∘ g = f(g(x))
  // f has U type arg and V as type result
  // g has T type arg and U type result
  // x has type T
  // the composed function returned by higherCompose is therefore Function<T, V>
  static <T, U, V> Function<Function<U, V>, Function<Function<T, U>, Function<T, V>>> higherCompose() {
    return f -> g -> x -> f.apply(g.apply(x));
  }

  // Understanding the generics:
  // we are implementing higherAndThen for f and then g, which is the compose of g ∘ f = g(f(x))
  // f has T type arg and U as type result
  // g has U type arg and V type result
  // x has type T
  // the composed function returned by higherAndThen is therefore Function<T, V>
  static <T, U, V> Function<Function<T, U>, Function<Function<U, V>, Function<T, V>>> higherAndThen() {
    return f -> g -> x -> g.apply(f.apply(x));
  }
}
