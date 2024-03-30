package ru.itmo.function;

public class LogarithmCalculator {

    /**
     * Вычисляет натуральный логарифм числа x с использованием ряда Тейлора до n-го элемента.
     * @param x значение, для которого вычисляется логарифм (должно быть > 0)
     * @param n кол-во элементов ряда для расчета (должно быть > 0)
     * @return приближенное значение натурального логарифма x
     * @throws IllegalArgumentException если x <= 0 или n <= 0
     */
    public static double calculateLn(double x, int n) {
        if (x <= 0) {
            throw new IllegalArgumentException("x must be positive");
        }
        if (n <= 0) {
            throw new IllegalArgumentException("Number of terms must be positive");
        }

        // Используем преобразование для повышения сходимости
        double y = (x - 1) / (x + 1);
        double y2 = y * y;
        double sum = 0.0;

        for (int i = 1; i <= n; i += 2) {
            sum += 2 * y / i;
            y *= y2;
        }

        return sum;
    }

    /**
     * Вычисляет логарифм числа x по основанию base, используя реализованный метод calculateLn.
     * @param x число, логарифм которого необходимо вычислить
     * @param base основание логарифма
     * @param n количество членов ряда для расчета натурального логарифма
     * @return приближенное значение логарифма
     */
    public static double calculateLog(double x, double base, int n) {
        if (x <= 0 || base <= 0 || base == 1) {
            throw new IllegalArgumentException("Аргумент и основание логарифма должны быть больше нуля и основание не равно 1.");
        }
        double lnX = calculateLn(x, n);
        double lnBase = calculateLn(base, n);
        return lnX / lnBase;
    }
}
