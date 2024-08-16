package com.fpinjava.functions.exercise02_11;


public class FunctionExamples {

    //The reversal of arguments is reminiscent to the reversal of the function composition

    /**
     * The reversal of arguments for the sake of partial application of the right
     * argument, which needs to be the first argument.
     * This is reminiscent to the reversal in order of composition of two separate functions between compose & andThen
     * See {@link com.fpinjava.functions.exercise02_06.Function#higherCompose()} and
     * {@link com.fpinjava.functions.exercise02_06.Function#higherAndThen()}
     * @param f
     * @return
     * @param <T>
     * @param <U>
     * @param <V>
     */
    public static <T, U, V> Function<U, Function<T, V>> reverseArgs(Function<T, Function<U, V>> f) {
        return u -> t -> f.apply(t).apply(u);
    }
}
