import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(StopAfterFailureExtension.class)
class LongestCommonPrefixTest {

    @Test
    void testLongestCommonPrefix_withCommonPrefix() {
        LongestCommonPrefix lcp = new LongestCommonPrefix();
        String[] strs = {"flower", "flow", "flight"};
        String expected = "fl";
        assertThat(lcp.findLongestCommonPrefix(strs))
                .withFailMessage("Expected longest common prefix to be %s but got %s", expected, lcp.findLongestCommonPrefix(strs))
                .isEqualTo(expected);
    }

    @Test
    void testLongestCommonPrefix_withoutCommonPrefix() {
        LongestCommonPrefix lcp = new LongestCommonPrefix();
        String[] strs = {"dog", "racecar", "car"};
        String expected = "";
        assertThat(lcp.findLongestCommonPrefix(strs))
                .withFailMessage("Expected longest common prefix to be %s but got %s", expected, lcp.findLongestCommonPrefix(strs))
                .isEqualTo(expected);
    }

    @Test
    void testLongestCommonPrefix_withLongCommonPrefix() {
        LongestCommonPrefix lcp = new LongestCommonPrefix();
        String[] strs = {"interspecies", "interstellar", "interstate"};
        String expected = "inters";
        assertThat(lcp.findLongestCommonPrefix(strs))
                .withFailMessage("Expected longest common prefix to be %s but got %s", expected, lcp.findLongestCommonPrefix(strs))
                .isEqualTo(expected);
    }

    @Test
    void testLongestCommonPrefix_withSingleString() {
        LongestCommonPrefix lcp = new LongestCommonPrefix();
        String[] strs = {"single"};
        String expected = "single";
        assertThat(lcp.findLongestCommonPrefix(strs))
                .withFailMessage("Expected longest common prefix to be %s but got %s", expected, lcp.findLongestCommonPrefix(strs))
                .isEqualTo(expected);
    }

    @Test
    void testLongestCommonPrefix_withEmptyArray() {
        LongestCommonPrefix lcp = new LongestCommonPrefix();
        String[] strs = {};
        String expected = "";
        assertThat(lcp.findLongestCommonPrefix(strs))
                .withFailMessage("Expected longest common prefix to be %s but got %s", expected, lcp.findLongestCommonPrefix(strs))
                .isEqualTo(expected);
    }

    @Test
    void testLongestCommonPrefix_withEmptyStrings() {
        LongestCommonPrefix lcp = new LongestCommonPrefix();
        String[] strs = {"", "", ""};
        String expected = "";
        assertThat(lcp.findLongestCommonPrefix(strs))
                .withFailMessage("Expected longest common prefix to be %s but got %s", expected, lcp.findLongestCommonPrefix(strs))
                .isEqualTo(expected);
    }

    @Test
    void testLongestCommonPrefix_withMixedCase() {
        LongestCommonPrefix lcp = new LongestCommonPrefix();
        String[] strs = {"Flower", "flow", "flight"};
        String expected = "";
        assertThat(lcp.findLongestCommonPrefix(strs))
                .withFailMessage("Expected longest common prefix to be %s but got %s", expected, lcp.findLongestCommonPrefix(strs))
                .isEqualTo(expected);
    }

    @Test
    void testLongestCommonPrefix_isNotNull() {
        LongestCommonPrefix lcp = new LongestCommonPrefix();
        String[] strs = {"test"};
        assertThat(lcp.findLongestCommonPrefix(strs))
                .withFailMessage("Expected longest common prefix to be not null")
                .isNotNull();
    }
}
