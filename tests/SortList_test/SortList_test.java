
import static org.assertj.core.api.Assertions.assertThat;

import java.util.Comparator;
import java.util.List;
import java.util.Random;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(StopAfterFailureExtension.class)
class SortListTest {

    @Test
    void sort() {
        List<Integer> list = List.of(87, -13, 0, -45, 32, 76, 87, 4, -13);
        List<Integer> expected = List.of(-45, -13, -13, 0, 4, 32, 76, 87, 87);
        List<Integer> res = SortList.sort(list);

        assertThat(res)
                .withFailMessage("List %s should be ordered as %s, but was %s", list.toString(), expected.toString(), res.toString())
                .containsExactlyElementsOf(expected);
    }

    @Test
    void sort_shouldReturnEmpty_whenEmpty() {
        List<Integer> res = SortList.sort(List.of());

        assertThat(res)
                .withFailMessage("Empty list should be ordered as empty, but was not")
                .isEmpty();
    }

    @Test
    void sort_shouldReturnNull_whenNull() {
        List<Integer> res = SortList.sort(null);

        assertThat(res)
                .withFailMessage("Empty list should be ordered as empty, but was not")
                .isNull();
    }

    @Test
    void sort_random() {
        List<Integer> list = new Random().ints(100, -500, 500)
                .boxed().toList();

        List<Integer> expected = list.stream().sorted().toList();

        List<Integer> res = SortList.sort(list);

        assertThat(res)
                .withFailMessage("List %s should be ordered as %s, but was %s", list.toString(), expected.toString(), res.toString())
                .containsExactlyElementsOf(expected);
    }

    @Test
    void sortReverse() {
        List<Integer> list = List.of(87, -13, 0, -45, 32, 76, 87, 4, -13);
        List<Integer> expected = List.of(87, 87, 76, 32, 4, 0, -13, -13, -45);
        List<Integer> res = SortList.sortReverse(list);

        assertThat(res)
                .withFailMessage("List %s should be ordered as %s, but was %s", list.toString(), expected.toString(), res.toString())
                .containsExactlyElementsOf(expected);
    }

    @Test
    void sortReverse_shouldReturnEmpty_whenEmpty() {
        List<Integer> res = SortList.sortReverse(List.of());

        assertThat(res)
                .withFailMessage("Empty list should be ordered as empty, but was not")
                .isEmpty();
    }

    @Test
    void sortReverse_shouldReturnNull_whenNull() {
        List<Integer> res = SortList.sortReverse(null);

        assertThat(res)
                .withFailMessage("Empty list should be ordered as empty, but was not")
                .isNull();
    }

    @Test
    void sortReverse_random() {
        List<Integer> list = new Random().ints(100, -500, 500)
                .boxed().toList();

        List<Integer> expected = list.stream().sorted(Comparator.reverseOrder()).toList();

        List<Integer> res = SortList.sortReverse(list);

        assertThat(res)
                .withFailMessage("List %s should be ordered as %s, but was %s", list.toString(), expected.toString(), res.toString())
                .containsExactlyElementsOf(expected);
    }

}