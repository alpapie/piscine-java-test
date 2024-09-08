import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.Period;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(StopAfterFailureExtension.class)
class AgeFinderTest {
    private AgeFinder ageFinder;

    @BeforeEach
    void setUp() {
        ageFinder = new AgeFinder();
    }

    @Test
    void testCalculateAge_withValidDates() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        String date1 = "2000-01-01";
        LocalDate birthDate1 = LocalDate.parse(date1, formatter);
        LocalDate currentDate1 = LocalDate.now();
        int expected1 = Period.between(birthDate1, currentDate1).getYears();
        assertThat(ageFinder.calculateAge(date1))
                .withFailMessage("Expected age to be %d but got %d", expected1, ageFinder.calculateAge(date1))
                .isEqualTo(expected1);

        String date2 = "1990-06-15";
        LocalDate birthDate2 = LocalDate.parse(date2, formatter);
        LocalDate currentDate2 = LocalDate.now();
        int expected2 = Period.between(birthDate2, currentDate2).getYears();
        assertThat(ageFinder.calculateAge(date2))
                .withFailMessage("Expected age to be %d but got %d", expected2, ageFinder.calculateAge(date2))
                .isEqualTo(expected2);

        String date3 = "2010-12-25";
        LocalDate birthDate3 = LocalDate.parse(date3, formatter);
        LocalDate currentDate3 = LocalDate.now();
        int expected3 = Period.between(birthDate3, currentDate3).getYears();
        assertThat(ageFinder.calculateAge(date3))
                .withFailMessage("Expected age to be %d but got %d", expected3, ageFinder.calculateAge(date3))
                .isEqualTo(expected3);
    }

    @Test
    void testCalculateAge_withInvalidDateFormat() {
        String date = "invalid-date";
        assertThat(ageFinder.calculateAge(date))
                .withFailMessage("Expected age to be -1 but got %d", ageFinder.calculateAge(date))
                .isEqualTo(-1);
    }

    @Test
    void testCalculateAge_withFutureDate() {
        String date = "3000-01-01";
        assertThat(ageFinder.calculateAge(date))
                .withFailMessage("Expected age to be -1 but got %d", ageFinder.calculateAge(date))
                .isEqualTo(-1);
    }

    @Test
    void testCalculateAge_withEdgeCases() {
        // Edge case: Leap year
        String date = "2000-02-29";
        int expected = LocalDate.now().getYear() - 2000;
        assertThat(ageFinder.calculateAge(date))
                .withFailMessage("Expected age to be %d but got %d", expected, ageFinder.calculateAge(date))
                .isEqualTo(expected);

        // Edge case: Minimum valid date
        String minDate = "0001-01-01";
        int minExpected = LocalDate.now().getYear() - 1;
        assertThat(ageFinder.calculateAge(minDate))
                .withFailMessage("Expected age to be %d but got %d", minExpected, ageFinder.calculateAge(minDate))
                .isEqualTo(minExpected);
    }
}
