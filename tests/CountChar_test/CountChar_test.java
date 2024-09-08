import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(StopAfterFailureExtension.class)
class CountCharTest {

    @Test
    void countCharacterAppearingMultipleTimes() {
        String str = "Hello World!";
        char charToCount = 'l';
        int result = CountChar.count(str, charToCount);
        assertThat(result).isEqualTo(3);
    }

    @Test
    void countCharacterAppearingOnce() {
        String str = "Hello World!";
        char charToCount = 'H';
        int result = CountChar.count(str, charToCount);
        assertThat(result).isEqualTo(1);
    }

    @Test
    void countCharacterNotAppearing() {
        String str = "Hello World!";
        char charToCount = 'x';
        int result = CountChar.count(str, charToCount);
        assertThat(result).isEqualTo(0);
    }

    @Test
    void countSpaceCharacter() {
        String str = "Hello World!";
        char charToCount = ' ';
        int result = CountChar.count(str, charToCount);
        assertThat(result).isEqualTo(1);
    }

    @Test
    void countSpecialCharacter() {
        String str = "Hello World! @$@!";
        char charToCount = '@';
        int result = CountChar.count(str, charToCount);
        assertThat(result).isEqualTo(2);
    }
}
