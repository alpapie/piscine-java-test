import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(StopAfterFailureExtension.class)
class MonthlyPeriodTest {
    private MonthlyPeriod monthlyPeriod;

    @BeforeEach
    void setUp() {
        monthlyPeriod = new MonthlyPeriod();
    }

    @Test
    void testCalculatePeriod_withValidDates() {
        String startDate1 = "2020-01-01";
        String endDate1 = "2023-06-15";
        String expected1 = "3 years and 5 months";
        assertThat(monthlyPeriod.calculatePeriod(startDate1, endDate1))
                .withFailMessage("Expected period to be %s but got %s", expected1, monthlyPeriod.calculatePeriod(startDate1, endDate1))
                .isEqualTo(expected1);

        String startDate2 = "2015-05-20";
        String endDate2 = "2015-10-20";
        String expected2 = "5 months";
        assertThat(monthlyPeriod.calculatePeriod(startDate2, endDate2))
                .withFailMessage("Expected period to be %s but got %s", expected2, monthlyPeriod.calculatePeriod(startDate2, endDate2))
                .isEqualTo(expected2);

        String startDate3 = "2018-12-25";
        String endDate3 = "2021-12-25";
        String expected3 = "3 years";
        assertThat(monthlyPeriod.calculatePeriod(startDate3, endDate3))
                .withFailMessage("Expected period to be %s but got %s", expected3, monthlyPeriod.calculatePeriod(startDate3, endDate3))
                .isEqualTo(expected3);
    }

    @Test
    void testCalculatePeriod_withStartDateAfterEndDate() {
        String startDate = "2023-06-15";
        String endDate = "2020-01-01";
        String expected = "3 years and 5 months";
        assertThat(monthlyPeriod.calculatePeriod(startDate, endDate))
                .withFailMessage("Expected period to be %s but got %s", expected, monthlyPeriod.calculatePeriod(startDate, endDate))
                .isEqualTo(expected);
    }

    @Test
    void testCalculatePeriod_withSameDate() {
        String date = "2023-01-01";
        String expected = "";
        assertThat(monthlyPeriod.calculatePeriod(date, date))
                .withFailMessage("Expected period to be %s but got %s", expected, monthlyPeriod.calculatePeriod(date, date))
                .isEqualTo(expected);
    }

    @Test
    void testCalculatePeriod_withInvalidDateFormat() {
        String startDate = "invalid-date";
        String endDate = "2023-01-01";
        String expected = "Error";
        assertThat(monthlyPeriod.calculatePeriod(startDate, endDate))
                .withFailMessage("Expected period to be %s but got %s", expected, monthlyPeriod.calculatePeriod(startDate, endDate))
                .isEqualTo(expected);
    }

    @Test
    void testCalculatePeriod_withInvalidDateValue() {
        String startDate = "2020-13-30";
        String endDate = "2023-01-01";
        String expected = "Error";
        assertThat(monthlyPeriod.calculatePeriod(startDate, endDate))
                .withFailMessage("Expected period to be %s but got %s", expected, monthlyPeriod.calculatePeriod(startDate, endDate))
                .isEqualTo(expected);
    }

    @Test
    void testCalculateSingularPeriod_withValidDate() {
        String startDate = "2018-10-25";
        String endDate = "2019-11-30";
        String expected = "1 year and 1 month";
        assertThat(monthlyPeriod.calculatePeriod(startDate, endDate))
                .withFailMessage("Expected period to be %s but got %s", expected, monthlyPeriod.calculatePeriod(startDate, endDate))
                .isEqualTo(expected);
    }
}
