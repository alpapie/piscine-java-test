import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(StopAfterFailureExtension.class)
class StringLengthTest {

    @Test
    void getStringLength_shouldReturn4_whenYnov() {
        int res = StringLength.getStringLength("Ynov");

        assertThat(res)
                .withFailMessage("Should return 4 for \"Ynov\" string, %d was returned", res)
                .isEqualTo(4);
    }

    @Test
    void getStringLength_shouldReturn16_whenViveLeJavaWithTrailingSpaces() {
        int res = StringLength.getStringLength("  Vive le Java  ");

        assertThat(res)
                .withFailMessage("Should return 16 for \"  Vive le Java  \" string, %d was returned", res)
                .isEqualTo(16);
    }

    @Test
    void getStringLength_shouldReturn0_whenNull() {
        int res = StringLength.getStringLength(null);

        assertThat(res)
                .withFailMessage("Should return 0 for null value, %d was returned", res)
                .isEqualTo(0);
    }

    @Test
    void getStringLength_shouldReturn0_whenEmpty() {
        int res = StringLength.getStringLength("");

        assertThat(res)
                .withFailMessage("Should return 0 for \"\" string, %d was returned", res)
                .isEqualTo(0);
    }
}