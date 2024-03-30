package ru.itmo.function;

public class TangentCalculator {

    private static final double DELTA = 1e-6;

    /**
     * Вычисляет тангенс числа x с помощью разложения в ряд Тейлора.
     *
     * @param x угол в радианах
     * @param n количество членов ряда для расчета
     * @return приближенное значение синуса
     */
    public static double calculateTan(double x, int n) {
        double sin = SinCalculator.calculateSin(x, n);
        double cos = CosineCalculator.calculateCos(x, n);

        if (Math.abs(cos) <= DELTA) {
            throw new IllegalArgumentException("Тангенс не определен для данного угла.");
        }

        return sin / cos;
    }

}
