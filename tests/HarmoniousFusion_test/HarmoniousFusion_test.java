import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(StopAfterFailureExtension.class)
class HarmoniousFusionTest {
    private HarmoniousFusion merger;

    @BeforeEach
    void setUp() {
        merger = new HarmoniousFusion();
    }

    @Test
    void testMerge_withEqualSizedArrays() {
        int[] arr1 = {1, 3, 5};
        int[] arr2 = {2, 4, 6};
        int[] expected = {1, 2, 3, 4, 5, 6};

        assertThat(merger.merge(arr1, arr2))
                .withFailMessage("Expected %s but got %s", Arrays.toString(expected), Arrays.toString(merger.merge(arr1, arr2)))
                .isEqualTo(expected);
    }

    @Test
    void testMerge_withDifferentSizedArrays() {
        int[] arr1 = {1, 3, 5, 7};
        int[] arr2 = {2, 4, 6};
        int[] expected = {1, 2, 3, 4, 5, 6, 7};

        assertThat(merger.merge(arr1, arr2))
                .withFailMessage("Expected %s but got %s", Arrays.toString(expected), Arrays.toString(merger.merge(arr1, arr2)))
                .isEqualTo(expected);
    }

    @Test
    void testMerge_withEmptyFirstArray() {
        int[] arr1 = {};
        int[] arr2 = {1, 2, 3};
        int[] expected = {1, 2, 3};

        assertThat(merger.merge(arr1, arr2))
                .withFailMessage("Expected %s but got %s", Arrays.toString(expected), Arrays.toString(merger.merge(arr1, arr2)))
                .isEqualTo(expected);
    }

    @Test
    void testMerge_withEmptySecondArray() {
        int[] arr1 = {1, 2, 3};
        int[] arr2 = {};
        int[] expected = {1, 2, 3};

        assertThat(merger.merge(arr1, arr2))
                .withFailMessage("Expected %s but got %s", Arrays.toString(expected), Arrays.toString(merger.merge(arr1, arr2)))
                .isEqualTo(expected);
    }

    @Test
    void testMerge_withBothArraysEmpty() {
        int[] arr1 = {};
        int[] arr2 = {};
        int[] expected = {};

        assertThat(merger.merge(arr1, arr2))
                .withFailMessage("Expected %s but got %s", Arrays.toString(expected), Arrays.toString(merger.merge(arr1, arr2)))
                .isEqualTo(expected);
    }
}
