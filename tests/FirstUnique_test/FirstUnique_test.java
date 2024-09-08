import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(StopAfterFailureExtension.class)
class FirstUniqueTest {

    @Test
    void testFindFirstUnique_withUniqueChar() {
        FirstUnique firstUnique = new FirstUnique();
        String s = "leetcode";
        char expected = 'l';
        assertThat(firstUnique.findFirstUnique(s))
                .withFailMessage("Expected first unique character to be %s but got %s", expected, firstUnique.findFirstUnique(s))
                .isEqualTo(expected);
    }

    @Test
    void testFindFirstUnique_withMultipleUniqueChars() {
        FirstUnique firstUnique = new FirstUnique();
        String s = "loveleetcode";
        char expected = 'v';
        assertThat(firstUnique.findFirstUnique(s))
                .withFailMessage("Expected first unique character to be %s but got %s", expected, firstUnique.findFirstUnique(s))
                .isEqualTo(expected);
    }

    @Test
    void testFindFirstUnique_withNoUniqueChar() {
        FirstUnique firstUnique = new FirstUnique();
        String s = "aabbcc";
        char expected = '_';
        assertThat(firstUnique.findFirstUnique(s))
                .withFailMessage("Expected first unique character to be %s but got %s", expected, firstUnique.findFirstUnique(s))
                .isEqualTo(expected);
    }

    @Test
    void testFindFirstUnique_withSingleChar() {
        FirstUnique firstUnique = new FirstUnique();
        String s = "a";
        char expected = 'a';
        assertThat(firstUnique.findFirstUnique(s))
                .withFailMessage("Expected first unique character to be %s but got %s", expected, firstUnique.findFirstUnique(s))
                .isEqualTo(expected);
    }

    @Test
    void testFindFirstUnique_withEmptyString() {
        FirstUnique firstUnique = new FirstUnique();
        String s = "";
        char expected = '_';
        assertThat(firstUnique.findFirstUnique(s))
                .withFailMessage("Expected first unique character to be %s but got %s", expected, firstUnique.findFirstUnique(s))
                .isEqualTo(expected);
    }

    @Test
    void testFindFirstUnique_withNullString() {
        FirstUnique firstUnique = new FirstUnique();
        String s = null;
        char expected = '_';
        assertThat(firstUnique.findFirstUnique(s))
                .withFailMessage("Expected first unique character to be %s but got %s", expected, firstUnique.findFirstUnique(s))
                .isEqualTo(expected);
    }

    @Test
    void testFindFirstUnique_withMixedCaseChars() {
        FirstUnique firstUnique = new FirstUnique();
        String s = "aAbBcC";
        char expected = 'a';
        assertThat(firstUnique.findFirstUnique(s))
                .withFailMessage("Expected first unique character to be %s but got %s", expected, firstUnique.findFirstUnique(s))
                .isEqualTo(expected);
    }

    @Test
    void testFirstUniqueInstance_isNotNull() {
        FirstUnique firstUnique = new FirstUnique();
        assertThat(firstUnique)
                .withFailMessage("Expected FirstUnique instance to be not null, but got null")
                .isNotNull();
    }
}
