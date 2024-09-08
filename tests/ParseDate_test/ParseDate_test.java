import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(StopAfterFailureExtension.class)
class ParseDateTest {

    @Test
    void parseIsoFormat_shouldReturnTheDate() {
        LocalDateTime date = LocalDateTime.of(2021, 10, 27, 16, 52, 31, 12345);

        LocalDateTime res = ParseDate.parseIsoFormat(date.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));

        assertThat(res)
                .withFailMessage("Should return %s, but was %s", date.toString(), res.toString())
                .isEqualTo(date);
    }

    @Test
    void parseIsoFormat_shouldReturnNull_whenStringIsNull() {
        LocalDateTime res = ParseDate.parseIsoFormat(null);

        assertThat(res)
                .withFailMessage("Should return null, but was not")
                .isNull();
    }

    @Test
    void parseFullTextFormat_shouldReturnTheDate() {
        LocalDate date = LocalDate.of(2018, 5, 18);

        LocalDate res = ParseDate.parseFullTextFormat(date.format(DateTimeFormatter.ofPattern("EEEE dd MMMM yyyy", Locale.FRANCE)));

        assertThat(res)
                .withFailMessage("Should return %s, but was %s", date.toString(), res.toString())
                .isEqualTo(date);
    }

    @Test
    void parseFullTextFormat_shouldReturnNull_whenStringIsNull() {
        LocalDate res = ParseDate.parseFullTextFormat(null);

        assertThat(res)
                .withFailMessage("Should return null, but was not")
                .isNull();
    }

    @Test
    void parseTimeFormat_shouldReturnTheDate() {
        LocalTime date = LocalTime.of(18, 10, 54);

        LocalTime res = ParseDate.parseTimeFormat(date.format(DateTimeFormatter.ofPattern("hh 'heures' B, mm 'minutes et' ss 'secondes'", Locale.FRANCE)));

        assertThat(res)
                .withFailMessage("Should return %s, but was %s", date.toString(), res.toString())
                .isEqualTo(date);
    }

    @Test
    void parseTimeFormat_shouldReturnNull_whenStringIsNull() {
        LocalTime res = ParseDate.parseTimeFormat(null);

        assertThat(res)
                .withFailMessage("Should return null, but was not")
                .isNull();
    }

}