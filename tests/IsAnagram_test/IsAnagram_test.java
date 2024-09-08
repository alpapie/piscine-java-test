import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(StopAfterFailureExtension.class)
class IsAnagramTest {
    private AnagramChecker checker;

    @BeforeEach
    void setUp() {
        checker = new AnagramChecker();
    }

    @Test
    void testIsAnagram_withValidAnagrams() {
        assertThat(checker.isAnagram("listen", "silent"))
                .withFailMessage("Expected true for 'listen' and 'silent' but got false")
                .isTrue();
        assertThat(checker.isAnagram("triangle", "integral"))
                .withFailMessage("Expected true for 'triangle' and 'integral' but got false")
                .isTrue();
        assertThat(checker.isAnagram("Astronomer", "Moon starer"))
                .withFailMessage("Expected false for 'Astronomer' and 'Moon starer' but got true")
                .isFalse();
        assertThat(checker.isAnagram("The eyes", "They see"))
                .withFailMessage("Expected true for 'The eyes' and 'They see' but got false")
                .isTrue();
    }

    @Test
    void testIsAnagram_withInvalidAnagrams() {
        assertThat(checker.isAnagram("apple", "pale"))
                .withFailMessage("Expected false for 'apple' and 'pale' but got true")
                .isFalse();
        assertThat(checker.isAnagram("hello", "world"))
                .withFailMessage("Expected false for 'hello' and 'world' but got true")
                .isFalse();
        assertThat(checker.isAnagram("good", "bad"))
                .withFailMessage("Expected false for 'good' and 'bad' but got true")
                .isFalse();
    }

    @Test
    void testIsAnagram_withEmptyStrings() {
        assertThat(checker.isAnagram("", ""))
                .withFailMessage("Expected true for empty strings but got false")
                .isTrue();
        assertThat(checker.isAnagram("a", ""))
                .withFailMessage("Expected false for 'a' and empty string but got true")
                .isFalse();
        assertThat(checker.isAnagram("", "b"))
                .withFailMessage("Expected false for empty string and 'b' but got true")
                .isFalse();
    }

    @Test
    void testIsAnagram_withDifferentCasing() {
        assertThat(checker.isAnagram("Listen", "Silent"))
                .withFailMessage("Expected true for 'Listen' and 'Silent' with different casing but got false")
                .isTrue();
        assertThat(checker.isAnagram("Triangle", "Integral"))
                .withFailMessage("Expected true for 'Triangle' and 'Integral' with different casing but got false")
                .isTrue();
    }

    @Test
    void testIsAnagram_withSpecialCharacters() {
        assertThat(checker.isAnagram("A gentleman", "Elegant man"))
                .withFailMessage("Expected true for 'A gentleman' and 'Elegant man' with spaces but got false")
                .isTrue();
        assertThat(checker.isAnagram("School master", "The classroom"))
                .withFailMessage("Expected true for 'School master' and 'The classroom' with spaces but got false")
                .isTrue();
    }
}
