package com.fpinjava.functions.exercise02_12;

public class FunctionExamples {

    /*
     * Note: The same implementation may be used for all four cases.
     */

    public Function<Integer, Integer> factorial0;
    {
        factorial0 = n -> n <= 1 ? n : n * factorial0.apply(n - 1);
    }
     // To be implemented

    public static Function<Integer, Integer> factorial1;

    static {
        factorial1 = n -> n <= 1 ? n : n * factorial1.apply(n - 1);
    }

    public final Function<Integer, Integer> factorial2 =  n ->
            n <= 1 ? n : n * this.factorial2.apply(n - 1);


    public static final Function<Integer, Integer> factorial3 = n ->
            n <= 1 ? n : n * FunctionExamples.factorial3.apply(n - 1);

}
