import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.Random;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(StopAfterFailureExtension.class)
class ComputeArrayTest {

    @Test
    void computeArray_shouldReturnTheCorrectArray() {
        int[] res = ComputeArray.computeArray(new int[] { 13, 65, 6, -74, 15, 4, -1, -6, 10 });

        assertThat(res).containsExactly(20, 65, 30, -74, 75, 11, -1, -30, 17);
    }

    @Test
    void computeArray_shouldReturnTheCorrectArray_withRandomValue() {
        Random random = new Random();
        var a = 3 * random.nextInt(50);
        var b = 3 * random.nextInt(50) + 1;
        var c = 3 * random.nextInt(50) + 2;
        int[] res = ComputeArray.computeArray(new int[] { a, b, c });

        assertThat(res).containsExactly(5 * a, b + 7, c);
    }

    @Test
    void computeArray_shouldReturnEmptyArray_whenArrayIsEmpty() {
        int[] res = ComputeArray.computeArray(new int[0]);

        assertThat(res).isEmpty();
    }

    @Test
    void computeArray_shouldReturnNull_whenNull() {
        int[] res = ComputeArray.computeArray(null);

        assertThat(res).isNull();
    }

}