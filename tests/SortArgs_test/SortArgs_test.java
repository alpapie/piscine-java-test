import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import java.io.*;
import java.util.Random;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(StopAfterFailureExtension.class)
class SortArgsTest {
    ByteArrayOutputStream outputStream;
    PrintStream printStream;
    InputStream origine;

    SortArgsTest() {
        outputStream = new ByteArrayOutputStream();
        printStream = new PrintStream(outputStream);
        origine = System.in;
        
    }

    String SortArgsMiddlware(String[] args){
        System.setOut(printStream);
        SortArgs.sort(args);
        printStream.flush();
        String output = outputStream.toString();
        outputStream.reset();
        System.setIn(origine);
        return output;
    }

    @Test
    void EmptyArray() {
        String res = SortArgsMiddlware(new String[] {});

        assertThat(res)
                .withFailMessage("the Sorted array should be <new line> but '%s' is printed", res)
                .isEqualTo("\n");
    }

    @Test
    void SimpleArray() {
        String res = SortArgsMiddlware(new String[] { "4", "2", "1", "3" });

        assertThat(res)
                .withFailMessage("the Sorted array should be 1 2 3 4\n but '%s' is printed", res)
                .isEqualTo("1 2 3 4\n");
    }

    @Test
    void ArrayWithDuplication() {
        String res = SortArgsMiddlware(new String[] { "4", "2", "1", "3", "2" });

        assertThat(res)
                .withFailMessage("the Sorted array should be 1 2 2 3 4\n but '%s' is printed", res)
                .isEqualTo("1 2 2 3 4\n");
    }

}