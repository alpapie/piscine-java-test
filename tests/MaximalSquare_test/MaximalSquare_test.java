import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(StopAfterFailureExtension.class)
class MaximalSquareTest {
    private MaximalSquare finder;

    @BeforeEach
    void setUp() {
        finder = new MaximalSquare();
    }

    @Test
    void testMaximalSquare_withLargerMatrix() {
        char[][] matrix = {
            {'1', '0', '1', '0', '0'},
            {'1', '0', '1', '1', '1'},
            {'1', '1', '1', '1', '1'},
            {'1', '0', '0', '1', '0'}
        };
        int expected = 4;
        assertThat(finder.maximalSquare(matrix))
                .withFailMessage("Expected maximal square area to be %d but got %d", expected, finder.maximalSquare(matrix))
                .isEqualTo(expected);
    }

    @Test
    void testMaximalSquare_withSmallerMatrix() {
        char[][] matrix = {
            {'0', '1'},
            {'1', '0'}
        };
        int expected = 1;
        assertThat(finder.maximalSquare(matrix))
                .withFailMessage("Expected maximal square area to be %d but got %d", expected, finder.maximalSquare(matrix))
                .isEqualTo(expected);
    }

    @Test
    void testMaximalSquare_withSingleElementMatrix() {
        char[][] matrix = {
            {'0'}
        };
        int expected = 0;
        assertThat(finder.maximalSquare(matrix))
                .withFailMessage("Expected maximal square area to be %d but got %d", expected, finder.maximalSquare(matrix))
                .isEqualTo(expected);
    }

    @Test
    void testMaximalSquare_withAllOnesMatrix() {
        char[][] matrix = {
            {'1', '1'},
            {'1', '1'}
        };
        int expected = 4;
        assertThat(finder.maximalSquare(matrix))
                .withFailMessage("Expected maximal square area to be %d but got %d", expected, finder.maximalSquare(matrix))
                .isEqualTo(expected);
    }

    @Test
    void testMaximalSquare_withMixedElementsMatrix() {
        char[][] matrix = {
            {'1', '1', '1', '0'},
            {'1', '1', '1', '1'},
            {'1', '1', '1', '1'},
            {'0', '1', '1', '1'}
        };
        int expected = 9;
        assertThat(finder.maximalSquare(matrix))
                .withFailMessage("Expected maximal square area to be %d but got %d", expected, finder.maximalSquare(matrix))
                .isEqualTo(expected);
    }

    @Test
    void testMaximalSquare_withEmptyMatrix() {
        char[][] matrix = {};
        int expected = 0;
        assertThat(finder.maximalSquare(matrix))
                .withFailMessage("Expected maximal square area to be %d but got %d", expected, finder.maximalSquare(matrix))
                .isEqualTo(expected);
    }
}
