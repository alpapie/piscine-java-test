import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(StopAfterFailureExtension.class)
class AverageCalcTest {

    @Test
    void testAverageInRange() {
        assertEquals(5, AverageCalc.average(1, 10, 2));
    }

    @Test
    void testAverageWithNegativeStep() {
        assertEquals(6, AverageCalc.average(10, 1, -2));
    }

    @Test
    void testAverageWithSingleValue() {
        assertEquals(1, AverageCalc.average(1, 1, 1));
    }

    @Test
    void testAverageWithStartEqualsToEnd() {
        assertEquals(1, AverageCalc.average(1, 1, 2));
    }

    @Test
    void testAverageWithStepGreaterThanRange() {
        assertEquals(1, AverageCalc.average(1, 2, 10));
    }

    @Test
    void testAverageWithStepGreaterThanEnd() {
        assertEquals(1, AverageCalc.average(1, 2, 10));
    }

    @Test
    void testAverageWithNegativeRange() {
        assertEquals(-6, AverageCalc.average(-10, -1, 2));
    }

    @Test
    void testAverageWithNegativeRangeAndNegativeStep() {
        assertEquals(-5, AverageCalc.average(-1, -10, -2));
    }

    @Test
    void testAverageWithStepEqualsZero() {
        assertEquals(0, AverageCalc.average(1, 10, 0));
    }
}
