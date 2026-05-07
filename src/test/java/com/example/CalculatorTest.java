package com.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    private Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

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

    @Test
    void memoryInitiallyZero() {
        assertEquals(0.0, calculator.memoryRecall());
    }

    @Test
    void memoryStoreAndRecall() {
        calculator.memoryStore(42.0);
        assertEquals(42.0, calculator.memoryRecall());
    }

    @Test
    void memoryAddIncreasesValue() {
        calculator.memoryStore(10.0);
        calculator.memoryAdd(5.0);
        assertEquals(15.0, calculator.memoryRecall());
    }

    @Test
    void memorySubtractDecreasesValue() {
        calculator.memoryStore(10.0);
        calculator.memorySubtract(3.0);
        assertEquals(7.0, calculator.memoryRecall());
    }

    @Test
    void memoryClearResetsToZero() {
        calculator.memoryStore(99.0);
        calculator.memoryClear();
        assertEquals(0.0, calculator.memoryRecall());
    }
}
