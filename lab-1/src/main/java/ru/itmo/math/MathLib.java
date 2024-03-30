package ru.itmo.math;

public class MathLib {

    public static double factorial(int n) {
        double result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    public static double cosTaylorSeries(double x, int terms) {
        double result = 0;
        for (int n = 0; n < terms; n++) {
            result += Math.pow(-1, n) * Math.pow(x, 2 * n) / factorial(2 * n);
        }
        return result;
    }

    public static double sec(double x) {
        int terms = 15;
        double cosine = cosTaylorSeries(x, terms);
        return 1 / cosine;
    }

}
