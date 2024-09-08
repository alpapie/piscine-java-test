import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(StopAfterFailureExtension.class)
class NextPrimeTest {

    @Test
    void nextPrimeAfterAPrimeNumber() {
        assertThat(NextPrime.nextPrime(3)).isEqualTo(5);
        assertThat(NextPrime.nextPrime(5)).isEqualTo(7);
    }

    @Test
    void nextPrimeAfterANonPrimeNumber() {
        assertThat(NextPrime.nextPrime(4)).isEqualTo(5);
        assertThat(NextPrime.nextPrime(8)).isEqualTo(11);
    }

    @Test
    void nextPrimeAfterZeroAndOne() {
        assertThat(NextPrime.nextPrime(0)).isEqualTo(2); // Assuming 2 as the first prime number
        assertThat(NextPrime.nextPrime(1)).isEqualTo(2);
    }

    @Test
    void nextPrimeAfterALargeNumber() {
        assertThat(NextPrime.nextPrime(29)).isEqualTo(31);
    }

    @Test
    void nextPrimeAfterANegativeNumber() {
        assertThat(NextPrime.nextPrime(-5)).isEqualTo(2); // Assuming the search starts at 2 for negative inputs
    }
}
