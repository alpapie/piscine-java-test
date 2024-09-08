import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.Random;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(StopAfterFailureExtension.class)
class IntOperationsTest {

    @Test
    void addTwoIntegers_shouldComputeCorrectValue_whenHaveRandomInts() {
        Random random = new Random();
        int a = random.nextInt(1000);
        int b = random.nextInt(1000);

        int res = IntOperations.addTwoIntegers(a, b);

        assertThat(res)
                .withFailMessage("%d + %d should be equal to %d, but was %d", a, b, a + b, res)
                .as("Run %d + %d", a, b)
                .isEqualTo(a + b);
    }

    @Test
    void addTwoIntegers_shouldComputeCorrectValue_whenHaveRandomNegInts() {
        Random random = new Random();
        int a = random.nextInt(1000);
        int b = -1 * random.nextInt(1000);

        int res = IntOperations.addTwoIntegers(a, b);

        assertThat(res)
                .withFailMessage("%d + %d should be equal to %d, but was %d", a, b, a + b, res)
                .as("Run %d + %d", a, b)
                .isEqualTo(a + b);
    }

    @Test
    void subtractTwoIntegers_shouldComputeCorrectValue_whenHaveRandomInts() {
        Random random = new Random();
        int a = random.nextInt(1000);
        int b = random.nextInt(1000);

        int res = IntOperations.subtractTwoIntegers(a, b);

        assertThat(res)
                .withFailMessage("%d - %d should be equal to %d, but was %d", a, b, a - b, res)
                .as("Run %d - %d", a, b)
                .isEqualTo(a - b);
    }

    @Test
    void subtractTwoIntegers_shouldComputeCorrectValue_whenHaveRandomNegInts() {
        Random random = new Random();
        int a = random.nextInt(1000);
        int b = -1 * random.nextInt(1000);

        int res = IntOperations.subtractTwoIntegers(a, b);

        assertThat(res)
                .withFailMessage("%d - %d should be equal to %d, but was %d", a, b, a - b, res)
                .as("Run %d - %d", a, b)
                .isEqualTo(a - b);
    }

    @Test
    void multiplyTwoIntegers_shouldComputeCorrectValue_whenHaveRandomInts() {
        Random random = new Random();
        int a = random.nextInt(1000);
        int b = random.nextInt(1000);

        int res = IntOperations.multiplyTwoIntegers(a, b);

        assertThat(res)
                .withFailMessage("%d * %d should be equal to %d, but was %d", a, b, a * b, res)
                .as("Run %d * %d", a, b)
                .isEqualTo(a * b);
    }

    @Test
    void multiplyTwoIntegers_shouldComputeCorrectValue_whenHaveRandomNegInts() {
        Random random = new Random();
        int a = random.nextInt(1000);
        int b = -1 * random.nextInt(1000);

        int res = IntOperations.multiplyTwoIntegers(a, b);

        assertThat(res)
                .withFailMessage("%d * %d should be equal to %d, but was %d", a, b, a * b, res)
                .as("Run %d * %d", a, b)
                .isEqualTo(a * b);
    }

    @Test
    void divideTwoIntegers_shouldComputeCorrectValue_whenHaveRandomInts() {
        Random random = new Random();
        int a = random.nextInt(1000);
        int b = random.nextInt(15) + 1;

        int res = IntOperations.divideTwoIntegers(a, b);

        assertThat(res)
                .withFailMessage("%d / %d should be equal to %d, but was %d", a, b, a / b, res)
                .as("Run %d / %d", a, b)
                .isEqualTo(a / b);
    }

    @Test
    void divideTwoIntegers_shouldComputeCorrectValue_whenHaveRandomNegInts() {
        Random random = new Random();
        int a = random.nextInt(1000);
        int b = -1 * random.nextInt(15) - 1;

        int res = IntOperations.divideTwoIntegers(a, b);

        assertThat(res)
                .withFailMessage("%d / %d should be equal to %d, but was %d", a, b, a / b, res)
                .as("Run %d / %d", a, b)
                .isEqualTo(a / b);
    }
}