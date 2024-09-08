import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(StopAfterFailureExtension.class)
class RotateArrayTest {

    @Test
    void rotateArrayByPositiveCountLessThanArrayLength() {
        Integer[] array = {4, 2, 1, 3};
        int rotationCount = 1;
        Integer[] rotatedArray = RotateArray.rotate(array, rotationCount);
        assertThat(rotatedArray).containsExactly(3, 4, 2, 1);
    }

    @Test
    void rotateArrayByPositiveCountGreaterThanArrayLength() {
        Integer[] array = {4, 2, 1, 3};
        int rotationCount = 5; // Same as rotating by 1
        Integer[] rotatedArray = RotateArray.rotate(array, rotationCount);
        assertThat(rotatedArray).containsExactly(3, 4, 2, 1);
    }

    @Test
    void rotateArrayByNegativeCount() {
        Integer[] array = {4, 2, 1, 3};
        int rotationCount = -1;
        Integer[] rotatedArray = RotateArray.rotate(array, rotationCount);
        assertThat(rotatedArray).containsExactly(2, 1, 3, 4);
    }

    @Test
    void rotateArrayByCountOfZero() {
        Integer[] array = {4, 2, 1, 3};
        int rotationCount = 0;
        Integer[] rotatedArray = RotateArray.rotate(array, rotationCount);
        assertThat(rotatedArray).containsExactly(4, 2, 1, 3);
    }

    @Test
    void rotateEmptyArray() {
        Integer[] array = {};
        int rotationCount = 2;
        Integer[] rotatedArray = RotateArray.rotate(array, rotationCount);
        assertThat(rotatedArray).isEmpty();
    }

    @Test
    void rotateArrayByNegativeCountGreaterThanArrayLength() {
        Integer[] array = {1, 2, 3, 4, 5};
        int rotationCount = -6; // Same as rotating by -1 or 4 to the right
        Integer[] rotatedArray = RotateArray.rotate(array, rotationCount);
        assertThat(rotatedArray).containsExactly(2, 3, 4, 5, 1);
    }
}
