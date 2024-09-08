import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(StopAfterFailureExtension.class)
class CleanExtractTest {

    @Test
    void EmptyString() {
        String res = CleanExtract.extract("");

        assertThat(res)
                .withFailMessage("Should return '', '%s' was returned", res)
                .isEqualTo("");
    }

    @Test
    void OnlySpaces() {
        String res = CleanExtract.extract(".|.. | | .   .|.      ");

        assertThat(res)
                .withFailMessage("Should return '', '%s' was returned", res)
                .isEqualTo("");
    }

    @Test
    void SubtringSimpleCases() {
        String res = CleanExtract.extract(".The.|. quick brown. | what do you ..| .fox .|. Jumps over the lazy dog. .");

        assertThat(res)
                .withFailMessage("Should return 'The quick brown fox Jumps over the lazy dog.', '%s' was returned", res)
                .isEqualTo("The quick brown fox Jumps over the lazy dog.");
    }

    @Test
    void SubtringEdgeCases() {
        String res = CleanExtract.extract("  | Who am .I  | .love coding,  |.|  .Coding is fun | ...  ");

        assertThat(res)
                .withFailMessage("Should return 'I love coding, Coding is fun .', '%s' was returned", res)
                .isEqualTo("I love coding, Coding is fun .");
    }

    @Test
    void CleanSentence() {
        String res = CleanExtract.extract(".nothing to do I'm clean");

        assertThat(res)
                .withFailMessage("Should return 'nothing to do I'm clean', '%s' was returned", res)
                .isEqualTo("nothing to do I'm clean");
    }
}