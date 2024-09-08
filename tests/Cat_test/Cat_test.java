import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.Random;

import org.assertj.core.internal.bytebuddy.asm.Advice.Origin;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.Arrays;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(StopAfterFailureExtension.class)
class CatTest {
    PrintStream origin;

    CatTest() throws IOException {
        GenerateTextFile("empty.txt", 0);
        GenerateTextFile("smallFile.txt", 1 * 1024 * 1024);
        GenerateTextFile("bigFile.txt", 10 * 1024 * 1024);
        GenerateTextFileOneLine("oneLineFile.txt", 1 * 1024 * 1024);
        GenerateTextFileOneLine("oneBigLineFile.txt", 10 * 1024 * 1024);
        generateBinaryFile("binFile.txt", 1 * 1024 * 1024);

        origin = new PrintStream(System.out);
    }

    void CatMiddleware(String[] args) throws IOException {
        File outputFile = new File("output");
        if (outputFile.exists()) {
            outputFile.delete();
        }
        outputFile.createNewFile();

        FileOutputStream fos = new FileOutputStream(outputFile);
        PrintStream ps = new PrintStream(fos);
        System.setOut(ps);

        Cat.cat(args);

        ps.flush();
        ps.close();
        System.setOut(new PrintStream(origin));
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
    void NoArgument() throws IOException {
        CatMiddleware(new String[] {});
        File outputFile = new File("output");
        assertThat(outputFile)
                .withFailMessage("You have to write nothing in the stdout")
                .hasSize(0);
    }

    @Test
    void EmptyFile() throws IOException {
        CatMiddleware(new String[] { "empty.txt" });
        File resFile = new File("empty.txt");
        File outputFile = new File("output");
        assertThat(outputFile)
                .withFailMessage("Your output doesn't match the input file")
                .hasSameTextualContentAs(resFile);
    }

    @Test
    void HelloFile() throws IOException {
        CatMiddleware(new String[] { "smallFile.txt" });
        File resFile = new File("smallFile.txt");
        File outputFile = new File("output");
        assertThat(outputFile)
                .withFailMessage("Your output doesn't match the input file")
                .hasSameTextualContentAs(resFile);
    }

    @Test
    void BigFile() throws IOException {
        CatMiddleware(new String[] { "bigFile.txt" });
        File resFile = new File("bigFile.txt");
        File outputFile = new File("output");
        assertThat(outputFile)
                .withFailMessage("Your output doesn't match the input file")
                .hasSameTextualContentAs(resFile);
    }

    @Test
    void BinaryFile() throws IOException {
        CatMiddleware(new String[] { "binFile.txt" });
        File resFile = new File("binFile.txt");
        File outputFile = new File("output");
        assertThat(outputFile)
                .withFailMessage("Your output doesn't match the input file")
                .hasSameBinaryContentAs(resFile);
    }

    @Test
    void OneLineFile() throws IOException {
        CatMiddleware(new String[] { "oneLineFile.txt" });
        File resFile = new File("oneLineFile.txt");
        File outputFile = new File("output");
        assertThat(outputFile)
                .withFailMessage("Your output doesn't match the input file")
                .hasSameBinaryContentAs(resFile);
    }

    void OneBigLineFile() throws IOException {
        CatMiddleware(new String[] { "oneBigLineFile.txt" });
        File resFile = new File("oneBigLineFile.txt");
        File outputFile = new File("output");
        assertThat(outputFile)
                .withFailMessage("Your output doesn't match the input file")
                .hasSameBinaryContentAs(resFile);
    }
}