import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(StopAfterFailureExtension.class)
class DifferenceBetweenDateTest {

    @Test
    void durationBetweenTime_shouldReturnTheDuration() {
        LocalTime time1 = LocalTime.of(7, 47, 43);
        LocalTime time2 = LocalTime.of(23, 25, 57);

        Duration expected = Duration.parse("PT15H38M14S");

        Duration res = DifferenceBetweenDate.durationBetweenTime(time1, time2);

        assertThat(res)
                .withFailMessage("Duration between %s and %s should be %s, but was %s", time1, time2, expected, res)
                .isEqualTo(expected);
    }

    @Test
    void durationBetweenTime_shouldReturnTheDuration_withReversedOrder() {
        LocalTime time1 = LocalTime.of(19, 47, 43);
        LocalTime time2 = LocalTime.of(12, 25, 57);

        Duration expected = Duration.parse("PT7H21M46S");

        Duration res = DifferenceBetweenDate.durationBetweenTime(time1, time2);

        assertThat(res)
                .withFailMessage("Duration between %s and %s should be %s, but was %s", time1, time2, expected, res)
                .isEqualTo(expected);
    }

    @Test
    void durationBetweenTime_shouldReturnNull_whenNull() {
        Duration res = DifferenceBetweenDate.durationBetweenTime(null, null);

        assertThat(res)
                .withFailMessage("Duration between null should be null, but was not")
                .isEqualTo(null);
    }

    @Test
    void periodBetweenDate_shouldReturnThePeriod() {
        LocalDate date1 = LocalDate.of(2020, 10, 30);
        LocalDate date2 = LocalDate.of(2022, 8, 14);

        Period expected = Period.parse("P1Y9M15D");

        Period res = DifferenceBetweenDate.periodBetweenDate(date1, date2);

        assertThat(res)
                .withFailMessage("Period between %s and %s should be %s, but was %s", date1, date2, expected, res)
                .isEqualTo(expected);
    }

    @Test
    void periodBetweenDate_shouldReturnThePeriod_withReversedOrder() {
        LocalDate date1 = LocalDate.of(2021, 7, 19);
        LocalDate date2 = LocalDate.of(2018, 4, 2);

        Period expected = Period.parse("P3Y3M17D");

        Period res = DifferenceBetweenDate.periodBetweenDate(date1, date2);

        assertThat(res)
                .withFailMessage("Period between %s and %s should be %s, but was %s", date1, date2, expected, res)
                .isEqualTo(expected);
    }

    @Test
    void periodBetweenDate_shouldReturnNull_whenNull() {
        Period res = DifferenceBetweenDate.periodBetweenDate(null, null);

        assertThat(res)
                .withFailMessage("Period between null should be null, but was not")
                .isEqualTo(null);
    }
    @Test
    void numberOfHoursBetweenDateTime_shouldReturnTheNumberOfHours() {
        LocalDateTime date1 = LocalDateTime.of(2022, 3, 30, 19, 38, 54);
        LocalDateTime date2 = LocalDateTime.of(2022, 5, 12, 3, 55, 32);

        long expected = 1016;

        Long res = DifferenceBetweenDate.numberOfHoursBetweenDateTime(date1, date2);

        assertThat(res)
                .withFailMessage("Number of hours between %s and %s should be %s, but was %s", date1, date2, expected, res)
                .isEqualTo(expected);
    }

    @Test
    void numberOfHoursBetweenDateTime_shouldReturnTheNumberOfHours_withReversedOrder() {
        LocalDateTime date1 = LocalDateTime.of(2022, 7, 27, 19, 0, 59);
        LocalDateTime date2 = LocalDateTime.of(2022, 6, 1, 8, 4, 42);

        long expected = 1354;

        Long res = DifferenceBetweenDate.numberOfHoursBetweenDateTime(date1, date2);

        assertThat(res)
                .withFailMessage("Number of hours between %s and %s should be %s, but was %s", date1, date2, expected, res)
                .isEqualTo(expected);
    }

    @Test
    void numberOfHoursBetweenDateTime_shouldReturnNull_whenNull() {
        Long res = DifferenceBetweenDate.numberOfHoursBetweenDateTime(null, null);

        assertThat(res)
                .withFailMessage("Number of hours between null should be null, but was not")
                .isEqualTo(null);
    }

}