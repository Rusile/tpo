package ru.itmo.function;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SinCalculatorTest {

    private static final double DELTA = 1e-5;

    @Test
    public void testCalculateSin() {
        assertEquals(0.0, SinCalculator.calculateSin(0, 10), DELTA);
        assertEquals(1.0, SinCalculator.calculateSin(Math.PI / 2, 10), DELTA);
        assertEquals(0.0, SinCalculator.calculateSin(Math.PI, 10), DELTA);
        assertEquals(-1.0, SinCalculator.calculateSin(3 * Math.PI / 2, 10), DELTA);
    }

    @Test
    public void testCalculateSin_smallAngle() {
        double angle = Math.PI / 6; // 30 градусов
        assertEquals(Math.sin(angle), SinCalculator.calculateSin(angle, 10), DELTA);
    }

    @Test
    public void testCalculateSin_fullCircle() {
        double angle = 2 * Math.PI; // полный круг 360 градусов, синус должен быть 0
        assertEquals(Math.sin(angle), SinCalculator.calculateSin(angle, 20), DELTA);
    }
}