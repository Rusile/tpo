package ru.itmo.system;

import ru.itmo.function.LogarithmCalculator;
import ru.itmo.function.SinCalculator;
import ru.itmo.function.TangentCalculator;

public class IncredibleSystem {

    /**
     * Вычисляет систему уравнений для аргумента x.
     * x <= 0 : (tan(x) + sin(x))
     * x > 0 : (((((log_10(x) ^ 2) - log_5(x)) + log_2(x)) ^ 3) + (log_2(x) * log_2(x)))
     *
     * @param x аргумент
     * @param n количество членов ряда для расчета
     */
    public static double calculate(double x, int n) {
        if (x <= 0) {
            return calculateFirstInterval(x, n);
        }

        return calculateSecondInterval(x, n);
    }

    private static double calculateSecondInterval(double x, int n) {
        return Math.pow(
                LogarithmCalculator.calculateLog(x * x, 10, n)
                        - LogarithmCalculator.calculateLog(x, 5, n)
                        + LogarithmCalculator.calculateLog(x, 2, n),
                3
        ) + Math.pow(LogarithmCalculator.calculateLog(x, 2, n), 2);
    }

    private static double calculateFirstInterval(double x, int n) {
        return TangentCalculator.calculateTan(x, n) + SinCalculator.calculateSin(x, n);
    }
}
