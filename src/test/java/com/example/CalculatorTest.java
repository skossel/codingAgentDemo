package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    private final Calculator calculator = new Calculator();

    @Test
    void additionCorrect() {
        assertEquals(5.0, calculator.add(2, 3));
    }

    @Test
    void subtractionCorrect() {
        assertEquals(1.0, calculator.subtract(3, 2));
    }

    @Test
    void multiplicationCorrect() {
        assertEquals(6.0, calculator.multiply(2, 3));
    }

    @Test
    void divisionCorrect() {
        assertEquals(2.0, calculator.divide(6, 3));
    }

    @Test
    void divisionByZeroThrowsException() {
        assertThrows(ArithmeticException.class, () -> calculator.divide(5, 0));
    }
}
