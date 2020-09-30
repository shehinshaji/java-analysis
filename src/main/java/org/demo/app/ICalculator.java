package org.demo.app;

public interface ICalculator {

    public int sum(int x, int y);

    public int subtraction(int x, int y);

    public int multiplication(int x, int y);

    public int divison(int x, int y) throws RuntimeException;

}
