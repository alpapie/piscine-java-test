import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(StopAfterFailureExtension.class)
class ListContainsTest {

    @Test
    void containsValue_shouldReturnTrue_whenValueIsContained() {
        List<Integer> list = List.of(28, 438, 54857, 4374, 4893, 48394);
        boolean res = ListContains.containsValue(
                list,
                4893);

        assertThat(res)
                .withFailMessage("Should return true with value %d in list %s", 4893, list.toString())
                .isTrue();
    }

    @Test
    void containsValue_shouldReturnFalse_whenValueIsNotContained() {
        List<Integer> list = List.of(28, 438, 54857, 4374, 4893, 48394);
        boolean res = ListContains.containsValue(
                list,
                489);

        assertThat(res)
                .withFailMessage("Should return false with value %d in list %s", 489, list.toString())
                .isFalse();
    }

    @Test
    void isStringContainedIn_shouldReturnFalse_withListIsEmpty() {
        boolean res = ListContains.containsValue(List.of(), 12);

        assertThat(res)
                .withFailMessage("Should return false with empty list")
                .isFalse();
    }
}