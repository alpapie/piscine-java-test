import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.fail;

import java.io.File;
import java.io.IOException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(StopAfterFailureExtension.class)
class RegexMatchTest {

    @Test
    void containsOnlyAlpha() {
        assertThat(RegexMatch.containsOnlyAlpha("azejksj"))
                .withFailMessage("The \"azejksj\" should match, but doesn't match")
                .isTrue();
        assertThat(RegexMatch.containsOnlyAlpha("AEFdkjdf"))
                .withFailMessage("The \"AEFdkjdf\" should match, but doesn't match")
                .isTrue();
        assertThat(RegexMatch.containsOnlyAlpha("sjdkl sjkSDjk"))
                .withFailMessage("The \"sjdkl sjkSDjk\" should not match, but match")
                .isFalse();
        assertThat(RegexMatch.containsOnlyAlpha("sj343IFDkj"))
                .withFailMessage("The \"sj343IFDkj\" should not match, but match")
                .isFalse();
    }

    @Test
    void startWithLetterAndEndWithNumber() {
        assertThat(RegexMatch.startWithLetterAndEndWithNumber("eajEZ34"))
                .withFailMessage("The \"eajEZ34\" should match, but didn't match")
                .isTrue();
        assertThat(RegexMatch.startWithLetterAndEndWithNumber("z3"))
                .withFailMessage("The \"z3\" should match, but doesn't match")
                .isTrue();
        assertThat(RegexMatch.startWithLetterAndEndWithNumber("43JKFD3"))
                .withFailMessage("The \"43JKFD3\" should not match, but match")
                .isFalse();
        assertThat(RegexMatch.startWithLetterAndEndWithNumber("a d;sksd jsd43 3"))
                .withFailMessage("The \"a d;sksd jsd43 3\" should match, but doesn't match")
                .isTrue();
    }

    @Test
    void containsAtLeast3SuccessiveA() {
        assertThat(RegexMatch.containsAtLeast3SuccessiveA("  .djskAAAAAAAAAsdjkjA"))
                .withFailMessage("The \"  .djskAAAAAAAAAsdjkjA\" should match, but didn't match")
                .isTrue();
        assertThat(RegexMatch.containsAtLeast3SuccessiveA("jkjsAAAjdskj"))
                .withFailMessage("The \"jkjsAAAjdskj\" should match, but doesn't match")
                .isTrue();
        assertThat(RegexMatch.containsAtLeast3SuccessiveA("AAA"))
                .withFailMessage("The \"AAA\" should match, but doesn't match")
                .isTrue();
        assertThat(RegexMatch.containsAtLeast3SuccessiveA("aaa"))
                .withFailMessage("The \"aaa\" should not match, but match")
                .isFalse();
        assertThat(RegexMatch.containsAtLeast3SuccessiveA("AA"))
                .withFailMessage("The \"AA\" should not match, but match")
                .isFalse();
    }
}