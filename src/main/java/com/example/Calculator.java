package com.example;

public class Calculator {

    private double memory = 0.0;

    public double add(double a, double b) {
        return a + b;
    }

    public double subtract(double a, double b) {
        return a - b;
    }

    public double multiply(double a, double b) {
        return a * b;
    }

    public double divide(double a, double b) {
        if (b == 0) {
            throw new ArithmeticException("Division durch null ist nicht erlaubt.");
        }
        return a / b;
    }

    public void memoryStore(double value) {
        memory = value;
    }

    public void memoryAdd(double value) {
        memory += value;
    }

    public void memorySubtract(double value) {
        memory -= value;
    }

    public double memoryRecall() {
        return memory;
    }

    public void memoryClear() {
        memory = 0.0;
    }
}
