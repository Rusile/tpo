package math;

import org.junit.jupiter.api.Test;
import ru.itmo.math.MathLib;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SecFunctionTest {

    private final double DELTA = 1e-6;
    private final double LARGE_NUMBER_THRESHOLD = 1e12;

    @Test
    void testSecZero() {
        assertEquals(1.0, MathLib.sec(0), DELTA);
    }

    @Test
    void testSecPiOverFour() {
        assertEquals(Math.sqrt(2), MathLib.sec(Math.PI / 4), DELTA);
    }

    @Test
    void testSecPiOverTwo() {
        assertIsInfinity(MathLib.sec(Math.PI / 2));
    }

    @Test
    void testSecNegativePiOverFour() {
        assertEquals(Math.sqrt(2), MathLib.sec(-Math.PI / 4), DELTA);
    }

    @Test
    void testSecBetweenZeroAndPiOverTwo() {
        assertEquals(2.0 / Math.sqrt(3), MathLib.sec(Math.PI / 6), DELTA);
    }

    @Test
    void testSecOutsideTheInterval() {
        // Устанавливаем порог, при котором будем считать, что функция ведет себя
        // корректно для данного погрешного вычисления
        double result = MathLib.sec(3 * Math.PI / 2);

        // Мы допускаем, чтоесли полученное значение больше порогового (по модулю),
        // то функция ведёт себя так, как будто результат стремится к бесконечности
        assertIsInfinity(result);
    }

    private void assertIsInfinity(double x) {
        assertTrue(Math.abs(x) > LARGE_NUMBER_THRESHOLD);
    }

}
