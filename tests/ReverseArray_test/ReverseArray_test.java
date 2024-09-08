import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(StopAfterFailureExtension.class)
class ReverseArrayTest {

    @Test
    void reverseArrayWithMultipleElements() {
        Integer[] array = {4, 2, 1, 3};
        Integer[] reversedArray = ReverseArray.reverse(array);
        assertThat(reversedArray).containsExactly(3, 1, 2, 4);
    }

    @Test
    void reverseSingleElementArray() {
        Integer[] array = {1};
        Integer[] reversedArray = ReverseArray.reverse(array);
        assertThat(reversedArray).containsExactly(1);
    }

    @Test
    void reverseEmptyArray() {
        Integer[] array = {};
        Integer[] reversedArray = ReverseArray.reverse(array);
        assertThat(reversedArray).isEmpty();
    }

    @Test
    void reverseArrayWithDuplicateElements() {
        Integer[] array = {3, 5, 3, 1};
        Integer[] reversedArray = ReverseArray.reverse(array);
        assertThat(reversedArray).containsExactly(1, 3, 5, 3);
    }

    @Test
    void reverseArrayWithEvenNumberOfElements() {
        Integer[] array = {1, 2, 3, 4, 5, 6};
        Integer[] reversedArray = ReverseArray.reverse(array);
        assertThat(reversedArray).containsExactly(6, 5, 4, 3, 2, 1);
    }

    @Test
    void reverseArrayWithOddNumberOfElements() {
        Integer[] array = {7, 8, 9, 10, 11};
        Integer[] reversedArray = ReverseArray.reverse(array);
        assertThat(reversedArray).containsExactly(11, 10, 9, 8, 7);
    }
}
