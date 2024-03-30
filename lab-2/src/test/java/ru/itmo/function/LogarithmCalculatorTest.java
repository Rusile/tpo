package ru.itmo.function;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class LogarithmCalculatorTest {
    private static final double DELTA = 1e-6;

    @Test
    public void testCalculateLn_positiveNumbers() {
        assertEquals(Math.log(1), LogarithmCalculator.calculateLn(1, 100000), DELTA);
        assertEquals(Math.log(2), LogarithmCalculator.calculateLn(2, 100000), DELTA);
    }

    @Test
    public void testCalculateLn_zero_throwsException() {
        assertThrows(IllegalArgumentException.class,
                () -> LogarithmCalculator.calculateLn(0, 1000)
        );
    }

    @Test
    public void testCalculateLn_negativeNumber_throwsException() {
        assertThrows(IllegalArgumentException.class,
                () -> LogarithmCalculator.calculateLn(-1, 1000)
        );
    }

    @Test
    public void testCalculateLn_zeroIterations_throwsException() {
        assertThrows(IllegalArgumentException.class,
                () -> LogarithmCalculator.calculateLn(2, 0)
        );
    }

    @Test
    public void testCalculateLog() {
        assertEquals(Math.log(10) / Math.log(2), LogarithmCalculator.calculateLog(10, 2, 1000), DELTA);
        assertEquals(Math.log(100) / Math.log(10), LogarithmCalculator.calculateLog(100, 10, 1000), DELTA);
    }

    @Test
    public void testCalculateLogWithInvalidArguments() {
        assertThrows(
                IllegalArgumentException.class,
                () -> LogarithmCalculator.calculateLog(-1, 2, 10)
        );
    }

    @Test
    public void testCalculateLogWithBaseE() {
        assertEquals(Math.log(10), LogarithmCalculator.calculateLog(10, Math.E, 1000), DELTA);
    }

    @Test
    void testJustAboveZero() {
        double x = 1e-6;
        assertEquals(Math.log(x), LogarithmCalculator.calculateLn(x, 10000000), DELTA);
    }
}