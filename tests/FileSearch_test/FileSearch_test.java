import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.fail;

import java.io.*;
import java.nio.file.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(StopAfterFailureExtension.class)
class FileSearchTest {

    @Test
    void searchFile() throws IOException {

        FileSearchTest.createFiles();
        String res = FileSearch.searchFile("file.xml");

        assertThat(res)
                .withFailMessage("The computed path is %s, but should be documents/directory1/directory3/file.xml", res)
                .isEqualTo("documents/directory1/directory3/file.xml");
        deleteDirectory(new File("documents"));
    }

    @Test
    void searchFile_shouldReturnNull_whenFileDoesNotExists() throws IOException {
        try {
            FileSearchTest.createFiles();
            String res = FileSearch.searchFile("file.xml1");

            assertThat(res)
                    .withFailMessage("The computed path should be null when file does not exist")
                    .isNull();
            deleteDirectory(new File("documents"));
        } catch (Exception e) {
            fail("The search has thrown an error when the file does not exist");
        }
    }

    private static void createFiles() throws IOException {
        Files.createDirectory(Paths.get("documents"));
        Files.createDirectory(Paths.get("documents/directory42"));
        Files.createDirectory(Paths.get("documents/directory1"));
        Files.createFile(Paths.get("documents/directory1/text.xls"));
        Files.createFile(Paths.get("documents/directory1/data.docx"));
        Files.createDirectory(Paths.get("documents/directory1/directory2"));
        Files.createFile(Paths.get("documents/directory1/directory2/text.xml"));
        Files.createFile(Paths.get("documents/directory1/directory2/text.csv"));
        Files.createFile(Paths.get("documents/directory1/directory2/toto"));
        Files.createDirectory(Paths.get("documents/directory1/directory3"));
        Files.createDirectory(Paths.get("documents/directory1/directory3/directory87"));
        Files.createFile(Paths.get("documents/directory1/directory3/directory87/text.xml"));
        Files.createFile(Paths.get("documents/directory1/directory3/file.xml"));
        Files.createDirectory(Paths.get("documents/directory1/directory4"));
        Files.createFile(Paths.get("documents/directory1/directory4/file.txt"));
        Files.createDirectory(Paths.get("documents/directory43"));
        Files.createDirectory(Paths.get("documents/directory43/directory4"));
        Files.createFile(Paths.get("documents/directory43/directory4/file.txt"));
        Files.createFile(Paths.get("documents/directory43/data.xls"));
    }

    private static boolean deleteDirectory(File directoryToBeDeleted) {
        File[] allContents = directoryToBeDeleted.listFiles();
        if (allContents != null) {
            for (File file : allContents) {
                deleteDirectory(file);
            }
        }
        return directoryToBeDeleted.delete();
    }
}