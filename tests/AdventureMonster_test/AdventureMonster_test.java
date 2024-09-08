
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Fail.fail;

import java.lang.reflect.AnnotatedType;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(StopAfterFailureExtension.class)
class AdventureMonsterTest {

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
    void classMonster_shouldBePublic() {
        assertThat(Monster.class)
                .withFailMessage("Monster should be public")
                .isPublic();
        assertThat(Monster.class.getSuperclass())
                .withFailMessage("Monster should inherit Character")
                .isEqualTo(Character.class);
    }

    @Test
    void classMonster_shouldHaveFullParameterConstructor() {
        try {
            Constructor<Monster> constructor = Monster.class.getDeclaredConstructor(String.class, int.class);
            assertThat(Modifier.isPublic(constructor.getModifiers()))
                    .withFailMessage("Full parameters constructor should be public")
                    .isTrue();
        } catch (NoSuchMethodException e) {
            fail("Monster should have a String and int parameters constructor");
        }
    }

    @Test
    void objectMonster_toString() {
        try {
            Field allCharacters = Character.class.getDeclaredField("allCharacters");
            allCharacters.setAccessible(true);
            allCharacters.set(null, new ArrayList<>());
            allCharacters.setAccessible(false);

            Method printStatus = Character.class.getDeclaredMethod("printStatus");
            Method fight = Character.class.getDeclaredMethod("fight", Character.class, Character.class);
            String firstPrint = (String) printStatus.invoke(null);

            assertThat(firstPrint)
                    .withFailMessage("printStatus is not correct")
                    .isEqualTo("""
                ------------------------------------------
                Nobody's fighting right now !
                ------------------------------------------
                """);

            Constructor<Monster> constructor = Monster.class.getDeclaredConstructor(String.class, int.class);
            Monster gobelin = constructor.newInstance("Gobelin", 30);
            Monster leviathan = constructor.newInstance("Leviathan", 10);

            assertThat(gobelin.toString())
                    .withFailMessage("Monster toString is not correct : %s", leviathan.toString())
                    .isEqualTo("Gobelin is a monster with 30 HP");
            assertThat(leviathan.toString())
                    .withFailMessage("Monster toString is not correct : %s", leviathan.toString())
                    .isEqualTo("Leviathan is a monster with 10 HP");

            fight.invoke(null, gobelin, leviathan);

            assertThat(leviathan.toString())
                    .withFailMessage("Monster toString is not correct : %s", leviathan.toString())
                    .isEqualTo("Leviathan is a monster and is dead");

            String lastPrint = (String) printStatus.invoke(null);

            assertThat(lastPrint)
                    .withFailMessage("printStatus is not correct")
                    .isEqualTo("""
                ------------------------------------------
                Characters currently fighting :
                 - Gobelin is a monster with 21 HP
                 - Leviathan is a monster and is dead
                ------------------------------------------
                """);

        } catch (NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException |
                 NoSuchFieldException e) {
            fail("Character is not correctly defined", e);
        }
    }
}