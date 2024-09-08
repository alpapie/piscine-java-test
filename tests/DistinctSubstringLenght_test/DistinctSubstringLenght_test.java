import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(StopAfterFailureExtension.class)
class DistinctSubstringLenghtTest {
    private DistinctSubstringLength finder;

    @BeforeEach
    void setUp() {
        finder = new DistinctSubstringLength();
    }

    @Test
    void testMaxLength_withDistinctCharacters() {
        assertThat(finder.maxLength("abcabcbb"))
                .withFailMessage("Expected 3 for 'abcabcbb' but got %d", finder.maxLength("abcabcbb"))
                .isEqualTo(3);
        assertThat(finder.maxLength("pwwkew"))
                .withFailMessage("Expected 3 for 'pwwkew' but got %d", finder.maxLength("pwwkew"))
                .isEqualTo(3);
    }

    @Test
    void testMaxLength_withRepeatingCharacters() {
        assertThat(finder.maxLength("bbbbb"))
                .withFailMessage("Expected 1 for 'bbbbb' but got %d", finder.maxLength("bbbbb"))
                .isEqualTo(1);
        assertThat(finder.maxLength("aa"))
                .withFailMessage("Expected 1 for 'aa' but got %d", finder.maxLength("aa"))
                .isEqualTo(1);
    }

    @Test
    void testMaxLength_withMixedCharacters() {
        assertThat(finder.maxLength("dvdf"))
                .withFailMessage("Expected 3 for 'dvdf' but got %d", finder.maxLength("dvdf"))
                .isEqualTo(3);
        assertThat(finder.maxLength("anviaj"))
                .withFailMessage("Expected 5 for 'anviaj' but got %d", finder.maxLength("anviaj"))
                .isEqualTo(5);
    }

    @Test
    void testMaxLength_withEmptyString() {
        assertThat(finder.maxLength(""))
                .withFailMessage("Expected 0 for empty string but got %d", finder.maxLength(""))
                .isEqualTo(0);
    }

    @Test
    void testMaxLength_withSingleCharacterString() {
        assertThat(finder.maxLength("a"))
                .withFailMessage("Expected 1 for 'a' but got %d", finder.maxLength("a"))
                .isEqualTo(1);
    }

    @Test
    void testMaxLength_withLongString() {
        String longString = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        assertThat(finder.maxLength(longString))
                .withFailMessage("Expected 52 for a long string but got %d", finder.maxLength(longString))
                .isEqualTo(52);
    }

    @Test
    void testMaxLength_withSpecialCharacters() {
        assertThat(finder.maxLength("abc!@#abc!@#"))
                .withFailMessage("Expected 6 for 'abc!@#abc!@#' but got %d", finder.maxLength("abc!@#abc!@#"))
                .isEqualTo(6);
    }

    @Test
    void testMaxLength_withNumbers() {
        assertThat(finder.maxLength("1234512345"))
                .withFailMessage("Expected 5 for '1234512345' but got %d", finder.maxLength("1234512345"))
                .isEqualTo(5);
    }

    @Test
    void testMaxLength_withSpaces() {
        assertThat(finder.maxLength("abc def ghi"))
                .withFailMessage("Expected 7 for 'abc def ghi' but got %d", finder.maxLength("abc def ghi"))
                .isEqualTo(7);
    }

    @Test
    void testMaxLength_withEmptySpaceCharacters() {
        assertThat(finder.maxLength(" "))
                .withFailMessage("Expected 1 for single space character but got %d", finder.maxLength(" "))
                .isEqualTo(1);
        assertThat(finder.maxLength("     "))
                .withFailMessage("Expected 1 for multiple space characters but got %d", finder.maxLength("     "))
                .isEqualTo(1);
    }
}
