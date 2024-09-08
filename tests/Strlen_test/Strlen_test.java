import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(StopAfterFailureExtension.class)
class StrlenTest {

    @Test
    void lengthOfRegularString() {
        String str = "Hello World !";
        int result = Strlen.strlen(str);
        assertThat(result).isEqualTo(13);
    }

    @Test
    void lengthOfEmptyString() {
        String str = "";
        int result = Strlen.strlen(str);
        assertThat(result).isEqualTo(0);
    }

    @Test
    void lengthOfStringWithSpaces() {
        String str = "   ";
        int result = Strlen.strlen(str);
        assertThat(result).isEqualTo(3);
    }

    @Test
    void lengthOfStringWithSpecialCharacters() {
        String str = "@!#%^&*()";
        int result = Strlen.strlen(str);
        assertThat(result).isEqualTo(9);
    }
}
