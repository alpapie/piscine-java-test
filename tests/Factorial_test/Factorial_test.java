import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(StopAfterFailureExtension.class)
class FactorialTest {

    @Test
    void factorialOfZero() {
        Integer result = Factorial.factorial(0);
        assertThat(result).isEqualTo(1); // 0! = 1 by definition
    }

    @Test
    void factorialOfSmallPositiveInteger() {
        Integer result = Factorial.factorial(3);
        assertThat(result).isEqualTo(6); // 3! = 3 × 2 × 1 = 6
    }

    @Test
    void factorialOfLargerInteger() {
        Integer result = Factorial.factorial(5);
        assertThat(result).isEqualTo(120); // 5! = 5 × 4 × 3 × 2 × 1 = 120
    }

    @Test
    void factorialOfTen() {
        Integer result = Factorial.factorial(10);
        assertThat(result).isEqualTo(3628800); // 10! = 10 × 9 × ... × 1 = 3,628,800
    }
}
