import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(StopAfterFailureExtension.class)
class SetEqualsTest {

    @Test
    void areSetsEqual_shouldReturnTrue_whenSetsAreEqual() {
        Set<String> set1 = new TreeSet<>();
        set1.add("Alice");
        set1.add("Bob");
        set1.add("Charly");

        Set<String> set2 = new TreeSet<>();
        set2.add("Bob");
        set2.add("Charly");
        set2.add("Alice");

        boolean res = SetEquals.areSetsEqual(set1, set2);
        assertThat(res)
            .withFailMessage("Should return true when sets are equal, but got false")
            .isTrue();
    }

    @Test
    void areSetsEqual_shouldReturnFalse_whenSetsAreNotEqual() {
        Set<String> set1 = new HashSet<>();
        set1.add("Alice");
        set1.add("Bob");
        set1.add("Charly");

        Set<String> set2 = new HashSet<>();
        set2.add("Alice");
        set2.add("Bob");
        set2.add("Emily");

        boolean res = SetEquals.areSetsEqual(set1, set2);
        assertThat(res)
            .withFailMessage("Should return false when sets are not equal, but got true")
            .isFalse();
    }
}
