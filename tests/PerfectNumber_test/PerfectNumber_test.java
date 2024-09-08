import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(StopAfterFailureExtension.class)
class PerfectNumberTest {

    @Test
    void testIsPerfectNumber_withPerfectNumber() {
        PerfectNumber perfectNumber = new PerfectNumber();
        int number = 6;
        assertThat(perfectNumber.isPerfectNumber(number))
                .withFailMessage("Expected %d to be a perfect number", number)
                .isTrue();
    }

    @Test
    void testIsPerfectNumber_withLargePerfectNumber() {
        PerfectNumber perfectNumber = new PerfectNumber();
        int number = 28;
        assertThat(perfectNumber.isPerfectNumber(number))
                .withFailMessage("Expected %d to be a perfect number", number)
                .isTrue();
        int number2 = 33550336;
        assertThat(perfectNumber.isPerfectNumber(number2))
                .withFailMessage("Expected %d to be a perfect number", number2)
                .isTrue();
        int number3 = Integer.MAX_VALUE;
        assertThat(perfectNumber.isPerfectNumber(number3))
                .withFailMessage("Expected %d to not be a perfect number", number3)
                .isFalse();
    }

    @Test
    void testIsPerfectNumber_withNonPerfectNumber() {
        PerfectNumber perfectNumber = new PerfectNumber();
        int number = 12;
        assertThat(perfectNumber.isPerfectNumber(number))
                .withFailMessage("Expected %d to not be a perfect number", number)
                .isFalse();
    }

    @Test
    void testIsPerfectNumber_withOne() {
        PerfectNumber perfectNumber = new PerfectNumber();
        int number = 1;
        assertThat(perfectNumber.isPerfectNumber(number))
                .withFailMessage("Expected %d to not be a perfect number", number)
                .isFalse();
    }

    @Test
    void testIsPerfectNumber_withZero() {
        PerfectNumber perfectNumber = new PerfectNumber();
        int number = 0;
        assertThat(perfectNumber.isPerfectNumber(number))
                .withFailMessage("Expected %d to not be a perfect number", number)
                .isFalse();
    }

    @Test
    void testIsPerfectNumber_withNegativeNumber() {
        PerfectNumber perfectNumber = new PerfectNumber();
        int number = -28;
        assertThat(perfectNumber.isPerfectNumber(number))
                .withFailMessage("Expected %d to not be a perfect number", number)
                .isFalse();
    }

    @Test
    void testPerfectNumberInstance_isNotNull() {
        PerfectNumber perfectNumber = new PerfectNumber();
        assertThat(perfectNumber)
                .withFailMessage("Expected PerfectNumber instance to be not null, but got null")
                .isNotNull();
    }
}
