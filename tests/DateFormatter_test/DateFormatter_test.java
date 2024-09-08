import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.io.File;
import java.io.FileReader;
import java.io.LineNumberReader;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(StopAfterFailureExtension.class)
class DateFormatterTest {

    @Test
    void defaultConstructor_shouldInitializeWithDefaultValues() {
        DateFormatter df = new DateFormatter();
        df.setDate(1656374400);
        df.setFormat("DD/MM/YYYY");
        String res = df.getFormattedDate();

        assertThat(res)
                .withFailMessage("Default constructor should initialize with default values, then set to '28/06/2022', but returned " + res)
                .isEqualTo("28/06/2022");
    }

    @Test
    void constructorWithDateOnly_shouldInitializeCorrectly() {
        DateFormatter df = new DateFormatter(1656374400);
        df.setFormat("DD/MM/YYYY");
        String res = df.getFormattedDate();

        assertThat(res)
                .withFailMessage("Constructor with date only should initialize correctly and format to '28/06/2022', but returned " + res)
                .isEqualTo("28/06/2022");
    }

    @Test
    void constructorWithDateAndFormat_shouldInitializeCorrectly() {
        DateFormatter df = new DateFormatter(1656374400, "DD/MM/YYYY");
        String res = df.getFormattedDate();

        assertThat(res)
                .withFailMessage("Constructor with date and format should initialize correctly and format to '28/06/2022', but returned " + res)
                .isEqualTo("28/06/2022");
    }

    @Test
    void getDate_shouldReturnCorrectDate() {
        DateFormatter df = new DateFormatter(1656374400, "DD/MM/YYYY");
        long date = df.getDate();

        assertThat(date)
                .withFailMessage("Getter should return correct date, but returned " + date)
                .isEqualTo(1656374400);
    }

    @Test
    void getFormat_shouldReturnCorrectFormat() {
        DateFormatter df = new DateFormatter(1656374400, "DD/MM/YYYY");
        String format = df.getFormat();

        assertThat(format)
                .withFailMessage("Getter should return correct format, but returned " + format)
                .isEqualTo("DD/MM/YYYY");
    }

    @Test
    void getFormattedDate_shouldReturnCorrectFormattedDate() {
        DateFormatter df = new DateFormatter(1656374400, "DD/MM/YYYY");
        String formattedDate = df.getFormattedDate();

        assertThat(formattedDate)
                .withFailMessage("Getter should return correct formatted date, but returned " + formattedDate)
                .isEqualTo("28/06/2022");
    }

    @Test
    void setFormat_shouldUpdateFormattedDate_whenFormatChanges() {
        DateFormatter df = new DateFormatter(1656374400, "DD/MM/YYYY");
        df.setFormat("DD.MM.YYYY");
        String res = df.getFormattedDate();

        assertThat(res)
                .withFailMessage("Should return '28.06.2022' after changing format to 'DD.MM.YYYY', but returned " + res)
                .isEqualTo("28.06.2022");
    }

    @Test
    void setDate_shouldUpdateFormattedDate_whenDateChanges() {
        DateFormatter df = new DateFormatter(1656374400, "DD.MM.YYYY");
        df.setDate(1672531200);
        String res = df.getFormattedDate();

        assertThat(res)
                .withFailMessage("Should return '01.01.2023' after changing date to timestamp 1672531200, but returned " + res)
                .isEqualTo("01.01.2023");
    }

    @Test
    void setInvalidFormat_shouldNotChangeFormattedDate() {
        DateFormatter df = new DateFormatter(1656374400, "DD/MM/YYYY");
        df.setFormat("INVALID_FORMAT");
        String res = df.getFormattedDate();

        assertThat(res)
                .withFailMessage("Should not change formatted date when setting an invalid format, but returned " + res)
                .isEqualTo("28/06/2022");
    }

    @Test
    void getFormattedDate_shouldReturnCorrectFormat_whenDDMMYYYY() {
        DateFormatter df = new DateFormatter(1656374400, "DD/MM/YYYY");
        String res = df.getFormattedDate();

        assertThat(res)
                .withFailMessage("Should return '28/06/2022' for timestamp 1656374400 with format 'DD/MM/YYYY', but returned " + res)
                .isEqualTo("28/06/2022");
    }

    @Test
    void getFormattedDate_shouldReturnCorrectFormat_whenDDMMYYYY_withDifferentFormat() {
        DateFormatter df = new DateFormatter(1656374400, "DD.MM.YYYY");
        String res = df.getFormattedDate();

        assertThat(res)
                .withFailMessage("Should return '28.06.2022' for timestamp 1656374400 with format 'DD.MM.YYYY', but returned " + res)
                .isEqualTo("28.06.2022");
    }

    @Test
    void getFormattedDate_shouldReturnCorrectFormat_whenDDMonthYYYY() {
        DateFormatter df = new DateFormatter(1672531200, "DD Month YYYY");
        String res = df.getFormattedDate();

        assertThat(res)
                .withFailMessage("Should return '01 January 2023' for timestamp 1672531200 with format 'DD Month YYYY', but returned " + res)
                .isEqualTo("01 January 2023");
    }

    @Test
    void testDateFormatterCaseSensitivity() {
        DateFormatter df = new DateFormatter(1656374400, "dd/mm/yyyy");
        assertThat(df.getFormattedDate()).isEqualTo("28/06/2022");

        df.setFormat("dd.mm.yyyy");
        assertThat(df.getFormattedDate()).isEqualTo("28.06.2022");

        df.setFormat("dd month yyyy");
        assertThat(df.getFormattedDate()).isEqualTo("28 June 2022");
    }

    @Test
    void testNoStandardLibraryUsageForFormatting() {
        try {
            File file = new File("src/main/java/DateFormatter.java");
            LineNumberReader reader = new LineNumberReader(new FileReader(file));
            String line;
            boolean usesForbiddenImport = false;

            while ((line = reader.readLine()) != null) {
                if (line.contains("import java.text.SimpleDateFormat") || 
                    line.contains("import java.time.format.DateTimeFormatter") ||
                    line.contains("import java.time.LocalDate") ||
                    line.contains("import java.time.LocalDateTime") ||
                    line.contains("import java.time.ZonedDateTime") ||
                    line.contains("import java.time.OffsetDateTime") ||
                    line.contains("import java.util.GregorianCalendar") ||
                    line.contains("import java.time.format.*") ||
                    line.contains("import java.text.*")) {
                    usesForbiddenImport = true;
                    break;
                }
            }
            reader.close();

            assertThat(usesForbiddenImport)
                .withFailMessage("DateFormatter should not use standard library classes for formatting")
                .isFalse();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
