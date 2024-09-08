import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(StopAfterFailureExtension.class)
class UnitConverterTest {

    @Test
    void testCelsiusToFahrenheit() {
        assertThat(UnitConverter.convert(new String[]{"celsius", "fahrenheit", "100"})).isEqualTo("212.00");
    }

    @Test
    void testFahrenheitToCelsius() {
        assertThat(UnitConverter.convert(new String[]{"fahrenheit", "celsius", "212"})).isEqualTo("100.00");
    }

    @Test
    void testKilometersToMiles() {
        assertThat(UnitConverter.convert(new String[]{"kilometers", "miles", "5"})).isEqualTo("3.11");
    }

    @Test
    void testMilesToKilometers() {
        assertThat(UnitConverter.convert(new String[]{"miles", "kilometers", "5"})).isEqualTo("8.05");
    }

    @Test
    void testUnsupportedConversion() {
        assertThat(UnitConverter.convert(new String[]{"pounds", "kilograms", "10"})).isEqualTo("ERROR");
    }

    @Test
    void testInvalidInputFormat() {
        assertThat(UnitConverter.convert(new String[]{"miles", "kilometers", "5", "5"})).isEqualTo("ERROR");
        assertThat(UnitConverter.convert(new String[]{"kilometers", "5"})).isEqualTo("ERROR");
        assertThat(UnitConverter.convert(new String[]{"miles"})).isEqualTo("ERROR");
        assertThat(UnitConverter.convert(new String[]{})).isEqualTo("ERROR");
    }

    @Test
    void testInvalidNumberFormat() {
        assertThat(UnitConverter.convert(new String[]{"celsius", "fahrenheit", "abc"})).isEqualTo("ERROR");
    }
}
