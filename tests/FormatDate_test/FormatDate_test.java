import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(StopAfterFailureExtension.class)
class FormatDateTest {

    @Test
    void formatToFullText_shouldReturnTheFormattedString() {
        LocalDateTime date = LocalDateTime.of(2021, 10, 27, 16, 52, 31, 12345);

        String expected = date.format(DateTimeFormatter.ofPattern("'Le' dd MMM 'de l''an' yyyy 'à' HH'h'mm'm et' ss's'", Locale.FRANCE));

        String res = FormatDate.formatToFullText(date);

        assertThat(res)
                .withFailMessage("Should return %s, but was %s", expected, res)
                .isEqualTo(expected);
    }

    @Test
    void formatToFullText_shouldReturnNull_whenStringIsNull() {
        String res = FormatDate.formatToFullText(null);

        assertThat(res)
                .withFailMessage("Should return null, but was not")
                .isNull();
    }

    @Test
    void formatSimple_shouldReturnTheFormattedString() {
        LocalDate date = LocalDate.of(2018, 5, 18);

        String expected = date.format(DateTimeFormatter.ofPattern("MMMM dd yy", Locale.ITALY));

        String res = FormatDate.formatSimple(date);

        assertThat(res)
                .withFailMessage("Should return %s, but was %s", expected, res)
                .isEqualTo(expected);
    }

    @Test
    void formatSimple_shouldReturnNull_whenStringIsNull() {
        String res = FormatDate.formatSimple(null);

        assertThat(res)
                .withFailMessage("Should return null, but was not")
                .isNull();
    }

    @Test
    void formatIso_shouldReturnTheFormattedString() {
        LocalTime date = LocalTime.of(18, 10, 54);
        String expected = date.format(DateTimeFormatter.ISO_LOCAL_TIME);

        String res = FormatDate.formatIso(date);

        assertThat(res)
                .withFailMessage("Should return %s, but was %s", expected, res)
                .isEqualTo(expected);
    }

    @Test
    void parseTimeFormat_shouldReturnNull_whenStringIsNull() {
        String res = FormatDate.formatIso(null);

        assertThat(res)
                .withFailMessage("Should return null, but was not")
                .isNull();
    }

}