package com.fpinjava.functions;

import org.junit.jupiter.api.Test;

import static com.fpinjava.functions.FunctionalMethods.applyTax;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FunctionalMethodsTest {
    @Test
    public void testInstance(){
        var functionalMethods = new FunctionalMethods();
        assertEquals(13, functionalMethods.taxPercentage); // asserting the inner state tax percentage to be 13%
        assertEquals(113, applyTax(functionalMethods, 100)); // the class method with extra instance argument
        assertEquals(113, functionalMethods.applyTax(100)); // the more common instance method
    }

}
