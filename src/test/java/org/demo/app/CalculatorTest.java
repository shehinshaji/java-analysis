package org.demo.app;


import org.testng.annotations.BeforeTest;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class CalculatorTest {

    ICalculator calculator;

    @BeforeTest
    public void init() {
        calculator = new Calculator();
    }

    @Test
    public void exampleTest() {
        assertEquals((5 * 2), 10);
    }

    @Test
    public void sumTest() {
       int result = calculator.sum(2, 5);
       assertEquals(result, 7);
    }

    @Test
    public void substractionTest() {
        int result = calculator.subtraction(5, 3);
        assertEquals(result, 2);
    }

    @Ignore	
    @Test
    public void substractionFailTest() {
        int result = calculator.subtraction(5, 3);
        assertEquals(result, 3);
    }

    @Test
    public void mult() {
        int result = calculator.multiplication(5, 3);
        assertEquals(result, 15);
    }


    @Test
    public void divisionTest() {
        int result = calculator.divison(6, 3);
        assertEquals(result, 2);
    }

    @Test(expectedExceptions = RuntimeException.class)
    public void divisionByZeroTest() {
        int result = calculator.divison(6, 0);
        assertEquals(result, 2);
    }


}
