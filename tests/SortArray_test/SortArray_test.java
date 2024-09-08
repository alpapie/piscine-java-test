import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(StopAfterFailureExtension.class)
class SortArrayTest {

    @Test
    void sortArrayWithFewElements() {
        Integer[] array = {4, 2, 1, 3};
        Integer[] sortedArray = SortArray.sort(array);
        assertThat(sortedArray).containsExactly(1, 2, 3, 4);
    }

    @Test
    void sortAlreadySortedArray() {
        Integer[] array = {1, 2, 3, 4};
        Integer[] sortedArray = SortArray.sort(array);
        assertThat(sortedArray).containsExactly(1, 2, 3, 4);
    }

    @Test
    void sortReverseSortedArray() {
        Integer[] array = {4, 3, 2, 1};
        Integer[] sortedArray = SortArray.sort(array);
        assertThat(sortedArray).containsExactly(1, 2, 3, 4);
    }

    @Test
    void sortArrayWithDuplicateElements() {
        Integer[] array = {3, 1, 4, 1, 5, 9, 2, 6, 5, 3, 5};
        Integer[] sortedArray = SortArray.sort(array);
        assertThat(sortedArray).containsExactly(1, 1, 2, 3, 3, 4, 5, 5, 5, 6, 9);
    }

    @Test
    void sortEmptyArray() {
        Integer[] array = {};
        Integer[] sortedArray = SortArray.sort(array);
        assertThat(sortedArray).isEmpty();
    }
}
