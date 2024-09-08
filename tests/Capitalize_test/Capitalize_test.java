import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.Random;
import org.junit.jupiter.api.Test;

import java.io.*;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(StopAfterFailureExtension.class)
class CapitalizeTest {

    @Test
    void SimpleTest() throws IOException {
        Capitalize.capitalize(new String[]{"/app/tests/Capitalize_test/simple_input","output"});
        File inputFile = new File("/app/tests/Capitalize_test/simple_output");
        File outputFile = new File("output");
        assertThat(outputFile)
                .withFailMessage("Your output is not correct")
                .hasSameTextualContentAs(inputFile);
    }


    @Test
    void AdditionalSpacesTest() throws IOException {
        Capitalize.capitalize(new String[]{"/app/tests/Capitalize_test/spaces_input","output"});
        File inputFile = new File("/app/tests/Capitalize_test/spaces_output");
        File outputFile = new File("output");
        assertThat(outputFile)
                .withFailMessage("Your output is not correct")
                .hasSameTextualContentAs(inputFile);
    }

    @Test
    void AllCasesTest() throws IOException {
        Capitalize.capitalize(new String[]{"/app/tests/Capitalize_test/all_casess_input","output"});
        File inputFile = new File("/app/tests/Capitalize_test/all_casess_output");
        File outputFile = new File("output");
        assertThat(outputFile)
                .withFailMessage("Your output is not correct")
                .hasSameTextualContentAs(inputFile);
    }
}