import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.Random;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(StopAfterFailureExtension.class)
class IsEvenTest {

    @Test
    void isEven_randomInteger_true() {
        Random random = new Random();
        int a = 2 * random.nextInt(1000);

        boolean res = IsEven.isEven(a);

        assertThat(res)
                .withFailMessage("%d should be identified as even but was not", a)
                .isTrue();
    }

    @Test
    void isEven_randomInteger_false() {
        Random random = new Random();
        int a = 2 * random.nextInt(1000) + 1;

        boolean res = IsEven.isEven(a);

        assertThat(res)
                .withFailMessage("%d should be identified as odd but was not", a)
                .isFalse();
    }

    @Test
    void isEven_randomInteger_zero() {
        boolean res = IsEven.isEven(0);

        assertThat(res)
                .withFailMessage("0 should be identified as even but was not")
                .isTrue();
    }

    @Test
    void isEven_randomInteger_one() {
        boolean res = IsEven.isEven(1);

        assertThat(res)
                .withFailMessage("1 should be identified as odd but was not")
                .isFalse();
    }
}