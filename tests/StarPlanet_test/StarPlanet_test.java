
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
class StarPlanetTest {

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
    void classPlanet_shouldBePublicAndInherit() {
        assertThat(Planet.class)
                .withFailMessage("Planet should be public")
                .isPublic();

        assertThat(Planet.class.getSuperclass())
                .withFailMessage("Planet should inherits from CelestialObject")
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
    void classPlanet_shouldHaveDefaultConstructor() {
        try {
            Constructor<Planet> constructor = Planet.class.getDeclaredConstructor();
            assertThat(Modifier.isPublic(constructor.getModifiers()))
                    .withFailMessage("Default constructor should be public")
                    .isTrue();
        } catch (NoSuchMethodException e) {
            fail("Planet should have a default constructor");
        }
    }

    @Test
    void classPlanet_shouldHaveFullParameterConstructor() {
        try {
            Constructor<Planet> constructor = Planet.class.getDeclaredConstructor(String.class, double.class, double.class, double.class, Star.class);
            assertThat(Modifier.isPublic(constructor.getModifiers()))
                    .withFailMessage("Full parameters constructor should be public")
                    .isTrue();
        } catch (NoSuchMethodException e) {
            fail("Planet should have a full parameters constructor");
        }
    }

    @Test
    void classPlanet_shouldCenterStarPropertyBePrivateAndWithCorrectType() {
        try {
            Field field = Planet.class.getDeclaredField("centerStar");
            assertThat(Modifier.isPrivate(field.getModifiers()))
                    .withFailMessage("centerStar property should be private")
                    .isTrue();
            assertThat(Modifier.isFinal(field.getModifiers()))
                    .withFailMessage("centerStar property should not be final")
                    .isFalse();
            assertThat(field.getType())
                    .withFailMessage("centerStar property should be a Star, but was %s", field.getType())
                    .isEqualTo(Star.class);
        } catch (NoSuchFieldException e) {
            fail("Star should have a centerStar property", e);
        }
    }

    @Test
    void classPlanet_shouldHaveGetterAndSetterCenterStar() {
        try {
            Method getter = Planet.class.getDeclaredMethod("getCenterStar");
            assertThat(Modifier.isPublic(getter.getModifiers()))
                    .withFailMessage("getCenterStar method should be public")
                    .isTrue();
            assertThat(getter.getReturnType())
                    .withFailMessage("getCenterStar method should return Star")
                    .isEqualTo(Star.class);
            assertThat(getter.getParameterTypes())
                    .withFailMessage("getCenterStar method should have no parameter")
                    .isEmpty();
        } catch (NoSuchMethodException e) {
            fail("Planet should have getCenterStar method");
        }
        try {
            Method setter = Planet.class.getDeclaredMethod("setCenterStar", Star.class);
            assertThat(Modifier.isPublic(setter.getModifiers()))
                    .withFailMessage("setCenterStar method should be public")
                    .isTrue();
            assertThat(setter.getReturnType())
                    .withFailMessage("setCenterStar method should return nothing")
                    .isEqualTo(void.class);
        } catch (NoSuchMethodException e) {
            fail("Planet should have setCenterStar method with a Star argument");
        }
    }

    @Test
    void object_constructor() {

        try {
            Constructor<Planet> constructor = Planet.class.getDeclaredConstructor();
            Constructor<Planet> constructorFull = Planet.class.getDeclaredConstructor(String.class, double.class, double.class, double.class, Star.class);
            Constructor<Star> constructorStar = Star.class.getDeclaredConstructor(String.class, double.class, double.class, double.class, double.class);
            Star star = constructorStar.newInstance("Aldebarran", 3278.12, 4893.3289, 192.32, 329.32);
            Planet planet = constructor.newInstance();
            Planet planetFull = constructorFull.newInstance("Tatooine", 12.389, 48398.12, -123.843, star);

            assertThat(planet.getX())
                    .withFailMessage("x should be %f but was %f", 0.0, star.getX())
                    .isEqualTo(0.0);
            assertThat(planet.getY())
                    .withFailMessage("y should be %f but was %f", 0.0, star.getY())
                    .isEqualTo(0.0);
            assertThat(planet.getZ())
                    .withFailMessage("z should be %f but was %f", 0.0, star.getZ())
                    .isEqualTo(0.0);
            assertThat(planet.getName())
                    .withFailMessage("name should be `Soleil` but was `%s`", star.getName())
                    .isEqualTo("Soleil");
            assertThat(planet.getCenterStar())
                    .withFailMessage("centerStar is not correct")
                    .isEqualTo(new Star());

            assertThat(planetFull.getX())
                    .withFailMessage("x should be %f but was %f", 12.389, star.getX())
                    .isEqualTo(12.389);
            assertThat(planetFull.getY())
                    .withFailMessage("y should be %f but was %f", 48398.12, star.getY())
                    .isEqualTo(48398.12);
            assertThat(planetFull.getZ())
                    .withFailMessage("z should be %f but was %f", -123.843, star.getZ())
                    .isEqualTo(-123.843);
            assertThat(planetFull.getName())
                    .withFailMessage("name should be `Tatooine` but was `%s`", star.getName())
                    .isEqualTo("Tatooine");
            assertThat(planetFull.getCenterStar())
                    .withFailMessage("centerStar is not correct")
                    .isEqualTo(star);

        } catch (IllegalAccessException | NoSuchMethodException | InstantiationException |
                 InvocationTargetException e) {
            fail("Star is not correctly defined", e);
        }
    }

    @Test
    void object_equalsHashCode() {

        try {
            Constructor<Planet> constructor = Planet.class.getDeclaredConstructor(String.class, double.class, double.class, double.class, Star.class);
            Constructor<Star> constructorStar = Star.class.getDeclaredConstructor(String.class, double.class, double.class, double.class, double.class);
            Constructor<Star> defaultConstructorStar = Star.class.getDeclaredConstructor();
            Constructor<CelestialObject> constructorCO = CelestialObject.class.getDeclaredConstructor(String.class, double.class, double.class, double.class);
            CelestialObject celestialObject = constructorCO.newInstance("Jupiter", 12.45, 328.8437, -328.3923);
            Star star = constructorStar.newInstance("Altair", 12.45, 328.8437, -328.3923, 13.128);
            Planet planet1 = constructor.newInstance("Jupiter", 12.45, 328.8437, -328.3923, star);
            Planet planet2 = constructor.newInstance("Jupiter", 12.45, 328.8437, -328.3923, star);
            Planet planet3 = constructor.newInstance("Jupiter", 12.46, 328.8437, -328.3923, star);
            Planet planet4 = constructor.newInstance("Jupiter", 12.45, 328.844, -328.3923, star);
            Planet planet5 = constructor.newInstance("Jupiter", 12.45, 328.8437, -328.4, star);
            Planet planet6 = constructor.newInstance("Saturne", 12.45, 328.8437, -328.3923, star);
            Planet planet7 = constructor.newInstance("Jupiter", 12.45, 328.8437, -328.3923, defaultConstructorStar.newInstance());

            assertThat(planet1.equals(planet1))
                    .withFailMessage("The same object should be equals with self")
                    .isTrue();
            assertThat(planet1.equals(planet2))
                    .withFailMessage("Two identical objects should be equals")
                    .isTrue();
            assertThat(planet1.hashCode() == planet2.hashCode())
                    .withFailMessage("Two identical objects should have same hashCodes")
                    .isTrue();
            assertThat(planet1.equals(null))
                    .withFailMessage("Object should not be equal to null")
                    .isFalse();
            assertThat(planet1.equals(planet3))
                    .withFailMessage("Two similar objects with X different should not be equals")
                    .isFalse();
            assertThat(planet1.hashCode() == planet3.hashCode())
                    .withFailMessage("Two similar objects with X different should have different hashCode")
                    .isFalse();
            assertThat(planet1.equals(planet4))
                    .withFailMessage("Two similar objects with Y different should not be equals")
                    .isFalse();
            assertThat(planet1.hashCode() == planet4.hashCode())
                    .withFailMessage("Two similar objects with Y different should have different hashCode")
                    .isFalse();
            assertThat(planet1.equals(planet5))
                    .withFailMessage("Two similar objects with Z different should not be equals")
                    .isFalse();
            assertThat(planet1.hashCode() == planet5.hashCode())
                    .withFailMessage("Two similar objects with Z different should have different hashCode")
                    .isFalse();
            assertThat(planet1.equals(planet6))
                    .withFailMessage("Two similar objects with name different should not be equals")
                    .isFalse();
            assertThat(planet1.hashCode() == planet6.hashCode())
                    .withFailMessage("Two similar objects with name different should have different hashCode")
                    .isFalse();
            assertThat(planet1.equals(planet7))
                    .withFailMessage("Two similar objects with centerStar different should not be equals")
                    .isFalse();
            assertThat(planet1.hashCode() == planet7.hashCode())
                    .withFailMessage("Two similar objects with centerStar different should have different hashCode")
                    .isFalse();
            assertThat(planet1.equals(celestialObject))
                    .withFailMessage("Similar Planet and CelestialObject should not be equals")
                    .isFalse();
            assertThat(planet1.hashCode() == celestialObject.hashCode())
                    .withFailMessage("Similar Planet and CelestialObject should have different hashCode")
                    .isFalse();
        } catch (IllegalAccessException | NoSuchMethodException | InstantiationException |
                 InvocationTargetException e) {
            fail("Planet is not correctly defined", e);
        }
    }

    @Test
    void object_toString() {

        try {
            Constructor<Planet> constructor = Planet.class.getDeclaredConstructor(String.class, double.class, double.class, double.class, Star.class);
            Constructor<Star> constructorStar = Star.class.getDeclaredConstructor(String.class, double.class, double.class, double.class, double.class);
            Constructor<CelestialObject> constructorCO = CelestialObject.class.getDeclaredConstructor(String.class, double.class, double.class, double.class);
            CelestialObject celestialObject = constructorCO.newInstance("Altair", 12.45, 328.8437, -328.3923);
            Star star = constructorStar.newInstance("Altair", 12.45, 328.8437, -328.3923, 13.92);
            Planet planet = constructor.newInstance("Palaven", 43.23, -123.43, 38.239, star);

            assertThat(celestialObject.toString())
                    .withFailMessage("toString of celestialObject is not correct : `%s`", celestialObject.toString())
                    .isEqualTo("Altair is positioned at (12.450, 328.844, -328.392)");
            assertThat(planet.toString())
                    .withFailMessage("toString of Planet is not correct : `%s`", planet.toString())
                    .isEqualTo("Palaven circles around Altair at the 583.024 AU");

        } catch (IllegalAccessException | NoSuchMethodException | InstantiationException |
                 InvocationTargetException e) {
            fail("Planet is not correctly defined", e);
        }
    }
}