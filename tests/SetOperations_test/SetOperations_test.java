import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(StopAfterFailureExtension.class)
class SetOperationsTest {

    @Test
    void union_shouldReturnCorrectUnionSet() {
        Set<Integer> set1 = new HashSet<>();
        set1.add(1);
        set1.add(2);
        set1.add(3);

        Set<Integer> set2 = new HashSet<>();
        set2.add(2);
        set2.add(3);
        set2.add(4);

        Set<Integer> unionSet = SetOperations.union(set1, set2);
        Set<Integer> expectedSet = Set.of(1, 2, 3, 4);
        assertThat(unionSet)
                .withFailMessage("Should return correct union set %s, but got %s", expectedSet, unionSet)
                .isEqualTo(expectedSet);
    }

    @Test
    void intersection_shouldReturnCorrectIntersectionSet() {
        Set<Integer> set1 = new HashSet<>();
        set1.add(1);
        set1.add(2);
        set1.add(3);

        Set<Integer> set2 = new HashSet<>();
        set2.add(2);
        set2.add(3);
        set2.add(4);

        Set<Integer> intersectionSet = SetOperations.intersection(set1, set2);
        Set<Integer> expectedSet = Set.of(2, 3);
        assertThat(intersectionSet)
                .withFailMessage("Should return correct intersection set %s, but got %s", expectedSet, intersectionSet)
                .isEqualTo(expectedSet);
    }
}
