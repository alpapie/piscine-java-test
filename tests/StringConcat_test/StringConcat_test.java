import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(StopAfterFailureExtension.class)
class StringConcatTest {

    @Test
    void concat_withBothStringsFilled() {
        String res = StringConcat.concat("Ynov ", "Bordeaux");

        assertThat(res)
                .withFailMessage(
                        "Should return \"Ynov Bordeaux\" for concatenation of \"Ynov \" and \"Bordeaux\" strings, %s was returned",
                        res)
                .isEqualTo("Ynov Bordeaux");
    }

    @Test
    void concat_withFirstEmpty() {
        String res = StringConcat.concat("", "il fait beau");

        assertThat(res)
                .withFailMessage(
                        "Should return \"il fait beau\" for concatenation of \"\" and \"il fait beau\" strings, %s was returned",
                        res)
                .isEqualTo("il fait beau");
    }

    @Test
    void concat_withFirstNull() {
        String res = StringConcat.concat(null, "il pleut");

        assertThat(res)
                .withFailMessage(
                        "Should return \"il pleut\" for concatenation of null and \"il pleut\" strings, %s was returned",
                        res)
                .isEqualTo("il pleut");
    }

    @Test
    void concat_withSecondEmpty() {
        String res = StringConcat.concat("Bonjour les gens", "");

        assertThat(res)
                .withFailMessage(
                        "Should return \"Bonjour les gens\" for concatenation of \"Bonjour les gens\" and \"\" strings, %s was returned",
                        res)
                .isEqualTo("Bonjour les gens");
    }

    @Test
    void concat_withSecondNull() {
        String res = StringConcat.concat("Hello World", null);

        assertThat(res)
                .withFailMessage(
                        "Should return \"Hello World\" for concatenation of \"Hello World\" and null strings, %s was returned",
                        res)
                .isEqualTo("Hello World");
    }

    @Test
    void concat_withBothNull() {
        String res = StringConcat.concat(null, null);

        assertThat(res)
                .withFailMessage("Should return null for concatenation of null strings, %s was returned", res)
                .isNull();
    }

}