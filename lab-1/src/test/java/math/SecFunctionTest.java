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
    private final double LARGE_NUMBER_THRESHOLD = 1e12;

    public static Stream<Arguments> provideSecArgs() {
        return Stream.of(
                Arguments.of(1d, 1.85081571768),
                Arguments.of(3.14, -1.000001268274),
                Arguments.of(6.28, 1.000005)
        );
    }

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

}
