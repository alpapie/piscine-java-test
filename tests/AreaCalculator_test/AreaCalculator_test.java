import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.assertj.core.api.Assertions.within;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;


@ExtendWith(StopAfterFailureExtension.class)
class AreaCalculatorTest {

    @Test
    void calculateCircleArea_shouldReturnCorrectValue() {
        AreaCalculator calculator = new AreaCalculator();
        double radius = 5.0;
        double area = calculator.calculate(radius);

        assertThat(area)
                .withFailMessage("Should return 78.54 for radius 5.0, but returned " + area)
                .isEqualTo(78.54, within(0.01));
    }

    @Test
    void calculateRectangleArea_shouldReturnCorrectValue() {
        AreaCalculator calculator = new AreaCalculator();
        double width = 4.0;
        double height = 6.0;
        double area = calculator.calculate(width, height);

        assertThat(area)
                .withFailMessage("Should return 24.0 for width 4.0 and height 6.0, but returned " + area)
                .isEqualTo(24.0);
    }

    @Test
    void calculateTriangleArea_shouldReturnCorrectValue() {
        AreaCalculator calculator = new AreaCalculator();
        double base = 4.0;
        double height = 6.0;
        double area = calculator.calculate(base, height, true);

        assertThat(area)
                .withFailMessage("Should return 12.0 for base 4.0 and height 6.0, but returned " + area)
                .isEqualTo(12.0);
    }

    @Test
    void calculateSquareArea_shouldReturnCorrectValue() {
        AreaCalculator calculator = new AreaCalculator();
        double side = 4.0;
        double area = calculator.calculate(side, true);

        assertThat(area)
                .withFailMessage("Should return 16.0 for side 4.0, but returned " + area)
                .isEqualTo(16.0);
    }
}
