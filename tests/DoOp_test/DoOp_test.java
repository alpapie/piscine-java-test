import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.Random;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(StopAfterFailureExtension.class)
class DoOpTest {

    @Test
    void OperateSimpleAddition() {
        String res = DoOp.operate(new String[] { "1", "+", "2" });

        assertThat(res.trim())
                .withFailMessage("1 + 2 = 3 but '%s' was returned", res)
                .isEqualTo("3");
    }

    @Test
    void OperateSimpleSubtraction() {
        String res = DoOp.operate(new String[] { "1", "-", "1" });

        assertThat(res.trim())
                .withFailMessage("1 - 1 = 0 but '%s' was returned", res)
                .isEqualTo("0");
    }

    @Test
    void OperateSimpleMultiplication() {
        String res = DoOp.operate(new String[] { "0", "*", "0" });

        assertThat(res.trim())
                .withFailMessage("0 * 0 = 0 but '%s' was returned", res)
                .isEqualTo("0");
    }

    @Test
    void OperateSimpleDivision() {
        String res = DoOp.operate(new String[] { "1", "/", "1" });

        assertThat(res.trim())
                .withFailMessage("1 / 1 = 1 but '%s' was returned", res)
                .isEqualTo("1");
    }

    @Test
    void OperateSimpleModulo() {
        String res = DoOp.operate(new String[] { "1", "%", "1" });
        assertThat(res.trim())
                .withFailMessage("1 %% 1 = 0 but '%s' was returned", res)
                .isEqualTo("0");
    }

    @Test
    void NoGivenArgument() {
        String res = DoOp.operate(new String[]{});

        assertThat(res.trim())
                .withFailMessage("Should return 'Error', '%s' was returned", res)
                .isEqualTo("Error");
    }

    @Test
    void OneGivenArgument() {
        String res = DoOp.operate(new String[]{"1"});

        assertThat(res.trim())
                .withFailMessage("Should return 'Error', '%s' was returned", res)
                .isEqualTo("Error");
    }

    @Test
    void TwoGivenArgument() {
        String res = DoOp.operate(new String[]{"1", "+"});

        assertThat(res.trim())
                .withFailMessage("Should return 'Error', '%s' was returned", res)
                .isEqualTo("Error");
    }

    @Test
    void FourGivenArgument() {
        String res = DoOp.operate(new String[]{"1", "+", "1", "1"});

        assertThat(res.trim())
                .withFailMessage("Should return 'Error', '%s' was returned", res)
                .isEqualTo("Error");
    }

    @Test
    void InvalidOperator() {
        String res = DoOp.operate(new String[]{"1", "a", "1"});

        assertThat(res.trim())
                .withFailMessage("Should return 'Error', '%s' was returned", res)
                .isEqualTo("Error");
    }

    @Test
    void NegativeNumber() {
        String res = DoOp.operate(new String[]{"-1", "+", "-1"});

        assertThat(res.trim())
                .withFailMessage("-1 + -1 = -2 but '%s' was returned", res)
                .isEqualTo("-2");
    }

}