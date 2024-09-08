import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.fail;

import java.util.Optional;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(StopAfterFailureExtension.class)
class StreamReduceTest {

    @Test
    void sumAll() {
        Integer res1 = StreamReduce.sumAll(Stream.of(32, 48, 3, 434, 594));
        assertThat(res1)
                .withFailMessage("The result should be 1111, but was %d", res1)
                .isEqualTo(1111);
        Integer res2 = StreamReduce.sumAll(Stream.of());
        assertThat(res2)
                .withFailMessage("The result should be 0, but was %d", res2)
                .isEqualTo(0);
    }

    @Test
    void divideAndAddElements() {
        Integer res1 = StreamReduce.divideAndAddElements(Stream.of(32, 48, 18, 434, 594), 4);
        assertThat(res1)
                .withFailMessage("The result should be 280, but was %d", res1)
                .isEqualTo(280);
        Integer res2 = StreamReduce.divideAndAddElements(Stream.of(), 2);
        assertThat(res2)
                .withFailMessage("The result should be 0, but was %d", res2)
                .isEqualTo(0);
    }

}