
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Set;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(StopAfterFailureExtension.class)
class StreamMapTest {

    @Test
    void sumOfStringLength() {
        Integer res1 = StreamMap.sumOfStringLength(Stream.of("Hello world", "how are you", "213 ! ? 4839"));
        assertThat(res1)
                .withFailMessage("The result should be 34, but was %d", res1)
                .isEqualTo(34);
        Integer res2 = StreamMap.sumOfStringLength(Stream.of());
        assertThat(res2)
                .withFailMessage("The result should be 0, but was %d", res2)
                .isEqualTo(0);
    }

    @Test
    void upperCaseAllString() {
        List<String> res1 = StreamMap.upperCaseAllString(Stream.of("Hello WORLD", "how are you", "213 ! ? 4839"));
        assertThat(res1)
                .withFailMessage("The result should be [\"HELLO WORLD\", \"HOW ARE YOU\", \"213 ! ? 4839\"], but was %s", res1.toString())
                .containsExactly("HELLO WORLD", "HOW ARE YOU", "213 ! ? 4839");
        List<String> res2 = StreamMap.upperCaseAllString(Stream.of());
        assertThat(res2)
                .withFailMessage("The result should be empty")
                .isEmpty();
    }

    @Test
    void uniqIntValuesGreaterThan42() {
        Set<Integer> res1 = StreamMap.uniqIntValuesGreaterThan42(Stream.of(23.493, 42.01, 134.53, 294.4, 23.91, 294.98));
        assertThat(res1)
                .withFailMessage("The result should be [42, 134, 294], but was %s", res1.toString())
                .containsExactlyInAnyOrder(42, 134, 294);
        Set<Integer> res2 = StreamMap.uniqIntValuesGreaterThan42(Stream.of());
        assertThat(res2)
                .withFailMessage("The result should be empty")
                .isEmpty();
    }

}