import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(StopAfterFailureExtension.class)
class TopFrequentsTest {

    @Test
    void testFindTopKFrequent_withMultipleElements() {
        TopFrequents topFrequents = new TopFrequents();
        int[] nums = {1, 1, 1, 2, 2, 3};
        int k = 2;
        List<Integer> expected = Arrays.asList(1, 2);
        assertThat(topFrequents.findTopKFrequent(nums, k))
                .withFailMessage("Expected top " + k + " frequent elements to be %s but got %s", expected, topFrequents.findTopKFrequent(nums, k))
                .isEqualTo(expected);
    }

    @Test
    void testFindTopKFrequent_withSingleElement() {
        TopFrequents topFrequents = new TopFrequents();
        int[] nums = {1};
        int k = 1;
        List<Integer> expected = Arrays.asList(1);
        assertThat(topFrequents.findTopKFrequent(nums, k))
                .withFailMessage("Expected top " + k + " frequent elements to be %s but got %s", expected, topFrequents.findTopKFrequent(nums, k))
                .isEqualTo(expected);
    }

    @Test
    void testFindTopKFrequent_withNegativeElements() {
        TopFrequents topFrequents = new TopFrequents();
        int[] nums = {4, 1, -1, 2, -1, 2, 3};
        int k = 2;
        List<Integer> expected = Arrays.asList(-1, 2);
        assertThat(topFrequents.findTopKFrequent(nums, k))
                .withFailMessage("Expected top " + k + " frequent elements to be %s but got %s", expected, topFrequents.findTopKFrequent(nums, k))
                .isEqualTo(expected);
    }

    @Test
    void testFindTopKFrequent_withGreaterK() {
        TopFrequents topFrequents = new TopFrequents();
        int[] nums = {4, 1, -1, 2, -1, 2, 3};
        int k = 10;
        List<Integer> expected = Arrays.asList(-1, 2, 4, 1, 3);
        assertThat(topFrequents.findTopKFrequent(nums, k))
                .withFailMessage("Expected top " + k + " frequent elements to be %s but got %s", expected, topFrequents.findTopKFrequent(nums, k))
                .isEqualTo(expected);
    }

    @Test
    void testFindTopKFrequent_withAllElementsSameFrequency() {
        TopFrequents topFrequents = new TopFrequents();
        int[] nums = {1, 2, 3, 4};
        int k = 2;
        List<Integer> expected = Arrays.asList(1, 2); // Note: Any two elements would be correct here as they all have the same frequency.
        assertThat(topFrequents.findTopKFrequent(nums, k))
                .withFailMessage("Expected top " + k + " frequent elements to be %s but got %s", expected, topFrequents.findTopKFrequent(nums, k))
                .containsAnyElementsOf(expected);
    }

    @Test
    void testTopFrequentsInstance_equalityReturnOrder() {
        TopFrequents topFrequents = new TopFrequents();
        int[] nums = {4, 2, 2, 4};
        int k = 2;
        List<Integer> expected = Arrays.asList(4, 2); // Note: Any two elements would be correct here as they all have the same frequency.
        assertThat(topFrequents.findTopKFrequent(nums, k))
                .withFailMessage("Expected top " + k + " frequent elements to be %s but got %s", expected, topFrequents.findTopKFrequent(nums, k))
                .isEqualTo(expected);
    }
}
