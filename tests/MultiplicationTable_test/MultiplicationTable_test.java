import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(StopAfterFailureExtension.class)
class MultiplicationTableTest {

    @Test
    void testGenerateMultiplicationTableForTwo() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        MultiplicationTable.generate(2);

        String expectedOutput = "2 x 1 = 2\n" +
                                "2 x 2 = 4\n" +
                                "2 x 3 = 6\n" +
                                "2 x 4 = 8\n" +
                                "2 x 5 = 10\n" +
                                "2 x 6 = 12\n" +
                                "2 x 7 = 14\n" +
                                "2 x 8 = 16\n" +
                                "2 x 9 = 18\n" +
                                "2 x 10 = 20\n";

        assertEquals(expectedOutput, outputStream.toString());
        System.setOut(System.out); // Reset to standard output
    }

    @Test
    void testGenerateMultiplicationTableForFive() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        MultiplicationTable.generate(5);

        String expectedOutput = "5 x 1 = 5\n" +
                                "5 x 2 = 10\n" +
                                "5 x 3 = 15\n" +
                                "5 x 4 = 20\n" +
                                "5 x 5 = 25\n" +
                                "5 x 6 = 30\n" +
                                "5 x 7 = 35\n" +
                                "5 x 8 = 40\n" +
                                "5 x 9 = 45\n" +
                                "5 x 10 = 50\n";

        assertEquals(expectedOutput, outputStream.toString());
        System.setOut(System.out); // Reset to standard output
    }
}
