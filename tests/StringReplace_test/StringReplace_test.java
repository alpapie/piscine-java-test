import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(StopAfterFailureExtension.class)
class StringReplaceTest {

    @Test
    void ReplaceChar() {
        String res = StringReplace.replace("javatpoint is a very good website", 'a', 'e');

        assertThat(res)
                .withFailMessage("Should return 'jevetpoint is e very good website', '%s' was returned", res)
                .isEqualTo("jevetpoint is e very good website");
    }

    @Test
    void ReplaceUnavailableChar() {
        String res = StringReplace.replace("no change very good", 'f', 'e');

        assertThat(res)
                .withFailMessage("Should return 'no change very good', '%s' was returned", res)
                .isEqualTo("no change very good");
    }

    @Test
    void ReplaceString() {
        String res = StringReplace.replace("my name is khan my name is java", "is", "was");

        assertThat(res)
                .withFailMessage("Should return 'my name was khan my name was java', '%s' was returned", res)
                .isEqualTo("my name was khan my name was java");
    }

    @Test
    void ReplaceUnavailableString() {
        String res = StringReplace.replace("hey i'am java", "I'am", "was");

        assertThat(res)
                .withFailMessage("Should return 'hey i'am java', '%s' was returned", res)
                .isEqualTo("hey i'am java");
    }
}