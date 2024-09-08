
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
class AdventureSorcererTest {

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
        try {
            Field field = Character.class.getDeclaredField("allCharacters");
            assertThat(Modifier.isPrivate(field.getModifiers()))
                    .withFailMessage("allCharacters property should be private")
                    .isTrue();
            assertThat(Modifier.isFinal(field.getModifiers()))
                    .withFailMessage("allCharacters property should not be final")
                    .isFalse();
            assertThat(Modifier.isStatic(field.getModifiers()))
                    .withFailMessage("allCharacters property should be static")
                    .isTrue();
            assertThat(field.getType())
                    .withFailMessage("allCharacters property should be a List, but was %s", field.getType())
                    .isEqualTo(List.class);
        } catch (NoSuchFieldException e) {
            fail("Character should have a allCharacters property");
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
    void class_shouldHaveStaticMethod() {
        try {
            Method printStatus = Character.class.getDeclaredMethod("printStatus");
            assertThat(Modifier.isPublic(printStatus.getModifiers()))
                    .withFailMessage("printStatus method should be public")
                    .isTrue();
            assertThat(Modifier.isStatic(printStatus.getModifiers()))
                    .withFailMessage("printStatus method should be static")
                    .isTrue();
            assertThat(printStatus.getReturnType())
                    .withFailMessage("printStatus method should return nothing")
                    .isEqualTo(String.class);
        } catch (NoSuchMethodException e) {
            fail("Character should have printStatus method");
        }
        try {
            Method fight = Character.class.getDeclaredMethod("fight", Character.class, Character.class);
            assertThat(Modifier.isPublic(fight.getModifiers()))
                    .withFailMessage("fight method should be public")
                    .isTrue();
            assertThat(Modifier.isStatic(fight.getModifiers()))
                    .withFailMessage("fight method should be public")
                    .isTrue();
            assertThat(fight.getReturnType())
                    .withFailMessage("fight method should return Character")
                    .isEqualTo(Character.class);
        } catch (NoSuchMethodException e) {
            fail("Character should have fight method");
        }
    }

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
    void classSorcerer_shouldBePublic() {
        assertThat(Sorcerer.class)
                .withFailMessage("Sorcerer should be public")
                .isPublic();
        assertThat(Sorcerer.class.getSuperclass())
                .withFailMessage("Sorcerer should inherit Character")
                .isEqualTo(Character.class);
        assertThat(Sorcerer.class.getInterfaces())
                .withFailMessage("Sorcerer should implements Healer")
                .containsExactly(Healer.class);
    }

    @Test
    void classSorcerer_shouldHaveConstructor() {
        try {
            Constructor<Sorcerer> constructor = Sorcerer.class.getConstructor(String.class, int.class, int.class);
            assertThat(Modifier.isPublic(constructor.getModifiers()))
                    .withFailMessage("Full parameters constructor should be public")
                    .isTrue();
        } catch (NoSuchMethodException e) {
            fail("Sorcerer should have a String, int and int parameters constructor");
        }
    }

    @Test
    void classSorcerer_shouldHaveCorrectProperties() {
        try {
            Field field = Sorcerer.class.getDeclaredField("healCapacity");
            assertThat(Modifier.isPrivate(field.getModifiers()))
                    .withFailMessage("healCapacity property should be private")
                    .isTrue();
            assertThat(Modifier.isFinal(field.getModifiers()))
                    .withFailMessage("healCapacity property should be final")
                    .isTrue();
            assertThat(field.getType())
                    .withFailMessage("healCapacity property should be a int, but was %s", field.getType())
                    .isEqualTo(int.class);
        } catch (NoSuchFieldException e) {
            fail("Sorcerer should have a healCapacity property");
        }
    }

    @Test
    void objectSorcerer_instantiationAndToString() {
        try {
            Field allCharacters = Character.class.getDeclaredField("allCharacters");
            allCharacters.setAccessible(true);
            allCharacters.set(null, new ArrayList<>());
            allCharacters.setAccessible(false);


            Method getName = Character.class.getDeclaredMethod("getName");
            Method getCurrentHealth = Character.class.getDeclaredMethod("getCurrentHealth");
            Method getMaxHealth = Character.class.getDeclaredMethod("getMaxHealth");
            Method getHealCapacity = Sorcerer.class.getDeclaredMethod("getHealCapacity");
            Method printStatus = Character.class.getDeclaredMethod("printStatus");
            Method takeDamage = Character.class.getDeclaredMethod("takeDamage", int.class);

            Constructor<Sorcerer> constructor = Sorcerer.class.getConstructor(String.class, int.class, int.class);
            Sorcerer dumbledore = constructor.newInstance("Dumbledore", 30, 8);
            Sorcerer ronWeasley = constructor.newInstance("Ron Weasley", 10, 1);

            takeDamage.invoke(ronWeasley, 12);

            assertThat(getName.invoke(dumbledore))
                    .withFailMessage("Name of sorcerer should be Dumbledore, but was %s", getName.invoke(dumbledore))
                    .isEqualTo("Dumbledore");
            assertThat(getCurrentHealth.invoke(dumbledore))
                    .withFailMessage("Current Health of sorcerer should be 30, but was %d", getCurrentHealth.invoke(dumbledore))
                    .isEqualTo(30);
            assertThat(getMaxHealth.invoke(dumbledore))
                    .withFailMessage("Max Health of sorcerer should be 30, but was %d", getMaxHealth.invoke(dumbledore))
                    .isEqualTo(30);
            assertThat(getHealCapacity.invoke(dumbledore))
                    .withFailMessage("Heal Capacity of sorcerer should be 8, but was %d", getHealCapacity.invoke(dumbledore))
                    .isEqualTo(8);
            assertThat(dumbledore.toString())
                    .withFailMessage("Sorcerer toString is not correct : %s", dumbledore.toString())
                    .isEqualTo("Dumbledore is a sorcerer with 30 HP. It can heal 8 HP.");

            assertThat(getName.invoke(ronWeasley))
                    .withFailMessage("Name of sorcerer should be Ron Weasley, but was %s", getName.invoke(ronWeasley))
                    .isEqualTo("Ron Weasley");
            assertThat(getCurrentHealth.invoke(ronWeasley))
                    .withFailMessage("Current Health of sorcerer should be 0, but was %d", getCurrentHealth.invoke(ronWeasley))
                    .isEqualTo(0);
            assertThat(getMaxHealth.invoke(ronWeasley))
                    .withFailMessage("Max Health of sorcerer should be 10, but was %d", getMaxHealth.invoke(ronWeasley))
                    .isEqualTo(10);
            assertThat(getHealCapacity.invoke(ronWeasley))
                    .withFailMessage("Heal Capacity of sorcerer should be 1, but was %d", getHealCapacity.invoke(ronWeasley))
                    .isEqualTo(1);
            assertThat(ronWeasley.toString())
                    .withFailMessage("Sorcerer toString is not correct : %s", ronWeasley.toString())
                    .isEqualTo("Ron Weasley is a dead sorcerer. So bad, it could heal 1 HP.");

            String print = (String) printStatus.invoke(null);

            assertThat(print)
                    .withFailMessage("printStatus is not correct")
                    .isEqualTo("""
                ------------------------------------------
                Characters currently fighting :
                 - Dumbledore is a sorcerer with 30 HP. It can heal 8 HP.
                 - Ron Weasley is a dead sorcerer. So bad, it could heal 1 HP.
                ------------------------------------------
                """);

        } catch (NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException |
                 NoSuchFieldException e) {
            fail("Sorcerer is not correctly defined", e);
        }
    }

    @Test
    void objectSorcerer_heal() {
        try {
            Method heal = Sorcerer.class.getDeclaredMethod("heal", Character.class);
            Method takeDamage = Character.class.getDeclaredMethod("takeDamage", int.class);

            Constructor<Sorcerer> constructor = Sorcerer.class.getConstructor(String.class, int.class, int.class);
            Sorcerer dumbledore = constructor.newInstance("Dumbledore", 30, 8);
            Sorcerer ronWeasley = constructor.newInstance("Ron Weasley", 20, 1);

            Method getCurrentHealth = Character.class.getDeclaredMethod("getCurrentHealth");

            takeDamage.invoke(ronWeasley, 12);

            assertThat(getCurrentHealth.invoke(ronWeasley))
                    .withFailMessage("The HP of Ron before healing should be 8")
                    .isEqualTo(8);

            heal.invoke(dumbledore, ronWeasley);

            assertThat(getCurrentHealth.invoke(ronWeasley))
                    .withFailMessage("The HP of Ron after first healing should be 16")
                    .isEqualTo(16);

            heal.invoke(dumbledore, ronWeasley);

            assertThat(getCurrentHealth.invoke(ronWeasley))
                    .withFailMessage("The HP of Ron after last healing should be 20")
                    .isEqualTo(20);
        } catch (NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            fail("Sorcerer is not correctly defined", e);
        }
    }

}