package ru.itmo.system;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.itmo.function.LogarithmCalculator;
import ru.itmo.function.SinCalculator;
import ru.itmo.function.TangentCalculator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyDouble;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;


class IncredibleSystemWithMocksTest {

    private static final double DELTA = 1e-6; // Погрешность для чисел с плавающей запятой

    @Test
    void testLeftInterval() {
        Mockito.mockStatic(SinCalculator.class);
        Mockito.mockStatic(TangentCalculator.class);
        when(SinCalculator.calculateSin(anyDouble(), anyInt()))
                .thenReturn(1.00);
        when(TangentCalculator.calculateTan(anyDouble(), anyInt()))
                .thenReturn(1.00);

        assertEquals(2.00, IncredibleSystem.calculate(-1, 10));
    }

    @Test
    void testRightInterval() {
        Mockito.mockStatic(LogarithmCalculator.class);
        when(LogarithmCalculator.calculateLog(anyDouble(), anyDouble(), anyInt()))
                .thenReturn(1.00);

        assertEquals(2.00, IncredibleSystem.calculate(1, 10));
    }

    private double expectedFun(double x) {
        if (x > 0) {
            return Math.pow(
                    Math.log10(x * x) - Math.log(x) / Math.log(5) + Math.log(x) / Math.log(2), 3)
                    + Math.pow(Math.log(x) / Math.log(2), 2);
        }

        return Math.tan(x) + Math.sin(x);
    }
}