
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
import org.assertj.core.data.Offset;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(StopAfterFailureExtension.class)
class StarOverrideTest {

    @Test
    void class_shouldBePublic() {
        assertThat(CelestialObject.class)
                .withFailMessage("CelestialObject should be public")
                .isPublic();
    }

    @Test
    void classStar_shouldBePublicAndInherit() {
        assertThat(Star.class)
                .withFailMessage("Star should be public")
                .isPublic();

        assertThat(Star.class.getSuperclass())
                .withFailMessage("Star should inherits from CelestialObject")
                .isEqualTo(CelestialObject.class);
    }

    @Test
    void class_shouldXPropertyBePrivateAndWithCorrectType() {
        try {
            Field field = CelestialObject.class.getDeclaredField("x");
            assertThat(Modifier.isFinal(field.getModifiers()))
                    .withFailMessage("x property should not be final")
                    .isFalse();
            assertThat(field.getType())
                    .withFailMessage("x property should be a double, but was %s", field.getType())
                    .isEqualTo(double.class);
        } catch (NoSuchFieldException e) {
            fail("CelestialObject should have a x property", e);
        }
    }

    @Test
    void class_shouldYPropertyBePrivateAndWithCorrectType() {
        try {
            Field field = CelestialObject.class.getDeclaredField("y");
            assertThat(Modifier.isFinal(field.getModifiers()))
                    .withFailMessage("y property should not be final")
                    .isFalse();
            assertThat(field.getType())
                    .withFailMessage("y property should be a double, but was %s", field.getType())
                    .isEqualTo(double.class);
        } catch (NoSuchFieldException e) {
            fail("CelestialObject should have y x property");
        }
    }

    @Test
    void class_shouldZPropertyBePrivateAndWithCorrectType() {
        try {
            Field field = CelestialObject.class.getDeclaredField("z");
            assertThat(Modifier.isFinal(field.getModifiers()))
                    .withFailMessage("z property should not be final")
                    .isFalse();
            assertThat(field.getType())
                    .withFailMessage("z property should be a double, but was %s", field.getType())
                    .isEqualTo(double.class);
        } catch (NoSuchFieldException e) {
            fail("CelestialObject should have a z property");
        }
    }

    @Test
    void class_shouldNamePropertyBePrivateAndWithCorrectType() {
        try {
            Field field = CelestialObject.class.getDeclaredField("name");
            assertThat(Modifier.isFinal(field.getModifiers()))
                    .withFailMessage("name property should not be final")
                    .isFalse();
            assertThat(field.getType())
                    .withFailMessage("name property should be a String, but was %s", field.getType())
                    .isEqualTo(String.class);
        } catch (NoSuchFieldException e) {
            fail("CelestialObject should have a name property");
        }
    }

    @Test
    void class_shouldHaveDefaultConstructor() {
        try {
            Constructor<CelestialObject> constructor = CelestialObject.class.getDeclaredConstructor();
            assertThat(Modifier.isPublic(constructor.getModifiers()))
                    .withFailMessage("Default constructor should be public")
                    .isTrue();
        } catch (NoSuchMethodException e) {
            fail("CelestialObject should have a default constructor");
        }
    }

    @Test
    void class_shouldHaveFullParameterConstructor() {
        try {
            Constructor<CelestialObject> constructor = CelestialObject.class.getDeclaredConstructor(String.class, double.class, double.class, double.class);
            assertThat(Modifier.isPublic(constructor.getModifiers()))
                    .withFailMessage("Full parameters constructor should be public")
                    .isTrue();
        } catch (NoSuchMethodException e) {
            fail("CelestialObject should have a full parameters constructor");
        }
    }



    @Test
    void classStar_shouldHaveDefaultConstructor() {
        try {
            Constructor<Star> constructor = Star.class.getDeclaredConstructor();
            assertThat(Modifier.isPublic(constructor.getModifiers()))
                    .withFailMessage("Default constructor should be public")
                    .isTrue();
        } catch (NoSuchMethodException e) {
            fail("Star should have a default constructor");
        }
    }

    @Test
    void classStar_shouldHaveFullParameterConstructor() {
        try {
            Constructor<Star> constructor = Star.class.getDeclaredConstructor(String.class, double.class, double.class, double.class, double.class);
            assertThat(Modifier.isPublic(constructor.getModifiers()))
                    .withFailMessage("Full parameters constructor should be public")
                    .isTrue();
        } catch (NoSuchMethodException e) {
            fail("Star should have a full parameters constructor");
        }
    }

    @Test
    void class_shouldHaveGetterAndSetterX() {
        try {
            Method getter = CelestialObject.class.getDeclaredMethod("getX");
            assertThat(Modifier.isPublic(getter.getModifiers()))
                    .withFailMessage("getX method should be public")
                    .isTrue();
            assertThat(getter.getReturnType())
                    .withFailMessage("getX method should return double")
                    .isEqualTo(double.class);
            assertThat(getter.getParameterTypes())
                    .withFailMessage("getX method should have no parameter")
                    .isEmpty();
        } catch (NoSuchMethodException e) {
            fail("CelestialObject should have getX method");
        }
        try {
            Method setter = CelestialObject.class.getDeclaredMethod("setX", double.class);
            assertThat(Modifier.isPublic(setter.getModifiers()))
                    .withFailMessage("setX method should be public")
                    .isTrue();
            assertThat(setter.getReturnType())
                    .withFailMessage("setX method should return nothing")
                    .isEqualTo(void.class);
        } catch (NoSuchMethodException e) {
            fail("CelestialObject should have setX method with a double argument");
        }
    }

    @Test
    void class_shouldHaveGetterAndSetterY() {
        try {
            Method getter = CelestialObject.class.getDeclaredMethod("getY");
            assertThat(Modifier.isPublic(getter.getModifiers()))
                    .withFailMessage("getY method should be public")
                    .isTrue();
            assertThat(getter.getReturnType())
                    .withFailMessage("getY method should return double")
                    .isEqualTo(double.class);
            assertThat(getter.getParameterTypes())
                    .withFailMessage("getY method should have no parameter")
                    .isEmpty();
        } catch (NoSuchMethodException e) {
            fail("CelestialObject should have getY method");
        }
        try {
            Method setter = CelestialObject.class.getDeclaredMethod("setY", double.class);
            assertThat(Modifier.isPublic(setter.getModifiers()))
                    .withFailMessage("setY method should be public")
                    .isTrue();
            assertThat(setter.getReturnType())
                    .withFailMessage("setY method should return nothing")
                    .isEqualTo(void.class);
        } catch (NoSuchMethodException e) {
            fail("CelestialObject should have setY method with a double argument");
        }
    }

    @Test
    void class_shouldHaveGetterAndSetterZ() {
        try {
            Method getter = CelestialObject.class.getDeclaredMethod("getZ");
            assertThat(Modifier.isPublic(getter.getModifiers()))
                    .withFailMessage("getZ method should be public")
                    .isTrue();
            assertThat(getter.getReturnType())
                    .withFailMessage("getZ method should return double")
                    .isEqualTo(double.class);
            assertThat(getter.getParameterTypes())
                    .withFailMessage("getZ method should have no parameter")
                    .isEmpty();
        } catch (NoSuchMethodException e) {
            fail("CelestialObject should have getZ method");
        }
        try {
            Method setter = CelestialObject.class.getDeclaredMethod("setZ", double.class);
            assertThat(Modifier.isPublic(setter.getModifiers()))
                    .withFailMessage("setZ method should be public")
                    .isTrue();
            assertThat(setter.getReturnType())
                    .withFailMessage("setZ method should return nothing")
                    .isEqualTo(void.class);
        } catch (NoSuchMethodException e) {
            fail("CelestialObject should have setZ method with a double argument");
        }
    }

    @Test
    void class_shouldHaveGetterAndSetterName() {
        try {
            Method getter = CelestialObject.class.getDeclaredMethod("getName");
            assertThat(Modifier.isPublic(getter.getModifiers()))
                    .withFailMessage("getName method should be public")
                    .isTrue();
            assertThat(getter.getReturnType())
                    .withFailMessage("getName method should return String")
                    .isEqualTo(String.class);
            assertThat(getter.getParameterTypes())
                    .withFailMessage("getName method should have no parameter")
                    .isEmpty();
        } catch (NoSuchMethodException e) {
            fail("CelestialObject should have getName method");
        }
        try {
            Method setter = CelestialObject.class.getDeclaredMethod("setName", String.class);
            assertThat(Modifier.isPublic(setter.getModifiers()))
                    .withFailMessage("setName method should be public")
                    .isTrue();
            assertThat(setter.getReturnType())
                    .withFailMessage("setName method should return nothing")
                    .isEqualTo(void.class);
        } catch (NoSuchMethodException e) {
            fail("CelestialObject should have setName method with a String argument");
        }
    }

    @Test
    void class_shouldHaveDistanceMethods() {
        try {
            Method getDistanceBetween = CelestialObject.class.getDeclaredMethod("getDistanceBetween", CelestialObject.class, CelestialObject.class);
            assertThat(Modifier.isPublic(getDistanceBetween.getModifiers()))
                    .withFailMessage("getDistanceBetween method should be public")
                    .isTrue();
            assertThat(Modifier.isStatic(getDistanceBetween.getModifiers()))
                    .withFailMessage("getDistanceBetween method should be static")
                    .isTrue();
            assertThat(getDistanceBetween.getReturnType())
                    .withFailMessage("getDistanceBetween method should return double")
                    .isEqualTo(double.class);
        } catch (NoSuchMethodException e) {
            fail("CelestialObject should have getDistanceBetween method with 2 CelestialObject as parameters");
        }
        try {
            Method getDistanceBetweenInKm = CelestialObject.class.getDeclaredMethod("getDistanceBetweenInKm", CelestialObject.class, CelestialObject.class);
            assertThat(Modifier.isPublic(getDistanceBetweenInKm.getModifiers()))
                    .withFailMessage("getDistanceBetweenInKm method should be public")
                    .isTrue();
            assertThat(Modifier.isStatic(getDistanceBetweenInKm.getModifiers()))
                    .withFailMessage("getDistanceBetweenInKm method should be static")
                    .isTrue();
            assertThat(getDistanceBetweenInKm.getReturnType())
                    .withFailMessage("getDistanceBetweenInKm method should return double")
                    .isEqualTo(double.class);
        } catch (NoSuchMethodException e) {
            fail("CelestialObject should have getDistanceBetweenInKm method with 2 CelestialObject as parameters");
        }
    }

    @Test
    void classStar_shouldMagnitudePropertyBePrivateAndWithCorrectType() {
        try {
            Field field = Star.class.getDeclaredField("magnitude");
            assertThat(Modifier.isPrivate(field.getModifiers()))
                    .withFailMessage("magnitude property should be private")
                    .isTrue();
            assertThat(Modifier.isFinal(field.getModifiers()))
                    .withFailMessage("magnitude property should not be final")
                    .isFalse();
            assertThat(field.getType())
                    .withFailMessage("magnitude property should be a double, but was %s", field.getType())
                    .isEqualTo(double.class);
        } catch (NoSuchFieldException e) {
            fail("Star should have a magnitude property", e);
        }
    }

    @Test
    void classStar_shouldHaveGetterAndSetterMagnitude() {
        try {
            Method getter = Star.class.getDeclaredMethod("getMagnitude");
            assertThat(Modifier.isPublic(getter.getModifiers()))
                    .withFailMessage("getMagnitude method should be public")
                    .isTrue();
            assertThat(getter.getReturnType())
                    .withFailMessage("getMagnitude method should return double")
                    .isEqualTo(double.class);
            assertThat(getter.getParameterTypes())
                    .withFailMessage("getMagnitude method should have no parameter")
                    .isEmpty();
        } catch (NoSuchMethodException e) {
            fail("Star should have getMagnitude method");
        }
        try {
            Method setter = Star.class.getDeclaredMethod("setMagnitude", double.class);
            assertThat(Modifier.isPublic(setter.getModifiers()))
                    .withFailMessage("setMagnitude method should be public")
                    .isTrue();
            assertThat(setter.getReturnType())
                    .withFailMessage("setMagnitude method should return nothing")
                    .isEqualTo(void.class);
        } catch (NoSuchMethodException e) {
            fail("Star should have setMagnitude method with a double argument");
        }
    }

    @Test
    void object_constructor() {

        try {
            Constructor<Star> constructor = Star.class.getDeclaredConstructor();
            Constructor<Star> constructorFull = Star.class.getDeclaredConstructor(String.class, double.class, double.class, double.class, double.class);
            Star star = constructor.newInstance();
            Star starFull = constructorFull.newInstance("Vega", 12.389, 48398.12, -123.843, 13.32);

            assertThat(star.getMagnitude())
                    .withFailMessage("magnitude should be %f but was %f", 0.0, star.getMagnitude())
                    .isEqualTo(0.0);
            assertThat(star.getX())
                    .withFailMessage("x should be %f but was %f", 0.0, star.getX())
                    .isEqualTo(0.0);
            assertThat(star.getY())
                    .withFailMessage("y should be %f but was %f", 0.0, star.getY())
                    .isEqualTo(0.0);
            assertThat(star.getZ())
                    .withFailMessage("z should be %f but was %f", 0.0, star.getZ())
                    .isEqualTo(0.0);
            assertThat(star.getName())
                    .withFailMessage("name should be `Soleil` but was `%s`", star.getName())
                    .isEqualTo("Soleil");

            assertThat(starFull.getMagnitude())
                    .withFailMessage("magnitude should be %f but was %f", 13.32, star.getMagnitude())
                    .isEqualTo(13.32);
            assertThat(starFull.getX())
                    .withFailMessage("x should be %f but was %f", 12.389, star.getX())
                    .isEqualTo(12.389);
            assertThat(starFull.getY())
                    .withFailMessage("y should be %f but was %f", 48398.12, star.getY())
                    .isEqualTo(48398.12);
            assertThat(starFull.getZ())
                    .withFailMessage("z should be %f but was %f", -123.843, star.getZ())
                    .isEqualTo(-123.843);
            assertThat(starFull.getName())
                    .withFailMessage("name should be `Vega` but was `%s`", star.getName())
                    .isEqualTo("Vega");

        } catch (IllegalAccessException | NoSuchMethodException | InstantiationException |
                 InvocationTargetException e) {
            fail("Star is not correctly defined", e);
        }
    }

    @Test
    void object_equalsHashCode() {

        try {
            Constructor<Star> constructor = Star.class.getDeclaredConstructor(String.class, double.class, double.class, double.class, double.class);
            Constructor<CelestialObject> constructorCO = CelestialObject.class.getDeclaredConstructor(String.class, double.class, double.class, double.class);
            CelestialObject celestialObject = constructorCO.newInstance("Altair", 12.45, 328.8437, -328.3923);
            Star star1 = constructor.newInstance("Altair", 12.45, 328.8437, -328.3923, 13.92);
            Star star2 = constructor.newInstance("Altair", 12.45, 328.8437, -328.3923, 13.92);
            Star star3 = constructor.newInstance("Altair", 12.46, 328.8437, -328.3923, 13.92);
            Star star4 = constructor.newInstance("Altair", 12.45, 328.844, -328.3923, 13.92);
            Star star5 = constructor.newInstance("Altair", 12.45, 328.8437, -328.4, 13.92);
            Star star6 = constructor.newInstance("Deneb", 12.45, 328.8437, -328.3923, 13.92);
            Star star7 = constructor.newInstance("Altair", 12.45, 328.8437, -328.3923, 13.9);

            assertThat(star1.equals(star1))
                    .withFailMessage("The same object should be equals with self")
                    .isTrue();
            assertThat(star1.equals(star2))
                    .withFailMessage("Two identical objects should be equals")
                    .isTrue();
            assertThat(star1.hashCode() == star2.hashCode())
                    .withFailMessage("Two identical objects should have same hashCodes")
                    .isTrue();
            assertThat(star1.equals(null))
                    .withFailMessage("Object should not be equal to null")
                    .isFalse();
            assertThat(star1.equals(star3))
                    .withFailMessage("Two similar objects with X different should not be equals")
                    .isFalse();
            assertThat(star1.hashCode() == star3.hashCode())
                    .withFailMessage("Two similar objects with X different should have different hashCode")
                    .isFalse();
            assertThat(star1.equals(star4))
                    .withFailMessage("Two similar objects with Y different should not be equals")
                    .isFalse();
            assertThat(star1.hashCode() == star4.hashCode())
                    .withFailMessage("Two similar objects with Y different should have different hashCode")
                    .isFalse();
            assertThat(star1.equals(star5))
                    .withFailMessage("Two similar objects with Z different should not be equals")
                    .isFalse();
            assertThat(star1.hashCode() == star5.hashCode())
                    .withFailMessage("Two similar objects with Z different should have different hashCode")
                    .isFalse();
            assertThat(star1.equals(star6))
                    .withFailMessage("Two similar objects with name different should not be equals")
                    .isFalse();
            assertThat(star1.hashCode() == star6.hashCode())
                    .withFailMessage("Two similar objects with name different should have different hashCode")
                    .isFalse();
            assertThat(star1.equals(star7))
                    .withFailMessage("Two similar objects with magnitude different should not be equals")
                    .isFalse();
            assertThat(star1.hashCode() == star7.hashCode())
                    .withFailMessage("Two similar objects with magnitude different should have different hashCode")
                    .isFalse();
            assertThat(star1.equals(celestialObject))
                    .withFailMessage("Similar Star and CelestialObject should not be equals")
                    .isFalse();
            assertThat(star1.hashCode() == celestialObject.hashCode())
                    .withFailMessage("Similar Star and CelestialObject should have different hashCode")
                    .isFalse();
        } catch (IllegalAccessException | NoSuchMethodException | InstantiationException |
                 InvocationTargetException e) {
            fail("Star is not correctly defined", e);
        }
    }

    @Test
    void object_toString() {

        try {
            Constructor<Star> constructor = Star.class.getDeclaredConstructor(String.class, double.class, double.class, double.class, double.class);
            Constructor<CelestialObject> constructorCO = CelestialObject.class.getDeclaredConstructor(String.class, double.class, double.class, double.class);
            CelestialObject celestialObject = constructorCO.newInstance("Altair", 12.45, 328.8437, -328.3923);
            Star star = constructor.newInstance("Altair", 12.45, 328.8437, -328.3923, 13.92);

            assertThat(celestialObject.toString())
                    .withFailMessage("toString of celestialObject is not correct : `%s`", celestialObject.toString())
                    .isEqualTo("Altair is positioned at (12.450, 328.844, -328.392)");
            assertThat(star.toString())
                    .withFailMessage("toString of Star is not correct : `%s`", star.toString())
                    .isEqualTo("Altair shines at the 13.920 magnitude");

        } catch (IllegalAccessException | NoSuchMethodException | InstantiationException |
                 InvocationTargetException e) {
            fail("Star is not correctly defined", e);
        }
    }
}