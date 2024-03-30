package ru.itmo.function;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class TangentCalculatorTest {

    private static final double DELTA = 1e-6;

    @Test
    public void testCalculateTan() {
        // Проверка тангенса для угла в 45 градусов, где тангенс должен быть ~1
        assertEquals(1.0, TangentCalculator.calculateTan(Math.PI / 4, 10), DELTA);

        // Проверка тангенса для угла в 0 градусов, где тангенс должен быть 0
        assertEquals(0.0, TangentCalculator.calculateTan(0, 10), DELTA);
    }

    @Test
    public void testCalculateTan_undefined() {
        // Проверка, что выбрасывается исключение для угла 90 градусов, где косинус равен 0 и тангенс не определен
        assertThrows(
                IllegalArgumentException.class,
                () -> TangentCalculator.calculateTan(Math.PI / 2, 10)
        );
    }

    @Test
    public void testCalculateTan_smallAngle() {
        double angle = Math.PI / 6; // 30 градусов
        assertEquals(Math.tan(angle), TangentCalculator.calculateTan(angle, 10), DELTA);
    }
}
