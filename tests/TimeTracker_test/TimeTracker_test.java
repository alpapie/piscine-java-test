import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(StopAfterFailureExtension.class)
class TimeTrackerTest {

    @Test
    void testShortProject() {
        ProjectTime project = new ProjectTime("2023-05-14 09:00", "2023-05-14 09:30");
        assertThat(project.getHoursLogged()).isEqualTo("30 m");
    }

    @Test
    void testOvernightProject() {
        ProjectTime project = new ProjectTime("2023-05-14 20:00", "2023-05-15 08:00");
        assertThat(project.getHoursLogged()).isEqualTo("12 h");
    }

    @Test
    void testFullDayProject() {
        ProjectTime project = new ProjectTime("2023-05-14 00:00", "2023-05-15 00:00");
        assertThat(project.getHoursLogged()).isEqualTo("24 h");
    }

    @Test
    void testErrorProject() {
        ProjectTime project = new ProjectTime("2023-05-14", "2023-05-15 08:00");
        assertThat(project.getHoursLogged()).isEqualTo("-1");
    }

    @Test
    void testProjectWithNegativeTime() {
        ProjectTime project = new ProjectTime("2023-05-15 08:00", "2023-05-14 09:00");
        assertThat(project.getHoursLogged()).isEqualTo("-1");
    }

    // Edge case tests
    @Test
    void testTransitionFromMinutesToHours() {
        ProjectTime project = new ProjectTime("2023-05-14 09:00", "2023-05-14 11:00");
        assertThat(project.getHoursLogged()).isEqualTo("2 h");
    }

    @Test
    void testTransitionFromHoursToDays() {
        ProjectTime project = new ProjectTime("2023-05-14 00:00", "2023-05-19 00:00");
        assertThat(project.getHoursLogged()).isEqualTo("5 d");
    }

    @Test
    void testTransitionFromDaysToMonths() {
        ProjectTime project = new ProjectTime("2023-01-01 00:00", "2023-05-01 00:00");
        assertThat(project.getHoursLogged()).isEqualTo("4 mo");
    }

    @Test
    void testExactThresholdForMinutesToHours() {
        ProjectTime project = new ProjectTime("2023-05-14 09:00", "2023-05-14 10:59");
        assertThat(project.getHoursLogged()).isEqualTo("119 m");

        project.setEndTime("2023-05-14 11:00");
        assertThat(project.getHoursLogged()).isEqualTo("2 h");
    }

    @Test
    void testExactThresholdForHoursToDays() {
        ProjectTime project = new ProjectTime("2023-05-14 00:00", "2023-05-18 23:59");
        assertThat(project.getHoursLogged()).isEqualTo("119 h");

        project.setEndTime("2023-05-19 00:00");
        assertThat(project.getHoursLogged()).isEqualTo("5 d");
    }

    @Test
    void testExactThresholdForDaysToMonths() {
        ProjectTime project = new ProjectTime("2023-01-01 00:00", "2023-04-30 23:59");
        assertThat(project.getHoursLogged()).isEqualTo("119 d");

        project.setEndTime("2023-05-01 00:00");
        assertThat(project.getHoursLogged()).isEqualTo("4 mo");
    }
}
