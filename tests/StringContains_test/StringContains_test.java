import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(StopAfterFailureExtension.class)
class StringContainsTest {

    @Test
    void isStringContainedIn_shouldReturnTrue_withBonAndBonjour() {
        boolean res = StringContains.isStringContainedIn("Bon", "Bonjour");

        assertThat(res)
                .withFailMessage("Should return true for with sublist \"Bon\" and string \"Bonjour\", but return false")
                .isTrue();
    }

    @Test
    void isStringContainedIn_shouldReturnFalse_withBonAndBonjourLowerCase() {
        boolean res = StringContains.isStringContainedIn("Bon", "bonjour");

        assertThat(res)
                .withFailMessage("Should return false for with sublist \"Bon\" and string \"bonjour\", but return true")
                .isFalse();
    }

    @Test
    void isStringContainedIn_shouldReturnFalse_withHelloAndBonjour() {
        boolean res = StringContains.isStringContainedIn("Hello", "Bonjour");

        assertThat(res)
                .withFailMessage(
                        "Should return false for with sublist \"Hello\" and string \"Bonjour\", but return true")
                .isFalse();
    }

    @Test
    void isStringContainedIn_shouldReturnFalse_withNullAndBonjour() {
        boolean res = StringContains.isStringContainedIn(null, "Bonjour");

        assertThat(res)
                .withFailMessage("Should return false for with sublist null and string \"Bonjour\", but return true")
                .isFalse();
    }

    @Test
    void isStringContainedIn_shouldReturnFalse_withHelloAndNull() {
        boolean res = StringContains.isStringContainedIn("bon", null);

        assertThat(res)
                .withFailMessage("Should return false for with sublist \"bon\" and string null, but return true")
                .isFalse();
    }

}