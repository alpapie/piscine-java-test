
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(StopAfterFailureExtension.class)
class ListSearchIndexTest {

    @Test
    void findLastIndex_shouldReturnTheIndex_whenValueIsContained() {
        List<Integer> list = List.of(28, 4893, 438, 54857, 4374, 4893, 48394);
        Integer res = ListSearchIndex.findLastIndex(
                list,
                4893);

        assertThat(res)
                .withFailMessage("The last index of %d in list %s is %d, but was %d", 4893, list.toString(), 5, res)
                .isEqualTo(5);
    }

    @Test
    void findLastIndex_shouldReturnNull_whenValueIsNotContained() {
        List<Integer> list = List.of(28, 438, 54857, 4374, 4893, 48394);
        Integer res = ListSearchIndex.findLastIndex(
                list,
                489);

        assertThat(res)
                .withFailMessage("The last index of %d in list %s is null, but was %d", 489, list.toString(), res)
                .isNull();
    }

    @Test
    void findLastIndex_shouldReturnNull_whenListIsNull() {
        Integer res = ListSearchIndex.findLastIndex(
                null,
                489);

        assertThat(res)
                .withFailMessage("The last index of %d in null list is null, but was %d", 489, res)
                .isNull();
    }

    @Test
    void findLastIndex_shouldReturnNull_whenListIsEmpty() {
        Integer res = ListSearchIndex.findLastIndex(
                List.of(),
                489);

        assertThat(res)
                .withFailMessage("The last index of %d in empty list is null, but was %d", 489, res)
                .isNull();
    }

    @Test
    void findFirstIndex_shouldReturnTheIndex_whenValueIsContained() {
        List<Integer> list = List.of(43784, 327, 1903, 3847, 327, 327, 3289);
        Integer res = ListSearchIndex.findFirstIndex(
                list,
                327);

        assertThat(res)
                .withFailMessage("The first index of %d in list %s is %d, but was %d", 327, list.toString(), 1, res)
                .isEqualTo(1);
    }

    @Test
    void findFirstIndex_shouldReturnNull_whenValueIsNotContained() {
        List<Integer> list = List.of(43784, 327, 1903, 3847, 327, 327, 3289);
        Integer res = ListSearchIndex.findFirstIndex(
                list,
                489);

        assertThat(res)
                .withFailMessage("The first index of %d in list %s is null, but was %d", 489, list.toString(), res)
                .isNull();
    }

    @Test
    void findFirstIndex_shouldReturnNull_whenListIsNull() {
        Integer res = ListSearchIndex.findFirstIndex(
                null,
                489);

        assertThat(res)
                .withFailMessage("The first index of %d in null list is null, but was %d", 489, res)
                .isNull();
    }

    @Test
    void findFirstIndex_shouldReturnNull_whenListIsEmpty() {
        Integer res = ListSearchIndex.findFirstIndex(
                List.of(),
                489);

        assertThat(res)
                .withFailMessage("The first index of %d in empty list is null, but was %d", 489, res)
                .isNull();
    }

    @Test
    void findAllIndexes_shouldReturnListOfIndexes_whenValueIsContained() {
        List<Integer> list = List.of(43784, 327, 1903, 3847, 327, 327, 3289);
        List<Integer> res = ListSearchIndex.findAllIndexes(
                list,
                327);

        assertThat(res)
                .withFailMessage("The indexes of %d in list %s are [1, 4, 5], but was %s", 327, list.toString(), res.toString())
                .containsExactlyInAnyOrder(1, 4, 5);
    }

    @Test
    void findAllIndexes_shouldReturnListOfUniqueIndex_whenValueIsContained() {
        List<Integer> list = List.of(43784, 327, 1903, 3847, 327, 327, 3289);
        List<Integer> res = ListSearchIndex.findAllIndexes(
                list,
                43784);

        assertThat(res)
                .withFailMessage("The indexes of %d in list %s are [0], but was %s", 43784, list.toString(), res.toString())
                .containsExactlyInAnyOrder(0);
    }

    @Test
    void findAllIndexes_shouldReturnNull_whenValueIsNotContained() {
        List<Integer> list = List.of(43784, 327, 1903, 3847, 327, 327, 3289);
        List<Integer> res = ListSearchIndex.findAllIndexes(
                list,
                489);

        assertThat(res)
                .withFailMessage("The indexes of %d in list %s is empty, but was %s", 489, list.toString(), res.toString())
                .isEmpty();
    }

    @Test
    void findAllIndexes_shouldReturnEmpty_whenListIsNull() {
        List<Integer> res = ListSearchIndex.findAllIndexes(
                null,
                489);

        assertThat(res)
                .withFailMessage("The indexes of %d in null list is empty, but was %s", 489, res.toString())
                .isEmpty();
    }

    @Test
    void findAllIndexes_shouldReturnEmpty_whenListIsEmpty() {
        List<Integer> res = ListSearchIndex.findAllIndexes(
                List.of(),
                489);

        assertThat(res)
                .withFailMessage("The indexes of %d in empty list is empty, but was %s", 489, res.toString())
                .isEmpty();
    }
}