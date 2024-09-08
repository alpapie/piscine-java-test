import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.Random;

import org.assertj.core.internal.bytebuddy.asm.Advice.Origin;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.Arrays;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(StopAfterFailureExtension.class)
class CatInFileTest {

    CatInFileTest() throws IOException {
        GenerateTextFile("empty.txt", 0);
        GenerateTextFile("smallFile.txt", 1 * 1024 * 1024);
        GenerateTextFile("bigFile.txt", 10 * 1024 * 1024);
        GenerateTextFileOneLine("oneLineFile.txt", 1 * 1024 * 1024);
        GenerateTextFileOneLine("oneBigLineFile.txt", 10 * 1024 * 1024);
        generateBinaryFile("binFile.txt", 1 * 1024 * 1024);
    }

    void CatMiddleware(String filename, String[] args) throws IOException {
        File outputFile = new File("output.txt");
        if (outputFile.exists()) {
            outputFile.delete();
        }
        System.setIn(new FileInputStream(filename));
        CatInFile.cat(args);
    }

    void GenerateTextFile(String filePath, int fileSizeInBytes) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(filePath));
        long bytesWritten = 0;

        while (bytesWritten < fileSizeInBytes) {
            String line = "This is a random line of text.\n";
            writer.write(line);
            bytesWritten += line.getBytes().length;
        }
        writer.close();
    }

    void GenerateTextFileOneLine(String filePath, int fileSizeInBytes) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(filePath));
        long bytesWritten = 0;

        while (bytesWritten < fileSizeInBytes) {
            String line = "This is a random line of text.";
            writer.write(line);
            bytesWritten += line.getBytes().length;
        }
        writer.close();
    }

    void generateBinaryFile(String filePath, int fileSizeInBytes) throws IOException {
        FileOutputStream fos = new FileOutputStream(filePath);
        Random random = new Random();

        byte[] buffer = new byte[1024]; // Adjust buffer size as needed
        while (fileSizeInBytes > 0) {
            random.nextBytes(buffer);
            int bytesToWrite = Math.min(fileSizeInBytes, buffer.length);
            fos.write(buffer, 0, bytesToWrite);
            fileSizeInBytes -= bytesToWrite;
        }
    }

    @Test
    void EmptyFile() throws IOException {
        CatMiddleware("empty.txt", new String[] { "output.txt" });
        File resFile = new File("empty.txt");
        File outputFile = new File("output.txt");
        assertThat(outputFile)
                .withFailMessage("Your output doesn't match the input file")
                .hasSameTextualContentAs(resFile);
    }

    @Test
    void HelloFile() throws IOException {
        CatMiddleware("smallFile.txt", new String[] { "output.txt" });
        File resFile = new File("smallFile.txt");
        File outputFile = new File("output.txt");
        assertThat(outputFile)
                .withFailMessage("Your output doesn't match the input file")
                .hasSameTextualContentAs(resFile);
    }

    @Test
    void BigFile() throws IOException {
        CatMiddleware("bigFile.txt", new String[] { "output.txt" });
        File resFile = new File("bigFile.txt");
        File outputFile = new File("output.txt");
        assertThat(outputFile)
                .withFailMessage("Your output doesn't match the input file")
                .hasSameTextualContentAs(resFile);
    }

    @Test
    void BinaryFile() throws IOException {
        CatMiddleware("binFile.txt", new String[] { "output.txt" });
        File resFile = new File("binFile.txt");
        File outputFile = new File("output.txt");
        assertThat(outputFile)
                .withFailMessage("Your output doesn't match the input file")
                .hasSameBinaryContentAs(resFile);
    }

    @Test
    void OneLineFile() throws IOException {
        CatMiddleware("oneLineFile.txt", new String[] { "output.txt" });
        File resFile = new File("oneLineFile.txt");
        File outputFile = new File("output.txt");
        assertThat(outputFile)
                .withFailMessage("Your output doesn't match the input file")
                .hasSameBinaryContentAs(resFile);
    }

    void OneBigLineFile() throws IOException {
        CatMiddleware("oneBigLineFile.txt", new String[] { "output.txt" });
        File resFile = new File("oneBigLineFile.txt");
        File outputFile = new File("output.txt");
        assertThat(outputFile)
                .withFailMessage("Your output doesn't match the input file")
                .hasSameBinaryContentAs(resFile);
    }
}