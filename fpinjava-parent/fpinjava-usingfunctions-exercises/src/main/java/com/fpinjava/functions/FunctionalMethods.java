package com.fpinjava.functions;

public class FunctionalMethods {

    public final int taxPercentage = 13;

    public static int applyTax(FunctionalMethods instance, int a){
        return a / 100 * (100 + instance.taxPercentage);
    }

    public int applyTax(int a) {
        // instance method delegating to static method that has an explicit instance
        // parameter to access the current object's state
        return applyTax(this, a);
    }
}
