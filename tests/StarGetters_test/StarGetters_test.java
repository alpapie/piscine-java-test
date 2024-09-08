
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
class StarGettersTest {

    @Test
    void class_shouldBePublic() {
        assertThat(CelestialObject.class)
                .withFailMessage("CelestialObject should be public")
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
    void object_shouldReturnValueWithGetter() {

        try {
            Constructor<CelestialObject> constructor = CelestialObject.class.getDeclaredConstructor();
            CelestialObject celestialObject = constructor.newInstance();

            Method getterX = CelestialObject.class.getDeclaredMethod("getX");
            Method getterY = CelestialObject.class.getDeclaredMethod("getY");
            Method getterZ = CelestialObject.class.getDeclaredMethod("getZ");
            Method getterName = CelestialObject.class.getDeclaredMethod("getName");

            assertThat(getterX.invoke(celestialObject))
                    .withFailMessage("x property should be initialized at 0.0")
                    .isEqualTo(0.0);
            assertThat(getterY.invoke(celestialObject))
                    .withFailMessage("y property should be initialized at 0.0")
                    .isEqualTo(0.0);
            assertThat(getterZ.invoke(celestialObject))
                    .withFailMessage("z property should be initialized at 0.0")
                    .isEqualTo(0.0);
            assertThat(getterName.invoke(celestialObject))
                    .withFailMessage("name property should be initialized at Soleil")
                    .isEqualTo("Soleil");

        } catch (IllegalAccessException | NoSuchMethodException | InstantiationException |
                 InvocationTargetException e) {
            fail("CelestialObject is not correctly defined", e);
        }
    }

    @Test
    void object_shouldReturnValueWithGetterAfterSettersCalled() {

        try {
            Constructor<CelestialObject> constructor = CelestialObject.class.getDeclaredConstructor();
            CelestialObject celestialObject = constructor.newInstance();

            Method getterX = CelestialObject.class.getDeclaredMethod("getX");
            Method getterY = CelestialObject.class.getDeclaredMethod("getY");
            Method getterZ = CelestialObject.class.getDeclaredMethod("getZ");
            Method getterName = CelestialObject.class.getDeclaredMethod("getName");

            Method setterX = CelestialObject.class.getDeclaredMethod("setX", double.class);
            Method setterY = CelestialObject.class.getDeclaredMethod("setY", double.class);
            Method setterZ = CelestialObject.class.getDeclaredMethod("setZ", double.class);
            Method setterName = CelestialObject.class.getDeclaredMethod("setName", String.class);

            setterX.invoke(celestialObject, 14857.032);
            setterY.invoke(celestialObject, 32874.3283);
            setterZ.invoke(celestialObject, 93802.231);
            setterName.invoke(celestialObject, "Deneb");

            assertThat(getterX.invoke(celestialObject))
                    .withFailMessage("x property should be initialized at 0.0")
                    .isEqualTo(14857.032);
            assertThat(getterY.invoke(celestialObject))
                    .withFailMessage("y property should be initialized at 0.0")
                    .isEqualTo(32874.3283);
            assertThat(getterZ.invoke(celestialObject))
                    .withFailMessage("z property should be initialized at 0.0")
                    .isEqualTo(93802.231);
            assertThat(getterName.invoke(celestialObject))
                    .withFailMessage("name property should be initialized at Deneb")
                    .isEqualTo("Deneb");

        } catch (IllegalAccessException | NoSuchMethodException | InstantiationException |
                 InvocationTargetException e) {
            fail("CelestialObject is not correctly defined", e);
        }
    }
}