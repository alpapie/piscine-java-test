import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import java.util.Map;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(StopAfterFailureExtension.class)
class MapEqualsTest {

    @Test
    void areMapsEqual_shouldReturnTrue_whenMapsAreEqual() {
        Map<String, Integer> map1 = Map.of("Alice", 1, "Bob", 2, "Charly", 3);
        Map<String, Integer> map2 = Map.of("Alice", 1, "Bob", 2, "Charly", 3);
        boolean res = MapEquals.areMapsEqual(map1, map2);

        assertThat(res)
                .withFailMessage("Should return true when maps are equal, but got %s", res)
                .isTrue();
    }

    @Test
    void areMapsEqual_shouldReturnFalse_whenMapsAreNotEqual() {
        Map<String, Integer> map3 = Map.of("Alice", 1, "Bob", 2, "Charly", 3);
        Map<String, Integer> map4 = Map.of("Alice", 1, "Bob", 2, "Emily", 3);
        boolean res = MapEquals.areMapsEqual(map3, map4);

        assertThat(res)
                .withFailMessage("Should return false when maps are not equal, but got %s", res)
                .isFalse();
    }
}
