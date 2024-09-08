import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(StopAfterFailureExtension.class)
class DoubleLinkedListTest {
    private LinkedList list;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    void setUp() {
        list = new DoubleLinkedList();
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
        assertThat(list.at(-1))
                .withFailMessage("Expected -1 at index -1 but got %d", list.at(-1))
                .isEqualTo(-1);
        assertThat(list.at(10))
                .withFailMessage("Expected -1 at index 10 but got %d", list.at(10))
                .isEqualTo(-1);
        // Verify "Go to next node" is printed
        String expectedOutput = "Go to next node\nGo to next node\n";
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
        String expectedOutput = "Go to next node\n";
        assertThat(outContent.toString())
                .withFailMessage("Expected 'Go to next node' message but got %s", outContent.toString())
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
    void testNextAndPrevMethodIsNotCalledDuringAdd() {
        list.add(1);
        list.add(2);
        list.add(3);


        String expectedOutput = "";
        assertThat(outContent.toString())
                .withFailMessage("Expected '' messages but got %s", outContent.toString())
                .isEqualTo(expectedOutput);
    }

    @Test
    void testNextMethodIsCalledDuringAt() {
        list.add(1);
        list.add(2);
        list.add(3);

        // Verify "Go to next node" is printed during access
        outContent.reset();
        String expectedOutput = "Go to next node\n";
        list.at(1);
        assertThat(outContent.toString())
                .withFailMessage("Expected 'Go to next node' messages but got %s", outContent.toString())
                .isEqualTo(expectedOutput);
 
        list.add(4);
        outContent.reset();
        list.at(1);
        assertThat(outContent.toString())
                .withFailMessage("Expected 'Go to next node' messages but got %s", outContent.toString())
                .isEqualTo(expectedOutput);
}

    @Test
    void testNextMethodIsCalledDuringRemove() {
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        // Verify "Go to next node" is printed during removal
        outContent.reset();
        String expectedOutput = "Go to next node\n";
        list.remove(1);
        assertThat(outContent.toString())
                .withFailMessage("Expected 'Go to next node' messages but got %s", outContent.toString())
                .isEqualTo(expectedOutput);

        outContent.reset();
        expectedOutput = "Go to next node\n";
        list.remove(1);
        assertThat(outContent.toString())
                .withFailMessage("Expected 'Go to next node' messages but got %s", outContent.toString())
                .isEqualTo(expectedOutput);
    }

    @Test
    void testPrevMethodIsCalledDuringAt() {
        list.add(1);
        list.add(2);
        list.add(3);

        // Access element at index 4 (should traverse backwards)
        String expectedOutput = "";
        outContent.reset();
        list.at(2); 
        assertThat(outContent.toString())
                .withFailMessage("Expected '' messages but got %s", outContent.toString())
                .isEqualTo(expectedOutput);

        list.add(4);

        expectedOutput = "Go to previous node\n";
        outContent.reset();
        list.at(2); 
        assertThat(outContent.toString())
                .withFailMessage("Expected 'Go to previous node' messages but got %s", outContent.toString())
                .isEqualTo(expectedOutput);
    }

    @Test
    void testPrevMethodIsCalledDuringRemove() {
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        // Verify "Go to previous node" is printed during removal
        String expectedOutput = "Go to previous node\n";
        outContent.reset();
        list.remove(2); // Remove tail, should call prev
        assertThat(outContent.toString())
                .withFailMessage("Expected 'Go to previous node' messages but got %s", outContent.toString())
                .isEqualTo(expectedOutput);

        expectedOutput = "";
        outContent.reset();
        list.remove(2); // Remove tail, should call prev
        assertThat(outContent.toString())
                .withFailMessage("Expected '' messages but got %s", outContent.toString())
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
                .withFailMessage("Expected '' message during head removal but got %s", outContent.toString())
                .isEqualTo(expectedOutput);
    }

    @Test
    void testRemoveTail() {
        list.add(1);
        list.add(2);
        list.add(3);

        outContent.reset(); // Clear the output content

        list.remove(2);

        assertThat(list.at(0))
                .withFailMessage("Expected 1 at index 0 after removing tail but got %d", list.at(0))
                .isEqualTo(1);
        assertThat(list.at(1))
                .withFailMessage("Expected 2 at index 1 after removing tail but got %d", list.at(1))
                .isEqualTo(2);
        assertThat(list.size())
                .withFailMessage("Expected size 2 after removing tail but got %d", list.size())
                .isEqualTo(2);

        // Verify "Go to next node" is printed during removal of tail
        String expectedOutput = "";
        assertThat(outContent.toString())
                .withFailMessage("Expected '' messages during tail removal but got %s", outContent.toString())
                .isEqualTo(expectedOutput);
    }

    @Test
    void testRemoveOutOfBound() {
        list.add(1);
        list.add(2);
        list.add(3);

        outContent.reset(); // Clear the output content

        list.remove(2);
        assertThat(list.size())
        .withFailMessage("Expected size 2 after removing item at index 2 but got %d", list.size())
        .isEqualTo(2);

        list.remove(20);
        
        assertThat(list.size())
        .withFailMessage("Expected size 2 after removing item out of bound at index 20 but got %d\"", list.size())
        .isEqualTo(2);

        list.remove(-1);

        assertThat(list.at(1))
        .withFailMessage("Expected size 2 after removing item out of bound at index -1 but got %d\"", list.size())
                .isEqualTo(2);
    }
}
