import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(StopAfterFailureExtension.class)
class ListEqualsTest {

    @Test
    void areListsEqual_shouldReturnTrue_whenListsAreEqual() {
        List<String> list1 = List.of("Bonjour", "Hello", "Gracias");
        List<String> list2 = List.of("Bonjour", "Hello", "Gracias");
        boolean res = ListEquals.areListsEqual(
                list1,
                list2);

        assertThat(res)
                .withFailMessage("Lists %s and %s are equals, but was not", list1.toString(), list2.toString())
                .isTrue();
    }

    @Test
    void areListsEqual_shouldReturnFalse_whenListsAreNotEqual() {
        List<String> list1 = List.of("Bonjour", "Gracias", "Hello");
        List<String> list2 = List.of("Bonjour", "Hello", "Gracias");
        boolean res = ListEquals.areListsEqual(
                list1,
                list2);

        assertThat(res)
                .withFailMessage("Lists %s and %s are not equals, but was not", list1.toString(), list2.toString())
                .isFalse();
    }

    @Test
    void areListsEqual_shouldReturnFalse_whenListsAreOfDifferentSize() {
        List<String> list1 = List.of("Bonjour", "Gracias", "Hello");
        List<String> list2 = List.of("Bonjour", "Hello");
        boolean res = ListEquals.areListsEqual(
                list1,
                list2);

        assertThat(res)
                .withFailMessage("Lists %s and %s are not equals, but was not", list1.toString(), list2.toString())
                .isFalse();
    }

    @Test
    void areListsEqual_shouldReturnTrue_whenListsAreEmpty() {
        boolean res = ListEquals.areListsEqual(
                List.of(),
                List.of());

        assertThat(res)
                .withFailMessage("Lists empty are equals, but was not")
                .isTrue();
    }

    @Test
    void areListsEqual_shouldReturnTrue_whenListsAreNull() {
        boolean res = ListEquals.areListsEqual(
                null,
                null);

        assertThat(res)
                .withFailMessage("Lists empty are null, but was not")
                .isTrue();
    }

    @Test
    void areListsEqual_shouldReturnFalse_whenFirstListIsNull() {
        boolean res = ListEquals.areListsEqual(
                null,
                List.of("Bonjour"));

        assertThat(res)
                .withFailMessage("List null and [Bonjour] are not equals, but was not")
                .isFalse();
    }

    @Test
    void areListsEqual_shouldReturnFalse_whenSecondListIsNull() {
        boolean res = ListEquals.areListsEqual(
                List.of("Bonjour"),
                null);

        assertThat(res)
                .withFailMessage("List null and [Bonjour] are not equals, but was not")
                .isFalse();
    }

}