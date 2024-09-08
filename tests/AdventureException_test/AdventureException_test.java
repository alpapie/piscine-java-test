import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Fail.fail;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(StopAfterFailureExtension.class)
class AdventureExceptionTest {

    @Test
    void classException_shouldBePublic() {
        assertThat(DeadCharacterException.class)
                .withFailMessage("DeadCharacterException should be public")
                .isPublic();
        assertThat(DeadCharacterException.class.getSuperclass())
                .withFailMessage("DeadCharacterException should inherit Exception")
                .isEqualTo(Exception.class);
    }

    @Test
    void classException_shouldHaveConstructor() {
        try {
            Constructor<DeadCharacterException> constructor = DeadCharacterException.class.getConstructor(Character.class);
            assertThat(Modifier.isPublic(constructor.getModifiers()))
                    .withFailMessage("Full parameters constructor should be public")
                    .isTrue();
        } catch (NoSuchMethodException e) {
            fail("DeadCharacterException should have a Character parameter constructor");
        }
    }

    @Test
    void objectException_monster() {
        try {
            Method getMessage = DeadCharacterException.class.getDeclaredMethod("getMessage");

            Constructor<Monster> constructorMonster = Monster.class.getConstructor(String.class, int.class, Weapon.class);
            Constructor<DeadCharacterException> constructor = DeadCharacterException.class.getConstructor(Character.class);

            Monster troll = constructorMonster.newInstance("Troll", 20, null);
            DeadCharacterException exception = constructor.newInstance(troll);

            assertThat(getMessage.invoke(exception))
                    .withFailMessage("The message of exception for monster is not correct : %s", getMessage.invoke(exception))
                    .isEqualTo("The monster Troll is dead.");

        } catch (NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            fail("Monster is not correctly defined", e);
        }
    }

    @Test
    void objectException_sorcerer() {
        try {
            Method getMessage = DeadCharacterException.class.getDeclaredMethod("getMessage");

            Constructor<Sorcerer> constructorSorcerer = Sorcerer.class.getConstructor(String.class, int.class, int.class, Weapon.class);
            Constructor<DeadCharacterException> constructor = DeadCharacterException.class.getConstructor(Character.class);

            Sorcerer saroumane = constructorSorcerer.newInstance("Saroumane", 20, 4, null);
            DeadCharacterException exception = constructor.newInstance(saroumane);

            assertThat(getMessage.invoke(exception))
                    .withFailMessage("The message of exception for sorcerer is not correct : %s", getMessage.invoke(exception))
                    .isEqualTo("The sorcerer Saroumane is dead.");
        } catch (NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            fail("Sorcerer is not correctly defined", e);
        }
    }

    @Test
    void objectException_templar() {
        try {
            Method getMessage = DeadCharacterException.class.getDeclaredMethod("getMessage");

            Constructor<Templar> constructorTemplar = Templar.class.getConstructor(String.class, int.class, int.class, int.class, Weapon.class);
            Constructor<DeadCharacterException> constructor = DeadCharacterException.class.getConstructor(Character.class);

            Templar lancelot = constructorTemplar.newInstance("Lacelot", 20, 4, 2, null);
            DeadCharacterException exception = constructor.newInstance(lancelot);

            assertThat(getMessage.invoke(exception))
                    .withFailMessage("The message of exception for templar is not correct : %s", getMessage.invoke(exception))
                    .isEqualTo("The templar Lacelot is dead.");
        } catch (NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            fail("Templar is not correctly defined", e);
        }
    }
}