import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(StopAfterFailureExtension.class)
class StreamCollectTest {

    @Test
    void mapByFirstLetter() {
        Map<Character, List<String>> res1 = StreamCollect.mapByFirstLetter(Stream.of("Hello world", "how are you", "12.4389", "aristochat", "abricot"));
        assertThat(res1)
                .withFailMessage("The result should be {A=[\"aristochat\", \"abricot\"], H=[\"Hello world\", \"how are you\"], 1=[\"12.4389\"]}, but was %s", res1)
                .containsExactlyInAnyOrderEntriesOf(Map.of(
                        '1', List.of("12.4389"),
                        'A', List.of("aristochat", "abricot"),
                        'H', List.of("Hello world", "how are you")));
        Map<Character, List<String>> res2 = StreamCollect.mapByFirstLetter(Stream.of());
        assertThat(res2)
                .withFailMessage("The result should be empty")
                .isEmpty();
    }

    @Test
    void getMaxByModulo4() {
        Map<Integer, Optional<Integer>> res1 = StreamCollect.getMaxByModulo4(Stream.of(12, 18, 17, 15, 11, 9, 0, 43));
        assertThat(res1)
                .withFailMessage("The result should be {0=12, 1=17, 2=18, 3=43}, but was %s", res1)
                .containsExactlyInAnyOrderEntriesOf(Map.of(
                        0, Optional.of(12),
                        1, Optional.of(17),
                        2, Optional.of(18),
                        3, Optional.of(43)));
        Map<Integer, Optional<Integer>> res2 = StreamCollect.getMaxByModulo4(Stream.of());
        assertThat(res2)
                .withFailMessage("The result should be empty")
                .isEmpty();
    }

    @Test
    void orderAndConcatWithSharp() {
        String res1 = StreamCollect.orderAndConcatWithSharp(Stream.of("Vive", "le java", "ET", "lA", "POO !"));
        assertThat(res1)
                .withFailMessage("The result should be \"{ET # POO ! # Vive # lA # le java}\", but was %s", res1)
                .isEqualTo("{ET # POO ! # Vive # lA # le java}");
        String res2 = StreamCollect.orderAndConcatWithSharp(Stream.of());
        assertThat(res2)
                .withFailMessage("The result should be \"{}\", but was %s", res2)
                .isEqualTo("{}");
    }

}