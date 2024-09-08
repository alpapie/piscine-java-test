import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(StopAfterFailureExtension.class)
class DayOfWeekTest {
    private DayOfWeekFinder finder;

    @BeforeEach
    void setUp() {
        finder = new DayOfWeekFinder();
    }

    @Test
    void testFindNextDayOfWeek_withValidDates() {

        String startDate1 = "2023-06-22";
        String dayOfWeek1 = "Monday";
        String expected1 = "2023-06-26";
        assertThat(finder.findNextDayOfWeek(startDate1, dayOfWeek1))
                .withFailMessage("Expected date to be %s but got %s", expected1, finder.findNextDayOfWeek(startDate1, dayOfWeek1))
                .isEqualTo(expected1);

        String startDate2 = "2023-06-22";
        String dayOfWeek2 = "Friday";
        String expected2 = "2023-06-23";
        assertThat(finder.findNextDayOfWeek(startDate2, dayOfWeek2))
                .withFailMessage("Expected date to be %s but got %s", expected2, finder.findNextDayOfWeek(startDate2, dayOfWeek2))
                .isEqualTo(expected2);

        String startDate3 = "2023-06-22";
        String dayOfWeek3 = "Sunday";
        String expected3 = "2023-06-25";
        assertThat(finder.findNextDayOfWeek(startDate3, dayOfWeek3))
                .withFailMessage("Expected date to be %s but got %s", expected3, finder.findNextDayOfWeek(startDate3, dayOfWeek3))
                .isEqualTo(expected3);
    }

    @Test
    void testFindNextDayOfWeek_withInvalidDateFormat() {
        String startDate = "invalid-date";
        String dayOfWeek = "Monday";
        String expected = "Error";
        assertThat(finder.findNextDayOfWeek(startDate, dayOfWeek))
                .withFailMessage("Expected date to be %s but got %s", expected, finder.findNextDayOfWeek(startDate, dayOfWeek))
                .isEqualTo(expected);
    }

    @Test
    void testFindNextDayOfWeek_withInvalidDayOfWeek() {
        String startDate = "2023-06-22";
        String dayOfWeek = "Funday";
        String expected = "Error";
        assertThat(finder.findNextDayOfWeek(startDate, dayOfWeek))
                .withFailMessage("Expected date to be %s but got %s", expected, finder.findNextDayOfWeek(startDate, dayOfWeek))
                .isEqualTo(expected);
    }
}
