import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(StopAfterFailureExtension.class)
class GoodbyeMarsTest {

    @Test
    void goodbyeMarsTest() {
        String res = GoodbyeMars.goodbyeMars();

        assertThat(res).isEqualTo("Goodbye Mars !");
    }
}