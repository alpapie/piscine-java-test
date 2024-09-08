import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(StopAfterFailureExtension.class)
class PalindromeTest {

    @Test
    void isPalindrome_shouldReturnTrue_whenRadar() {
        boolean res = Palindrome.isPalindrome("radar");

        assertThat(res)
                .withFailMessage("Should return true for String \"radar\", but return false")
                .isTrue();
    }

    @Test
    void isPalindrome_shouldReturnTrue_whenAbbaAndDifferentCase() {
        boolean res = Palindrome.isPalindrome("AbBa");

        assertThat(res)
                .withFailMessage("Should return true for String \"AbBa\", but return false")
                .isTrue();
    }

    @Test
    void isPalindrome_shouldReturnFalse_whenKayakWithSpace() {
        boolean res = Palindrome.isPalindrome("kay ak");

        assertThat(res)
                .withFailMessage("Should return false for String \"kay ak\", but return true")
                .isFalse();
    }

    @Test
    void isPalindrome_shouldReturnFalse_whenHello() {
        boolean res = Palindrome.isPalindrome("hello");

        assertThat(res)
                .withFailMessage("Should return false for String \"hello\", but return true")
                .isFalse();
    }

    @Test
    void isPalindrome_shouldReturnTrue_whenEmpty() {
        boolean res = Palindrome.isPalindrome("");

        assertThat(res)
                .withFailMessage("Should return true for String \"\", but return false")
                .isTrue();
    }

    @Test
    void isPalindrome_shouldReturnFalse_whenNull() {
        boolean res = Palindrome.isPalindrome(null);

        assertThat(res)
                .withFailMessage("Should return false for null, but return true")
                .isFalse();
    }

}