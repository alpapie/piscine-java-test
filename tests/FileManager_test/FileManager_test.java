import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.fail;

import java.io.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(StopAfterFailureExtension.class)
class FileManagerTest {

    @Test
    void createFile() {
        try {
            FileManager.createFile("fileTest.xml", """
                    Le fichier contient plusieurs lignes
                    Voilà la seconde !
                    """);

            File expectedFile = new File("fileTest.xml");

            assertThat(expectedFile.isFile())
                    .withFailMessage("File is a directory")
                    .isTrue();

            assertThat(expectedFile.exists())
                    .withFailMessage("File does not exist")
                    .isTrue();

            String expected = readFromInputStream(new FileInputStream(expectedFile));

            assertThat(expected)
                    .withFailMessage("The content of the file is not correct")
                    .isEqualTo("""
                    Le fichier contient plusieurs lignes
                    Voilà la seconde !
                    """);
        } catch (IOException e) {
            fail("The creation has thrown an error");
        } finally {

            File file = new File("fileTest.xml");
            file.delete();
        }
    }

    @Test
    public void getContentFile() {
        try {
            FileWriter fileWriter = new FileWriter("fileName.file");

            PrintWriter printWriter = new PrintWriter(fileWriter);

            printWriter.print("""
                    This file has many lines
                    Here is the second.
                    And there is the 3rd !""");

            printWriter.close();

            String res = FileManager.getContentFile("fileName.file");

            assertThat(res)
                    .withFailMessage("The value is not the one in the file")
                    .isEqualTo("""
                    This file has many lines
                    Here is the second.
                    And there is the 3rd !
                    """);
        } catch (IOException e) {
            fail("The creation has thrown an error");
        } finally {

            File file = new File("fileName.file");
            file.delete();
        }
    }

    @Test
    public void deleteFile() {
        try {
            FileWriter fileWriter = new FileWriter("fileName.file");

            PrintWriter printWriter = new PrintWriter(fileWriter);

            printWriter.print("""
                    This file has many lines
                    Here is the second.
                    And there is the 3rd !""");

            printWriter.close();

            FileManager.deleteFile("fileName.file");

            File expectedFile = new File("fileName.file");

            assertThat(expectedFile.exists())
                    .withFailMessage("The value is not deleted")
                    .isFalse();
        } catch (IOException e) {
            fail("The creation has thrown an error");
        } finally {

            File file = new File("fileName.file");
            file.delete();
        }
    }

    private static String readFromInputStream(InputStream inputStream)
            throws IOException {
        StringBuilder resultStringBuilder = new StringBuilder();
        try (BufferedReader br
                = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            while ((line = br.readLine()) != null) {
                resultStringBuilder.append(line).append("\n");
            }
        }
        return resultStringBuilder.toString();
    }
}