package org.demo.app;

public class Calculator implements ICalculator {

    public static final String test123 = "qqqq";

    @Override
    public int sum(int x, int y) {
        return (x + y);
    }

    @Override
    public int subtraction(int x, int y) {
        return (x - y);
    }

    @Override
    public int multiplication(int x, int y) {
        return (x * y);
    }

    @Override
    public int divison(int x, int y) throws RuntimeException {

        if (y == 0) {
            throw new ArithmeticException("Division can't be perform!");
        }
        return (x / y);
    }
}
