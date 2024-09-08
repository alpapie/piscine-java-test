import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(StopAfterFailureExtension.class)
class SpiralMatrixTest {
    private SpiralMatrix spiralMatrix;

    @BeforeEach
    void setUp() {
        spiralMatrix = new SpiralMatrix();
    }

    @Test
    void testGenerateMatrix_withN3() {
        int n = 3;
        int[][] expected = {
            {1, 2, 3},
            {8, 9, 4},
            {7, 6, 5}
        };

        assertThat(spiralMatrix.generateMatrix(n))
                .withFailMessage("Expected spiral matrix for n = 3 but got different matrix")
                .isDeepEqualTo(expected);
    }

    @Test
    void testGenerateMatrix_withN4() {
        int n = 4;
        int[][] expected = {
            {1, 2, 3, 4},
            {12, 13, 14, 5},
            {11, 16, 15, 6},
            {10, 9, 8, 7}
        };

        assertThat(spiralMatrix.generateMatrix(n))
                .withFailMessage("Expected spiral matrix for n = 4 but got different matrix")
                .isDeepEqualTo(expected);
    }

    @Test
    void testGenerateMatrix_withN1() {
        int n = 1;
        int[][] expected = {
            {1}
        };

        assertThat(spiralMatrix.generateMatrix(n))
                .withFailMessage("Expected spiral matrix for n = 1 but got different matrix")
                .isDeepEqualTo(expected);
    }

    @Test
    void testGenerateMatrix_withN5() {
        int n = 5;
        int[][] expected = {
            {1, 2, 3, 4, 5},
            {16, 17, 18, 19, 6},
            {15, 24, 25, 20, 7},
            {14, 23, 22, 21, 8},
            {13, 12, 11, 10, 9}
        };

        assertThat(spiralMatrix.generateMatrix(n))
                .withFailMessage("Expected spiral matrix for n = 5 but got different matrix")
                .isDeepEqualTo(expected);
    }
}
