import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(StopAfterFailureExtension.class)
class HelloWorldTest {

    @Test
    void helloWorld() {
        String res = HelloWorld.helloWorld();

        assertThat(res).isEqualTo("Hello World !");
    }
}