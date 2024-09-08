import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(StopAfterFailureExtension.class)
class ArmstrongNumberTest {

    @Test
    void testIsArmstrong_withArmstrongNumber() {
        ArmstrongNumber armstrongNumber = new ArmstrongNumber();
        int number = 153;
        assertThat(armstrongNumber.isArmstrong(number))
                .withFailMessage("Expected %d to be an Armstrong number", number)
                .isTrue();
    }

    @Test
    void testIsArmstrong_withNonArmstrongNumber() {
        ArmstrongNumber armstrongNumber = new ArmstrongNumber();
        int number = 123;
        assertThat(armstrongNumber.isArmstrong(number))
                .withFailMessage("Expected %d to not be an Armstrong number", number)
                .isFalse();
    }

    @Test
    void testIsArmstrong_withLargeArmstrongNumber() {
        ArmstrongNumber armstrongNumber = new ArmstrongNumber();
        int number = 9474;
        assertThat(armstrongNumber.isArmstrong(number))
                .withFailMessage("Expected %d to be an Armstrong number", number)
                .isTrue();
    }

    @Test
    void testIsArmstrong_withSingleDigitArmstrongNumber() {
        ArmstrongNumber armstrongNumber = new ArmstrongNumber();
        int number = 5;
        assertThat(armstrongNumber.isArmstrong(number))
                .withFailMessage("Expected %d to be an Armstrong number", number)
                .isTrue();
    }

    @Test
    void testIsArmstrong_withZero() {
        ArmstrongNumber armstrongNumber = new ArmstrongNumber();
        int number = 0;
        assertThat(armstrongNumber.isArmstrong(number))
                .withFailMessage("Expected %d to be an Armstrong number", number)
                .isTrue();
    }

    @Test
    void testIsArmstrong_withNegativeNumber() {
        ArmstrongNumber armstrongNumber = new ArmstrongNumber();
        int number = -153;
        assertThat(armstrongNumber.isArmstrong(number))
                .withFailMessage("Expected %d to not be an Armstrong number", number)
                .isFalse();
    }

    @Test
    void testArmstrongNumberInstance_isNotNull() {
        ArmstrongNumber armstrongNumber = new ArmstrongNumber();
        assertThat(armstrongNumber)
                .withFailMessage("Expected ArmstrongNumber instance to be not null, but got null")
                .isNotNull();
    }
}
