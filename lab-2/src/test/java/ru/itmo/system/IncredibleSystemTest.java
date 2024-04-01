package ru.itmo.system;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IncredibleSystemTest {

    private static final double DELTA = 1e-6;

    @Test
    public void testCalculateFirstInterval() {
        double x = -Math.PI / 4; // Пример отрицательного значения x
        int n = 10; // Произвольное количество членов ряда
        // Ожидаемое значение - сумма тангенса и синуса x
        double expected = expectedFun(x);
        assertEquals(expected, IncredibleSystem.calculate(x, n), DELTA);
    }

    @Test
    public void testCalculateSecondInterval() {
        double x = 1; // Пример положительного значения x
        int n = 10; // Произвольное количество членов ряда
        // Ожидаемое значение - вычисление по второму интервалу
        double expected = expectedFun(x);
        assertEquals(expected, IncredibleSystem.calculate(x, n), DELTA);
    }

    @Test
    public void testCalculateAtZero() {
        double x = 0; // Граничное условие x == 0
        int n = 10; // Произвольное количество членов ряда
        double expected = 0; // Ожидаемое значение при x == 0
        assertEquals(expected, IncredibleSystem.calculate(x, n), DELTA);
    }

    @Test
    public void testCalculateJustAboveZero() {
        double x = 1e-3; // Значение x немного больше 0
        int n = 10000000;
        // Ожидаемое значение согласно второму интервалу
        double expected = expectedFun(x);
        assertEquals(expected, IncredibleSystem.calculate(x, n), DELTA);
    }

    @Test
    public void testCalculateJustBelowZero() {
        double x = -1e-8; // Значение x немного меньше 0
        int n = 10;
        // Ожидаемое значение согласно первому интервалу
        double expected = expectedFun(x);
        assertEquals(expected, IncredibleSystem.calculate(x, n), DELTA);
    }

    @Test
    public void testCalculateWithMoreTerms() {
        double x = 0.5; // Пример положительного значения x
        int n = 500; // Большее количество членов ряда
        // С увеличением числа членов ряда ожидается более точный результат
        double expected = expectedFun(x);
        assertEquals(expected, IncredibleSystem.calculate(x, n), DELTA);
    }

    @Test
    public void testCalculateWithFewerTerms() {
        double x = 0.5; // Пример положительного значения x
        int n = 3; // Меньшее количество членов ряда
        // С уменьшением числа членов ряда ожидается менее точный результат
        double result = IncredibleSystem.calculate(x, n);
        double expected = expectedFun(x);
        assertTrue(Math.abs(result - expected) > DELTA);
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