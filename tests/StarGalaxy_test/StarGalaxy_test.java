
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Fail.fail;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.assertj.core.api.Assertions;
import org.assertj.core.data.Offset;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(StopAfterFailureExtension.class)
class StarGalaxyTest {

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
    void classGalaxy_shouldBePublic() {
        assertThat(Galaxy.class)
                .withFailMessage("Galaxy should be public")
                .isPublic();
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
    void classGalaxy_shouldHaveDefaultConstructor() {
        try {
            Constructor<Galaxy> constructor = Galaxy.class.getDeclaredConstructor();
            assertThat(Modifier.isPublic(constructor.getModifiers()))
                    .withFailMessage("Default constructor should be public")
                    .isTrue();
        } catch (NoSuchMethodException e) {
            fail("Galaxy should have a default constructor");
        }
    }

    @Test
    void classGalaxy_shouldCelestialObjectsPropertyBePrivateAndWithCorrectType() {
        try {
            Field field = Galaxy.class.getDeclaredField("celestialObjects");
            assertThat(Modifier.isPrivate(field.getModifiers()))
                    .withFailMessage("celestialObjects property should be private")
                    .isTrue();
            assertThat(Modifier.isFinal(field.getModifiers()))
                    .withFailMessage("celestialObjects property should not be final")
                    .isFalse();
            assertThat(field.getType())
                    .withFailMessage("celestialObjects property should be a List, but was %s", field.getType())
                    .isEqualTo(List.class);
        } catch (NoSuchFieldException e) {
            fail("Galaxy should have a celestialObjects property", e);
        }
    }

    @Test
    void classGalaxy_shouldHaveGetterAndAddCelestialObject() {
        try {
            Method getter = Galaxy.class.getDeclaredMethod("getCelestialObjects");
            assertThat(Modifier.isPublic(getter.getModifiers()))
                    .withFailMessage("getCelestialObjects method should be public")
                    .isTrue();
            assertThat(getter.getReturnType())
                    .withFailMessage("getCelestialObjects method should return List")
                    .isEqualTo(List.class);
            assertThat(getter.getParameterTypes())
                    .withFailMessage("getCelestialObjects method should have no parameter")
                    .isEmpty();
        } catch (NoSuchMethodException e) {
            fail("Galaxy should have getCelestialObjects method");
        }
        try {
            Method setter = Galaxy.class.getDeclaredMethod("addCelestialObject", CelestialObject.class);
            assertThat(Modifier.isPublic(setter.getModifiers()))
                    .withFailMessage("addCelestialObject method should be public")
                    .isTrue();
            assertThat(setter.getReturnType())
                    .withFailMessage("addCelestialObject method should return nothing")
                    .isEqualTo(void.class);
        } catch (NoSuchMethodException e) {
            fail("Galaxy should have addCelestialObject method with a CelestialObject argument");
        }
    }

    @Test
    void object_addAndGetterCelestialObject() {

        try {
            Constructor<Galaxy> constructor = Galaxy.class.getDeclaredConstructor();
            Constructor<Planet> constructorPlanet = Planet.class.getDeclaredConstructor(String.class, double.class, double.class, double.class, Star.class);
            Constructor<Star> constructorStar = Star.class.getDeclaredConstructor(String.class, double.class, double.class, double.class, double.class);
            Constructor<CelestialObject> constructorCO = CelestialObject.class.getDeclaredConstructor(String.class, double.class, double.class, double.class);

            Method addCelestialObject = Galaxy.class.getDeclaredMethod("addCelestialObject", CelestialObject.class);
            Method getCelestialObjects = Galaxy.class.getDeclaredMethod("getCelestialObjects");

            Galaxy galaxy = constructor.newInstance();
            CelestialObject halley = constructorCO.newInstance("Halley", -32.9443, 324.492, -38.12);
            Star sirius = constructorStar.newInstance("Sirius", 123.32, 143.321, 13.432, 13.312);
            Planet mars = constructorPlanet.newInstance("Mars", 17.4389, 8349.1, 8943.92, sirius);
            addCelestialObject.invoke(galaxy, halley);
            addCelestialObject.invoke(galaxy, sirius);
            addCelestialObject.invoke(galaxy, mars);

            List<CelestialObject> res = (List<CelestialObject>) getCelestialObjects.invoke(galaxy);

            assertThat(res)
                    .withFailMessage("List of celestials object should contains %s but was %s", List.of(halley, sirius, mars), res)
                    .containsExactly(halley, sirius, mars);

        } catch (IllegalAccessException | NoSuchMethodException | InstantiationException |
                 InvocationTargetException e) {
            fail("Galaxy is not correctly defined", e);
        }
    }
}