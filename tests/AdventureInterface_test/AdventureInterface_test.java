
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Fail.fail;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(StopAfterFailureExtension.class)
class AdventureInterfaceTest {

    @Test
    void interfaceHealer_shouldBePublic() {
        assertThat(Healer.class)
                .withFailMessage("Healer should be public")
                .isPublic();
        assertThat(Healer.class)
                .withFailMessage("Healer should be an interface")
                .isInterface();
    }

    @Test
    void interfaceHealer_shouldHaveMethods() {
        try {
            Method getHealCapacity = Healer.class.getDeclaredMethod("getHealCapacity");
            assertThat(Modifier.isPublic(getHealCapacity.getModifiers()))
                    .withFailMessage("getHealCapacity method should be public")
                    .isTrue();
            assertThat(getHealCapacity.getReturnType())
                    .withFailMessage("getHealCapacity method should return int")
                    .isEqualTo(int.class);
        } catch (NoSuchMethodException e) {
            fail("Healer should have a getHealCapacity method");
        }
        try {
            Method heal = Healer.class.getDeclaredMethod("heal", Character.class);
            assertThat(Modifier.isPublic(heal.getModifiers()))
                    .withFailMessage("heal method should be public")
                    .isTrue();
            assertThat(heal.getReturnType())
                    .withFailMessage("heal method should return nothing")
                    .isEqualTo(void.class);
        } catch (NoSuchMethodException e) {
            fail("Healer should have a getHealCapacity method");
        }
    }

    @Test
    void interfaceTank_shouldBePublic() {
        assertThat(Tank.class)
                .withFailMessage("Tank should be public")
                .isPublic();
        assertThat(Tank.class)
                .withFailMessage("Tank should be an interface")
                .isInterface();
    }

    @Test
    void interfaceTank_shouldHaveMethods() {
        try {
            Method getShield = Tank.class.getDeclaredMethod("getShield");
            assertThat(Modifier.isPublic(getShield.getModifiers()))
                    .withFailMessage("getShield method should be public")
                    .isTrue();
            assertThat(getShield.getReturnType())
                    .withFailMessage("getShield method should return int")
                    .isEqualTo(int.class);
        } catch (NoSuchMethodException e) {
            fail("Tank should have a getHealCapacity method");
        }
    }

}