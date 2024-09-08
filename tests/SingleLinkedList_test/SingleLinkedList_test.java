import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(StopAfterFailureExtension.class)
class SingleLinkedListTest {
    private LinkedList list;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    void setUp() {
        list = new SingleLinkedList();
        System.setOut(new PrintStream(outContent));
    }

    @Test
    void testAddAndAt() {
        list.add(1);
        list.add(2);
        list.add(3);

        assertThat(list.at(0))
                .withFailMessage("Expected 1 at index 0 but got %d", list.at(0))
                .isEqualTo(1);
        assertThat(list.at(1))
                .withFailMessage("Expected 2 at index 1 but got %d", list.at(1))
                .isEqualTo(2);
        assertThat(list.at(2))
                .withFailMessage("Expected 3 at index 2 but got %d", list.at(2))
                .isEqualTo(3);

        // Verify "Go to next node" is printed
        String expectedOutput = "Go to next node\nGo to next node\n";
        outContent.reset(); // Clear the output content
        list.at(2);
        assertThat(outContent.toString())
                .withFailMessage("Expected 'Go to next node' messages but got %s", outContent.toString())
                .isEqualTo(expectedOutput);
    }

    @Test
    void testRemove() {
        list.add(1);
        list.add(2);
        list.add(3);

        outContent.reset(); // Clear the output content

        list.remove(1);

        assertThat(list.at(0))
                .withFailMessage("Expected 1 at index 0 but got %d", list.at(0))
                .isEqualTo(1);
        assertThat(list.at(1))
                .withFailMessage("Expected 3 at index 1 but got %d", list.at(1))
                .isEqualTo(3);

        // Verify "Go to next node" is printed during removal
        String expectedOutput = "Go to next node\nGo to next node\nGo to next node\n";
        assertThat(outContent.toString())
                .withFailMessage("Expected '%s' message but got %s", expectedOutput, outContent.toString())
                .isEqualTo(expectedOutput);

        // Verify "Go to next node" is printed during access after removal
        expectedOutput = "Go to next node\n";
        outContent.reset();
        list.at(1);
        assertThat(outContent.toString())
                .withFailMessage("Expected '%s' message but got %s", expectedOutput, outContent.toString())
                .isEqualTo(expectedOutput);
    }

    @Test
    void testSize() {
        list.add(1);
        list.add(2);
        list.add(3);

        assertThat(list.size())
                .withFailMessage("Expected size 3 but got %d", list.size())
                .isEqualTo(3);

        list.remove(1);

        assertThat(list.size())
                .withFailMessage("Expected size 2 but got %d", list.size())
                .isEqualTo(2);

        list.add(4);

        assertThat(list.size())
                .withFailMessage("Expected size 3 but got %d", list.size())
                .isEqualTo(3);
    }

    @Test
    void testNextMethodIsCalledDuringAdd() {
        list.add(1);
        list.add(2);
        list.add(3);

        // Verify "Go to next node" is printed during addition
        String expectedOutput = "Go to next node\nGo to next node\n";
        outContent.reset();
        list.add(4);
        assertThat(outContent.toString())
                .withFailMessage("Expected 'Go to next node' messages but got %s", outContent.toString())
                .isEqualTo(expectedOutput);
    }

    @Test
    void testNextMethodIsCalledDuringAt() {
        list.add(1);
        list.add(2);
        list.add(3);

        // Verify "Go to next node" is printed during access
        String expectedOutput = "Go to next node\nGo to next node\n";
        outContent.reset();
        list.at(2);
        assertThat(outContent.toString())
                .withFailMessage("Expected 'Go to next node' messages but got %s", outContent.toString())
                .isEqualTo(expectedOutput);
    }

    @Test
    void testNextMethodIsCalledDuringRemove() {
        list.add(1);
        list.add(2);
        list.add(3);

        // Verify "Go to next node" is printed during removal
        String expectedOutput = "Go to next node\n";
        outContent.reset();
        list.remove(1);
        assertThat(outContent.toString())
                .withFailMessage("Expected 'Go to next node' messages but got %s", outContent.toString())
                .isEqualTo(expectedOutput);
    }

    @Test
    void testRemoveHead() {
        list.add(1);
        list.add(2);
        list.add(3);

        outContent.reset(); // Clear the output content

        list.remove(0);

        assertThat(list.at(0))
                .withFailMessage("Expected 2 at index 0 after removing head but got %d", list.at(0))
                .isEqualTo(2);
        assertThat(list.size())
                .withFailMessage("Expected size 2 after removing head but got %d", list.size())
                .isEqualTo(2);

        // Verify "Go to next node" is not printed during removal of head
        String expectedOutput = "";
        assertThat(outContent.toString())
                .withFailMessage("Expected no output during head removal but got %s", outContent.toString())
                .isEqualTo(expectedOutput);
    }

    @Test
    void testRemoveTail() {
        list.add(1);
        list.add(2);
        list.add(3);

        outContent.reset(); // Clear the output content

        list.remove(2);

        // Verify "Go to next node" is printed during removal of tail
        String expectedOutput = "Go to next node\nGo to next node\n";
        assertThat(outContent.toString())
                .withFailMessage("Expected '%s' messages during tail removal but got %s", expectedOutput, outContent.toString())
                .isEqualTo(expectedOutput);

        assertThat(list.at(0))
                .withFailMessage("Expected 1 at index 0 after removing tail but got %d", list.at(0))
                .isEqualTo(1);
        assertThat(list.at(1))
                .withFailMessage("Expected 2 at index 1 after removing tail but got %d", list.at(1))
                .isEqualTo(2);
        assertThat(list.size())
                .withFailMessage("Expected size 2 after removing tail but got %d", list.size())
                .isEqualTo(2);
    }
}
