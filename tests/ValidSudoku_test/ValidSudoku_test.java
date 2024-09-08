import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(StopAfterFailureExtension.class)
class ValidSudokuTest {

    @Test
    void testIsValidSudoku_withValidBoard() {
        ValidSudoku validSudoku = new ValidSudoku();
        char[][] board = {
            {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
            {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
            {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
            {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
            {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
            {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
            {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
            {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
            {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        assertThat(validSudoku.isValidSudoku(board))
                .withFailMessage("Expected board to be valid")
                .isTrue();
    }

    @Test
    void testIsValidSudoku_withInvalidBoard() {
        ValidSudoku validSudoku = new ValidSudoku();
        char[][] board = {
            {'8', '3', '.', '.', '7', '.', '.', '.', '.'},
            {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
            {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
            {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
            {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
            {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
            {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
            {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
            {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        assertThat(validSudoku.isValidSudoku(board))
                .withFailMessage("Expected board to be invalid")
                .isFalse();
    }

    @Test
    void testIsValidSudoku_withEmptyBoard() {
        ValidSudoku validSudoku = new ValidSudoku();
        char[][] board = {
            {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
            {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
            {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
            {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
            {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
            {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
            {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
            {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
            {'.', '.', '.', '.', '.', '.', '.', '.', '.'}
        };
        assertThat(validSudoku.isValidSudoku(board))
                .withFailMessage("Expected board to be valid")
                .isTrue();
    }

    @Test
    void testIsValidSudoku_withSingleValueBoard() {
        ValidSudoku validSudoku = new ValidSudoku();
        char[][] board = {
            {'5', '.', '.', '.', '.', '.', '.', '.', '.'},
            {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
            {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
            {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
            {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
            {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
            {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
            {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
            {'.', '.', '.', '.', '.', '.', '.', '.', '.'}
        };
        assertThat(validSudoku.isValidSudoku(board))
                .withFailMessage("Expected board to be valid")
                .isTrue();
    }

    @Test
    void testIsValidSudoku_withInvalidSingleValueBoard() {
        ValidSudoku validSudoku = new ValidSudoku();
        char[][] board = {
            {'5', '.', '.', '.', '.', '.', '.', '.', '.'},
            {'.', '5', '.', '.', '.', '.', '.', '.', '.'},
            {'.', '.', '5', '.', '.', '.', '.', '.', '.'},
            {'.', '.', '.', '5', '.', '.', '.', '.', '.'},
            {'.', '.', '.', '.', '5', '.', '.', '.', '.'},
            {'.', '.', '.', '.', '.', '5', '.', '.', '.'},
            {'.', '.', '.', '.', '.', '.', '5', '.', '.'},
            {'.', '.', '.', '.', '.', '.', '.', '5', '.'},
            {'.', '.', '.', '.', '.', '.', '.', '.', '5'}
        };
        assertThat(validSudoku.isValidSudoku(board))
                .withFailMessage("Expected board to be invalid")
                .isFalse();
    }

    @Test
    void testValidSudokuInstance_isNotNull() {
        ValidSudoku validSudoku = new ValidSudoku();
        assertThat(validSudoku)
                .withFailMessage("Expected ValidSudoku instance to be not null, but got null")
                .isNotNull();
    }
}
