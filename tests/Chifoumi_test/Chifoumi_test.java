import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.Random;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(StopAfterFailureExtension.class)
class ChifoumiTest {

    @Test
    void getActionBeatenBy_shouldReturnRock_withPaper() {
        ChifoumiAction res = Chifoumi.getActionBeatenBy(ChifoumiAction.PAPER);

        assertThat(res)
                .withFailMessage("PAPER should beat %s but was %s", ChifoumiAction.ROCK, res)
                .isEqualTo(ChifoumiAction.ROCK);
    }

    @Test
    void getActionBeatenBy_shouldReturnScissor_withRock() {
        ChifoumiAction res = Chifoumi.getActionBeatenBy(ChifoumiAction.ROCK);

        assertThat(res)
                .withFailMessage("ROCK should beat %s but was %s", ChifoumiAction.SCISSOR, res)
                .isEqualTo(ChifoumiAction.SCISSOR);
    }

    @Test
    void getActionBeatenBy_shouldReturnPaper_withScissor() {
        ChifoumiAction res = Chifoumi.getActionBeatenBy(ChifoumiAction.SCISSOR);

        assertThat(res)
                .withFailMessage("SCISSOR should beat %s but was %s", ChifoumiAction.PAPER, res)
                .isEqualTo(ChifoumiAction.PAPER);
    }

}