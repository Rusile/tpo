package ru.itmo.function;

public class CosineCalculator {

    /**
     * Вычисляет косинус числа x, используя реализованный метод calculateSin.
     * @param x угол в радианах
     * @param n количество членов ряда для расчета синуса
     * @return приближенное значение косинуса
     */
    public static double calculateCos(double x, int n) {
        double result = 1.0;
        double xSquared = x * x;
        double numerator = 1.0;
        double factorial = 1.0;
        int sign = 1;

        for (int i = 1; i < n; i++) {
            sign *= -1;
            numerator *= xSquared;
            factorial *= (2 * i) * (2 * i - 1);
            result += sign * numerator / factorial;
        }

        return result;

    }

}
