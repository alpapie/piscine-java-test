import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(StopAfterFailureExtension.class)
class UniversalGreetingTest {

    @Test
    void greetingEN() {
        String res = UniversalGreeting.greeting("EN");

        assertThat(res).isEqualTo("Hello, How are you?");
    }

    @Test
    void greetingFR() {
        String res = UniversalGreeting.greeting("FR");

        assertThat(res).isEqualTo("Bonjour comment allez-vous?");
    }

    @Test
    void greetingES() {
        String res = UniversalGreeting.greeting("ES");

        assertThat(res).isEqualTo("Hola, cómo estás?");
    }

    @Test
    void greetingXX() {
        String res = UniversalGreeting.greeting("XX");

        assertThat(res).isEqualTo("");
    }
}