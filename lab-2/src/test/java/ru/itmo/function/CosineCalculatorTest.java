package ru.itmo.function;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CosineCalculatorTest {
    private static final double DELTA = 1e-5;

    @Test
    public void whenAngleIsZero_thenCosineIsOne() {
        assertEquals(1.0, CosineCalculator.calculateCos(0, 10), DELTA);
    }

    @Test
    public void whenAngleIsPiOverTwo_thenCosineIsZero() {
        assertEquals(0.0, CosineCalculator.calculateCos(Math.PI / 2, 10), DELTA);
    }

    @Test
    public void whenAngleIsPi_thenCosineIsMinusOne() {
        assertEquals(-1.0, CosineCalculator.calculateCos(Math.PI, 10), DELTA);
    }

    @Test
    public void whenAngleIsThreePiOverTwo_thenCosineIsZero() {
        assertEquals(Math.cos(3 * Math.PI / 2), CosineCalculator.calculateCos(3 * Math.PI / 2, 100), DELTA);
    }

    @Test
    public void testCosineOfSmallAngles() {
        // Тестирование на небольших углах
        assertEquals(Math.cos(Math.PI / 6), CosineCalculator.calculateCos(Math.PI / 6, 10), DELTA); // 30 градусов
        assertEquals(Math.cos(Math.PI / 4), CosineCalculator.calculateCos(Math.PI / 4, 10), DELTA); // 45 градусов
        assertEquals(Math.cos(Math.PI / 3), CosineCalculator.calculateCos(Math.PI / 3, 10), DELTA); // 60 градусов
    }

}