import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(StopAfterFailureExtension.class)
class AlmostPalindromeTest {

    @Test
    void stringIsAlmostPalindromeByRemovingLastCharacter() {
        assertThat(AlmostPalindrome.isAlmostPalindrome("radarx")).isTrue();
    }

    @Test
    void stringIsAlmostPalindromeByRemovingFirstCharacter() {
        assertThat(AlmostPalindrome.isAlmostPalindrome("ddeified")).isTrue();
    }

    @Test
    void stringIsAlmostPalindromeByRemovingMiddleCharacter() {
        assertThat(AlmostPalindrome.isAlmostPalindrome("rotaitor")).isTrue();
    }

    @Test
    void stringIsNotAlmostPalindromeEvenAfterRemovingOneCharacter() {
        assertThat(AlmostPalindrome.isAlmostPalindrome("example")).isFalse();
    }

    @Test
    void almostPalindromeWithMixedCase() {
        assertThat(AlmostPalindrome.isAlmostPalindrome("Racedcar")).isTrue();
    }

    @Test
    void almostPalindromeWithSpecialCharacters() {
        assertThat(AlmostPalindrome.isAlmostPalindrome("w,ow")).isTrue();
        assertThat(AlmostPalindrome.isAlmostPalindrome("wo,ow")).isFalse();

    }

    @Test
    void stringWithMinimumLength() {
        assertThat(AlmostPalindrome.isAlmostPalindrome("aaa")).isFalse();
        assertThat(AlmostPalindrome.isAlmostPalindrome("abb")).isTrue();
        assertThat(AlmostPalindrome.isAlmostPalindrome("abc")).isFalse();
    }

    @Test
    void palindromeStringAsInput() {
        assertThat(AlmostPalindrome.isAlmostPalindrome("level")).isFalse(); // From your usage example, it's a full palindrome, not "almost"
    }
}
