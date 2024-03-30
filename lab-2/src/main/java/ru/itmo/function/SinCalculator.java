package ru.itmo.function;

public class SinCalculator {
    /**
     * Вычисляет синус числа x с помощью разложения в ряд Тейлора.
     *
     * @param x угол в радианах
     * @param n количество членов ряда для расчета
     * @return приближенное значение синуса
     */
    public static double calculateSin(double x, int n) {
        double result = 0.0;
        double xSquared = x * x;
        double numerator = x;
        double factorial = 1.0;
        int sign = 1;

        for (int i = 1; i <= n; i++) {
            result += sign * numerator / factorial;
            sign *= -1;
            numerator *= xSquared;
            factorial *= (2 * i) * (2 * i + 1);
        }

        return result;
    }
}
