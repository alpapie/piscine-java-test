import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.fail;

import java.lang.reflect.Modifier;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(StopAfterFailureExtension.class)
class SingletonTest {

    @Test
    void checkClass() {
        try {
            var constructor = Excalibur.class.getDeclaredConstructor(String.class);
            assertThat(Modifier.isPrivate(constructor.getModifiers()))
                    .withFailMessage("Constructor should be private")
                    .isTrue();
        } catch (NoSuchMethodException e) {
            fail("Class should have a constructor with a String parameter");
        }
        try {
            var instanceField = Excalibur.class.getDeclaredField("INSTANCE");
            assertThat(Modifier.isPrivate(instanceField.getModifiers()))
                    .withFailMessage("INSTANCE field should be private")
                    .isTrue();
            assertThat(Modifier.isStatic(instanceField.getModifiers()))
                    .withFailMessage("INSTANCE field should be static")
                    .isTrue();
        } catch (NoSuchFieldException e) {
            fail("Class should have a INSTANCE field");
        }
    }

    @Test
    void getInstance() {
        var excalibur = Excalibur.getInstance();
        assertThat(excalibur.getName())
                .withFailMessage("Name should be Sword but was %s", excalibur.getName())
                .isEqualTo("Sword");
        assertThat(excalibur)
                .withFailMessage("Object returned by getInstance should be exactly the same instance")
                .isEqualTo(Excalibur.getInstance());
    }

}