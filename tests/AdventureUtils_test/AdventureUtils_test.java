
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
class AdventureUtilsTest {

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
                    .withFailMessage("fight method should be static")
                    .isTrue();
            assertThat(fight.getReturnType())
                    .withFailMessage("fight method should return Character")
                    .isEqualTo(Character.class);
        } catch (NoSuchMethodException e) {
            fail("Character should have fight method");
        }
    }

    @Test
    @Order(0)
    void object_printStatus() {
        try {
            Field allCharacters = Character.class.getDeclaredField("allCharacters");
            allCharacters.setAccessible(true);
            allCharacters.set(null, new ArrayList<>());
            allCharacters.setAccessible(false);

            Method printStatus = Character.class.getDeclaredMethod("printStatus");
            Method attack = Character.class.getDeclaredMethod("attack", Character.class);
            String firstPrint = (String) printStatus.invoke(null);

            assertThat(firstPrint)
                    .withFailMessage("Printstatus is not correct")
                    .isEqualTo("""
                ------------------------------------------
                Nobody's fighting right now !
                ------------------------------------------
                """);

            Constructor<Character> constructor = Character.class.getDeclaredConstructor(String.class, int.class);
            Character legolas = constructor.newInstance("Legolas", 20);
            Character sephiroth = constructor.newInstance("Sephiroth", 8);
            constructor.newInstance("Commandant Shepard", 18);

            attack.invoke(legolas, sephiroth);

            String lastPrint = (String) printStatus.invoke(null);
            
            assertThat(lastPrint)
                    .withFailMessage("Printstatus is not correct")
                    .isEqualTo("""
                ------------------------------------------
                Characters currently fighting :
                 - Legolas : 20/20
                 - Sephiroth : KO
                 - Commandant Shepard : 18/18
                ------------------------------------------
                """);

        } catch (NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException |
                 NoSuchFieldException e) {
            fail("Character is not correctly defined", e);
        }
    }

    @Test
    void object_fight_firstRoundWin_firstCharacter() {
        try {
            Method fight = Character.class.getDeclaredMethod("fight", Character.class, Character.class);

            Constructor<Character> constructor = Character.class.getDeclaredConstructor(String.class, int.class);
            Character legolas = constructor.newInstance("Legolas", 20);
            Character sephiroth = constructor.newInstance("Sephiroth", 8);

            Character res = (Character) fight.invoke(null, legolas, sephiroth);

            assertThat(res.getName())
                    .withFailMessage("The winner of the fight should be Legolas, but was %s", res.getName())
                    .isEqualTo("Legolas");
            assertThat(res.getCurrentHealth())
                    .withFailMessage("The health of the winner of the fight should be 20 HP, but was %s", res.getCurrentHealth())
                    .isEqualTo(20);
            assertThat(sephiroth.getCurrentHealth())
                    .withFailMessage("The health of the loser of the fight should be 0 HP, but was %s", sephiroth.getCurrentHealth())
                    .isEqualTo(0);
        } catch (NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            fail("Character is not correctly defined", e);
        }
    }

    @Test
    void object_fight_firstRoundWin_secondCharacter() {
        try {
            Method fight = Character.class.getDeclaredMethod("fight", Character.class, Character.class);

            Constructor<Character> constructor = Character.class.getDeclaredConstructor(String.class, int.class);
            Character legolas = constructor.newInstance("Legolas", 8);
            Character sephiroth = constructor.newInstance("Sephiroth", 15);

            Character res = (Character) fight.invoke(null, legolas, sephiroth);

            assertThat(res.getName())
                    .withFailMessage("The winner of the fight should be Sephiroth, but was %s", res.getName())
                    .isEqualTo("Sephiroth");
            assertThat(res.getCurrentHealth())
                    .withFailMessage("The health of the winner of the fight should be 6 HP, but was %s", res.getCurrentHealth())
                    .isEqualTo(6);
            assertThat(legolas.getCurrentHealth())
                    .withFailMessage("The health of the loser of the fight should be 0 HP, but was %s", legolas.getCurrentHealth())
                    .isEqualTo(0);
        } catch (NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            fail("Character is not correctly defined", e);
        }
    }

    @Test
    void object_fight_manyRoundWin_firstCharacter() {
        try {
            Method fight = Character.class.getDeclaredMethod("fight", Character.class, Character.class);

            Constructor<Character> constructor = Character.class.getDeclaredConstructor(String.class, int.class);
            Character legolas = constructor.newInstance("Legolas", 50);
            Character sephiroth = constructor.newInstance("Sephiroth", 44);

            Character res = (Character) fight.invoke(null, legolas, sephiroth);

            assertThat(res.getName())
                    .withFailMessage("The winner of the fight should be Legolas, but was %s", res.getName())
                    .isEqualTo("Legolas");
            assertThat(res.getCurrentHealth())
                    .withFailMessage("The health of the winner of the fight should be 14 HP, but was %s", res.getCurrentHealth())
                    .isEqualTo(14);
            assertThat(sephiroth.getCurrentHealth())
                    .withFailMessage("The health of the loser of the fight should be 0 HP, but was %s", sephiroth.getCurrentHealth())
                    .isEqualTo(0);
        } catch (NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            fail("Character is not correctly defined", e);
        }
    }
}