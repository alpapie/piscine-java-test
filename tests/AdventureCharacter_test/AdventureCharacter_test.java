
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Fail.fail;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(StopAfterFailureExtension.class)
class AdventureCharacterTest {

    @Test
    void class_shouldBePublic() {
        assertThat(Character.class)
                .withFailMessage("Character should be public")
                .isPublic();
    }

    @Test
    void class_shouldHaveFullParameterConstructor() {
        try {
            Constructor<Character> constructor = Character.class.getDeclaredConstructor(String.class, int.class);
            assertThat(Modifier.isPublic(constructor.getModifiers()))
                    .withFailMessage("Full parameters constructor should be public")
                    .isTrue();
        } catch (NoSuchMethodException e) {
            fail("Character should have a String and int parameters constructor");
        }
    }

    @Test
    void class_shouldHaveCorrectProperties() {
        try {
            Field field = Character.class.getDeclaredField("name");
            assertThat(Modifier.isPrivate(field.getModifiers()))
                    .withFailMessage("name property should be private")
                    .isTrue();
            assertThat(Modifier.isFinal(field.getModifiers()))
                    .withFailMessage("name property should be final")
                    .isTrue();
            assertThat(field.getType())
                    .withFailMessage("name property should be a String, but was %s", field.getType())
                    .isEqualTo(String.class);
        } catch (NoSuchFieldException e) {
            fail("Character should have a name property");
        }
        try {
            Field field = Character.class.getDeclaredField("currentHealth");
            assertThat(Modifier.isPrivate(field.getModifiers()))
                    .withFailMessage("currentHealth property should be private")
                    .isTrue();
            assertThat(Modifier.isFinal(field.getModifiers()))
                    .withFailMessage("currentHealth property should not be final")
                    .isFalse();
            assertThat(field.getType())
                    .withFailMessage("currentHealth property should be a int, but was %s", field.getType())
                    .isEqualTo(int.class);
        } catch (NoSuchFieldException e) {
            fail("Character should have a currentHealth property");
        }
        try {
            Field field = Character.class.getDeclaredField("maxHealth");
            assertThat(Modifier.isPrivate(field.getModifiers()))
                    .withFailMessage("maxHealth property should be private")
                    .isTrue();
            assertThat(Modifier.isFinal(field.getModifiers()))
                    .withFailMessage("maxHealth property should be final")
                    .isTrue();
            assertThat(field.getType())
                    .withFailMessage("maxHealth property should be a int, but was %s", field.getType())
                    .isEqualTo(int.class);
        } catch (NoSuchFieldException e) {
            fail("Character should have a maxHealth property");
        }
    }

    @Test
    void class_shouldHaveGetters() {
        try {
            Method getter = Character.class.getDeclaredMethod("getName");
            assertThat(Modifier.isPublic(getter.getModifiers()))
                    .withFailMessage("getName method should be public")
                    .isTrue();
            assertThat(getter.getReturnType())
                    .withFailMessage("getName method should return String")
                    .isEqualTo(String.class);
        } catch (NoSuchMethodException e) {
            fail("Character should have getName method");
        }
        try {
            Method getter = Character.class.getDeclaredMethod("getCurrentHealth");
            assertThat(Modifier.isPublic(getter.getModifiers()))
                    .withFailMessage("getCurrentHealth method should be public")
                    .isTrue();
            assertThat(getter.getReturnType())
                    .withFailMessage("getCurrentHealth method should return int")
                    .isEqualTo(int.class);
        } catch (NoSuchMethodException e) {
            fail("Character should have getCurrentHealth method");
        }
        try {
            Method getter = Character.class.getDeclaredMethod("getMaxHealth");
            assertThat(Modifier.isPublic(getter.getModifiers()))
                    .withFailMessage("getMaxHealth method should be public")
                    .isTrue();
            assertThat(getter.getReturnType())
                    .withFailMessage("getMaxHealth method should return int")
                    .isEqualTo(int.class);
        } catch (NoSuchMethodException e) {
            fail("Character should have getMaxHealth method");
        }
    }

    @Test
    void class_shouldHaveAttackMethod() {
        try {
            Method getter = Character.class.getDeclaredMethod("attack", Character.class);
            assertThat(Modifier.isPublic(getter.getModifiers()))
                    .withFailMessage("attack method should be public")
                    .isTrue();
            assertThat(getter.getReturnType())
                    .withFailMessage("attack method should return nothing")
                    .isEqualTo(void.class);
        } catch (NoSuchMethodException e) {
            fail("Character should have attack method");
        }
        try {
            Method getter = Character.class.getDeclaredMethod("takeDamage", int.class);
            assertThat(Modifier.isPublic(getter.getModifiers()))
                    .withFailMessage("takeDamage method should be public")
                    .isTrue();
            assertThat(getter.getReturnType())
                    .withFailMessage("takeDamage method should return nothing")
                    .isEqualTo(void.class);
        } catch (NoSuchMethodException e) {
            fail("Character should have takeDamage method");
        }
    }

    @Test
    void object_takeDamage() {

        try {
            Constructor<Character> constructor = Character.class.getDeclaredConstructor(String.class, int.class);
            Character legolas = constructor.newInstance("Legolas", 20);
            Character sephiroth = constructor.newInstance("Sephiroth", 10);

            Method getCurrentHealth = Character.class.getDeclaredMethod("getCurrentHealth");
            Method getMaxHealth = Character.class.getDeclaredMethod("getMaxHealth");
            Method getName = Character.class.getDeclaredMethod("getName");
            Method attack = Character.class.getDeclaredMethod("attack", Character.class);
            Method takeDamage = Character.class.getDeclaredMethod("takeDamage", int.class);

            assertThat(getCurrentHealth.invoke(legolas))
                    .withFailMessage("Legolas current health should be 20")
                    .isEqualTo(20);
            assertThat(getMaxHealth.invoke(legolas))
                    .withFailMessage("Legolas max health should be 20")
                    .isEqualTo(20);
            assertThat(getName.invoke(legolas))
                    .withFailMessage("Legolas name should be Legolas")
                    .isEqualTo("Legolas");

            assertThat(getCurrentHealth.invoke(sephiroth))
                    .withFailMessage("Sephiroth current health should be 10")
                    .isEqualTo(10);
            assertThat(getMaxHealth.invoke(sephiroth))
                    .withFailMessage("Sephiroth max health should be 10")
                    .isEqualTo(10);
            assertThat(getName.invoke(sephiroth))
                    .withFailMessage("Sephiroth name should be Sephiroth")
                    .isEqualTo("Sephiroth");

            attack.invoke(legolas, sephiroth);

            assertThat(getCurrentHealth.invoke(sephiroth))
                    .withFailMessage("Sephiroth current health should be 1")
                    .isEqualTo(1);
            assertThat(getMaxHealth.invoke(sephiroth))
                    .withFailMessage("Sephiroth max health should be 10")
                    .isEqualTo(10);
            assertThat(getName.invoke(sephiroth))
                    .withFailMessage("Sephiroth name should be Sephiroth")
                    .isEqualTo("Sephiroth");

            attack.invoke(legolas, sephiroth);

            assertThat(getCurrentHealth.invoke(sephiroth))
                    .withFailMessage("Sephiroth current health should be 0")
                    .isEqualTo(0);
            assertThat(getMaxHealth.invoke(sephiroth))
                    .withFailMessage("Sephiroth max health should be 10")
                    .isEqualTo(10);
            assertThat(getName.invoke(sephiroth))
                    .withFailMessage("Sephiroth name should be Sephiroth")
                    .isEqualTo("Sephiroth");

            assertThat(getCurrentHealth.invoke(legolas))
                    .withFailMessage("Legolas current health should be 20")
                    .isEqualTo(20);
            assertThat(getMaxHealth.invoke(legolas))
                    .withFailMessage("Legolas max health should be 20")
                    .isEqualTo(20);
            assertThat(getName.invoke(legolas))
                    .withFailMessage("Legolas name should be Legolas")
                    .isEqualTo("Legolas");

            takeDamage.invoke(legolas, 15);

            assertThat(getCurrentHealth.invoke(legolas))
                    .withFailMessage("Legolas current health should be 5")
                    .isEqualTo(5);
            assertThat(getMaxHealth.invoke(legolas))
                    .withFailMessage("Legolas max health should be 20")
                    .isEqualTo(20);
            assertThat(getName.invoke(legolas))
                    .withFailMessage("Legolas name should be Legolas")
                    .isEqualTo("Legolas");


        } catch (NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            fail("Character is not correctly defined", e);
        }
    }
    @Test
    void object_methods() {

        try {
            Constructor<Character> constructor = Character.class.getDeclaredConstructor(String.class, int.class);
            Character legolas = constructor.newInstance("Legolas", 20);
            Character sephiroth = constructor.newInstance("Sephiroth", 10);

            Method getCurrentHealth = Character.class.getDeclaredMethod("getCurrentHealth");
            Method getMaxHealth = Character.class.getDeclaredMethod("getMaxHealth");
            Method getName = Character.class.getDeclaredMethod("getName");
            Method attack = Character.class.getDeclaredMethod("attack", Character.class);
            Method takeDamage = Character.class.getDeclaredMethod("takeDamage", int.class);

            assertThat(getCurrentHealth.invoke(legolas))
                    .withFailMessage("Legolas current health should be 20")
                    .isEqualTo(20);
            assertThat(getMaxHealth.invoke(legolas))
                    .withFailMessage("Legolas max health should be 20")
                    .isEqualTo(20);
            assertThat(getName.invoke(legolas))
                    .withFailMessage("Legolas name should be Legolas")
                    .isEqualTo("Legolas");

            assertThat(getCurrentHealth.invoke(sephiroth))
                    .withFailMessage("Sephiroth current health should be 10")
                    .isEqualTo(10);
            assertThat(getMaxHealth.invoke(sephiroth))
                    .withFailMessage("Sephiroth max health should be 10")
                    .isEqualTo(10);
            assertThat(getName.invoke(sephiroth))
                    .withFailMessage("Sephiroth name should be Sephiroth")
                    .isEqualTo("Sephiroth");

            attack.invoke(legolas, sephiroth);

            assertThat(getCurrentHealth.invoke(sephiroth))
                    .withFailMessage("Sephiroth current health should be 1")
                    .isEqualTo(1);
            assertThat(getMaxHealth.invoke(sephiroth))
                    .withFailMessage("Sephiroth max health should be 10")
                    .isEqualTo(10);
            assertThat(getName.invoke(sephiroth))
                    .withFailMessage("Sephiroth name should be Sephiroth")
                    .isEqualTo("Sephiroth");

            attack.invoke(legolas, sephiroth);

            assertThat(getCurrentHealth.invoke(sephiroth))
                    .withFailMessage("Sephiroth current health should be 0")
                    .isEqualTo(0);
            assertThat(getMaxHealth.invoke(sephiroth))
                    .withFailMessage("Sephiroth max health should be 10")
                    .isEqualTo(10);
            assertThat(getName.invoke(sephiroth))
                    .withFailMessage("Sephiroth name should be Sephiroth")
                    .isEqualTo("Sephiroth");

            assertThat(getCurrentHealth.invoke(legolas))
                    .withFailMessage("Legolas current health should be 20")
                    .isEqualTo(20);
            assertThat(getMaxHealth.invoke(legolas))
                    .withFailMessage("Legolas max health should be 20")
                    .isEqualTo(20);
            assertThat(getName.invoke(legolas))
                    .withFailMessage("Legolas name should be Legolas")
                    .isEqualTo("Legolas");

            takeDamage.invoke(legolas, 15);

            assertThat(getCurrentHealth.invoke(legolas))
                    .withFailMessage("Legolas current health should be 5")
                    .isEqualTo(5);
            assertThat(getMaxHealth.invoke(legolas))
                    .withFailMessage("Legolas max health should be 20")
                    .isEqualTo(20);
            assertThat(getName.invoke(legolas))
                    .withFailMessage("Legolas name should be Legolas")
                    .isEqualTo("Legolas");


            assertThat(legolas.toString())
                    .withFailMessage("The toString message is not good : %s", legolas.toString())
                    .isEqualTo("Legolas : 5/20");
            assertThat(sephiroth.toString())
                    .withFailMessage("The toString message is not good : %s", sephiroth.toString())
                    .isEqualTo("Sephiroth : KO");

        } catch (NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            fail("Character is not correctly defined", e);
        }
    }
}