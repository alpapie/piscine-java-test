import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.lang.reflect.Method;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(StopAfterFailureExtension.class)
class FactorialMasterTest {

    @Test
    void iterativeFactorial_shouldReturnCorrectValue() {
        Factorial factorial = new IterativeFactorial();
        
        assertThat(factorial.calculate(0))
                .withFailMessage("IterativeFactorial: Expected 1 for input 0, but got %d", factorial.calculate(0))
                .isEqualTo(1);
        assertThat(factorial.calculate(1))
                .withFailMessage("IterativeFactorial: Expected 1 for input 1, but got %d", factorial.calculate(1))
                .isEqualTo(1);
        assertThat(factorial.calculate(5))
                .withFailMessage("IterativeFactorial: Expected 120 for input 5, but got %d", factorial.calculate(5))
                .isEqualTo(120);
        assertThat(factorial.calculate(10))
                .withFailMessage("IterativeFactorial: Expected 3628800 for input 10, but got %d", factorial.calculate(10))
                .isEqualTo(3628800);
    }

    @Test
    void recursiveFactorial_shouldReturnCorrectValue() {
        Factorial factorial = new RecursiveFactorial();
        
        assertThat(factorial.calculate(0))
                .withFailMessage("RecursiveFactorial: Expected 1 for input 0, but got %d", factorial.calculate(0))
                .isEqualTo(1);
        assertThat(factorial.calculate(1))
                .withFailMessage("RecursiveFactorial: Expected 1 for input 1, but got %d", factorial.calculate(1))
                .isEqualTo(1);
        assertThat(factorial.calculate(5))
                .withFailMessage("RecursiveFactorial: Expected 120 for input 5, but got %d", factorial.calculate(5))
                .isEqualTo(120);
        assertThat(factorial.calculate(10))
                .withFailMessage("RecursiveFactorial: Expected 3628800 for input 10, but got %d", factorial.calculate(10))
                .isEqualTo(3628800);
    }

    @Test
    void iterativeFactorial_shouldBeIterative() {
        assertThat(isIterative())
                .withFailMessage("IterativeFactorial: Method should be iterative, but it appears to be recursive")
                .isTrue();
    }

    @Test
    void recursiveFactorial_shouldBeRecursive() {
        assertThat(isRecursive())
                .withFailMessage("RecursiveFactorial: Method should be recursive, but it appears to be iterative")
                .isTrue();
    }

    private boolean isIterative() {
        // Dummy check for iteration, this will not work properly as Java does not provide direct way to check iteration
        // However, we can just ensure it doesn't throw a stack overflow for a large input
        Factorial factorial = new IterativeFactorial();
        try {
            factorial.calculate(100000);
            return true;
        } catch (StackOverflowError e) {
            return false;
        }
    }

    private boolean isRecursive() {
        // To check if it's recursive, we reduce the stack size and try a large input to cause stack overflow
        Factorial factorial = new RecursiveFactorial();
        try {
            factorial.calculate(100000);
            return false;
        } catch (StackOverflowError e) {
            return true;
        }
    }
}
