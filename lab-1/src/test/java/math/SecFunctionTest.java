package math;

import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import ru.itmo.math.MathLib;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SecFunctionTest {

    private final double DELTA = 1e-6;
    private final double LARGE_NUMBER_THRESHOLD = 1e4;

    @Test
    void testSecZero() {
        assertEquals(getExpected(0), MathLib.sec(0), DELTA);
    }

    @Test
    void testSecPiOverFour() {
        assertEquals(getExpected(Math.PI / 4), MathLib.sec(Math.PI / 4), DELTA);
    }

    @Test
    void testSecPiOverTwo() {
        assertIsInfinity(MathLib.sec(Math.PI / 2));
    }

    @Test
    void testSecNegativePiOverFour() {
        assertEquals(getExpected(-Math.PI / 4), MathLib.sec(-Math.PI / 4), DELTA);
    }

    @Test
    void testSecBetweenZeroAndPiOverTwo() {
        assertEquals(getExpected(Math.PI / 6), MathLib.sec(Math.PI / 6), DELTA);
    }

    @Test
    void testSecOutsideTheInterval() {
        double result = MathLib.sec(3 * Math.PI / 2);

        assertIsInfinity(result);
    }

    @ParameterizedTest
    @MethodSource("provideSecArgs")
    void testManyValues(double x, double expected) {
        assertEquals(expected, MathLib.sec(x), DELTA);
    }

    private void assertIsInfinity(double x) {
        assertTrue(Math.abs(x) > LARGE_NUMBER_THRESHOLD);
    }

    private double getExpected(double x) {
        return 1 / Math.cos(x);
    }
    private static Stream<Arguments> provideSecArgs() {
        return Stream.of(
                Arguments.of(1d, 1.85081571768),
                Arguments.of(3.14, -1.000001268274),
                Arguments.of(6.28, 1.000005)
        );
    }
}
