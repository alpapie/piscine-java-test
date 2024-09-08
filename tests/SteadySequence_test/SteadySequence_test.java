import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(StopAfterFailureExtension.class)
class SteadySequenceTest {
    private SteadySequence finder;

    @BeforeEach
    void setUp() {
        finder = new SteadySequence();
    }

    @Test
    void testLongestSequence_withTypicalCase() {
        int[] nums = {100, 4, 200, 1, 3, 2};
        int expected = 4;
        assertThat(finder.longestSequence(nums))
                .withFailMessage("Expected longest sequence length to be %d but got %d", expected, finder.longestSequence(nums))
                .isEqualTo(expected);
    }

    @Test
    void testLongestSequence_withLongSequence() {
        int[] nums = {0, 3, 7, 2, 5, 8, 4, 6, 0, 1};
        int expected = 9;
        assertThat(finder.longestSequence(nums))
                .withFailMessage("Expected longest sequence length to be %d but got %d", expected, finder.longestSequence(nums))
                .isEqualTo(expected);
    }

    @Test
    void testLongestSequence_withRepeatingNumbers() {
        int[] nums = {1, 2, 0, 1};
        int expected = 3;
        assertThat(finder.longestSequence(nums))
                .withFailMessage("Expected longest sequence length to be %d but got %d", expected, finder.longestSequence(nums))
                .isEqualTo(expected);
    }

    @Test
    void testLongestSequence_withSingleNumber() {
        int[] nums = {1};
        int expected = 1;
        assertThat(finder.longestSequence(nums))
                .withFailMessage("Expected longest sequence length to be %d but got %d", expected, finder.longestSequence(nums))
                .isEqualTo(expected);
    }

    @Test
    void testLongestSequence_withEmptyArray() {
        int[] nums = {};
        int expected = 0;
        assertThat(finder.longestSequence(nums))
                .withFailMessage("Expected longest sequence length to be %d but got %d", expected, finder.longestSequence(nums))
                .isEqualTo(expected);
    }

    @Test
    void testLongestSequence_withNegativeNumbers() {
        int[] nums = {-1, -2, -3, 1, 2, 3};
        int expected = 3;
        assertThat(finder.longestSequence(nums))
                .withFailMessage("Expected longest sequence length to be %d but got %d", expected, finder.longestSequence(nums))
                .isEqualTo(expected);
    }

    @Test
    void testLongestSequence_withMixedNumbers() {
        int[] nums = {10, 5, 6, 7, 8, 9, 4};
        int expected = 7;
        assertThat(finder.longestSequence(nums))
                .withFailMessage("Expected longest sequence length to be %d but got %d", expected, finder.longestSequence(nums))
                .isEqualTo(expected);
    }
}
