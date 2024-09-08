import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(StopAfterFailureExtension.class)
class DigitlenTest {

    @Test
    void lengthOfSingleDigit() {
        long number = 7;
        int result = Digitlen.digitlen(number);
        assertThat(result).isEqualTo(1);
    }

    @Test
    void lengthOfMultipleDigits() {
        long number = 123456789;
        int result = Digitlen.digitlen(number);
        assertThat(result).isEqualTo(9);
    }

    @Test
    void lengthOfZero() {
        long number = 0;
        int result = Digitlen.digitlen(number);
        assertThat(result).isEqualTo(1);
    }

    @Test
    void lengthOfNegativeSingleDigit() {
        long number = -5;
        int result = Digitlen.digitlen(number);
        // Assuming the function counts the digit length without considering the sign
        assertThat(result).isEqualTo(1);
    }

    @Test
    void lengthOfNegativeMultipleDigits() {
        long number = -123456789;
        int result = Digitlen.digitlen(number);
        // Assuming the function counts the digit length without considering the sign
        assertThat(result).isEqualTo(9);
    }
}
