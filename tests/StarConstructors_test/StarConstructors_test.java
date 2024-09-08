
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Fail.fail;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(StopAfterFailureExtension.class)
class StarConstructorsTest {

    @Test
    void class_shouldBePublic() {
        assertThat(CelestialObject.class)
                .withFailMessage("CelestialObject should be public")
                .isPublic();
    }

    @Test
    void class_shouldXPropertyBePublicAndWithCorrectType() {
        try {
            Field field = CelestialObject.class.getDeclaredField("x");
            assertThat(Modifier.isPublic(field.getModifiers()))
                    .withFailMessage("x property should be public")
                    .isTrue();
            assertThat(Modifier.isFinal(field.getModifiers()))
                    .withFailMessage("x property should not be final")
                    .isFalse();
            assertThat(field.getType())
                    .withFailMessage("x property should be a double, but was %s", field.getType())
                    .isEqualTo(double.class);
        } catch (NoSuchFieldException e) {
            fail("CelestialObject should have a x property");
        }
    }

    @Test
    void class_shouldYPropertyBePublicAndWithCorrectType() {
        try {
            Field field = CelestialObject.class.getDeclaredField("y");
            assertThat(Modifier.isPublic(field.getModifiers()))
                    .withFailMessage("y property should be public")
                    .isTrue();
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
    void class_shouldZPropertyBePublicAndWithCorrectType() {
        try {
            Field field = CelestialObject.class.getDeclaredField("z");
            assertThat(Modifier.isPublic(field.getModifiers()))
                    .withFailMessage("z property should be public")
                    .isTrue();
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
    void class_shouldNamePropertyBePublicAndWithCorrectType() {
        try {
            Field field = CelestialObject.class.getDeclaredField("name");
            assertThat(Modifier.isPublic(field.getModifiers()))
                    .withFailMessage("name property should be public")
                    .isTrue();
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
    void object_shouldBeCorrectlyInitializedWithDefaultConstructor() {

        try {
            Constructor<CelestialObject> constructor = CelestialObject.class.getDeclaredConstructor();
            CelestialObject celestialObject = constructor.newInstance();

            Field fieldX = CelestialObject.class.getDeclaredField("x");
            Field fieldY = CelestialObject.class.getDeclaredField("y");
            Field fieldZ = CelestialObject.class.getDeclaredField("z");
            Field fieldName = CelestialObject.class.getDeclaredField("name");

            assertThat(fieldX.get(celestialObject))
                    .withFailMessage("x property should be initialized at 0.0")
                    .isEqualTo(0.0);
            assertThat(fieldY.get(celestialObject))
                    .withFailMessage("y property should be initialized at 0.0")
                    .isEqualTo(0.0);
            assertThat(fieldZ.get(celestialObject))
                    .withFailMessage("z property should be initialized at 0.0")
                    .isEqualTo(0.0);
            assertThat(fieldName.get(celestialObject))
                    .withFailMessage("name property should be initialized at Soleil")
                    .isEqualTo("Soleil");

        } catch (NoSuchFieldException | IllegalAccessException | NoSuchMethodException | InstantiationException |
                 InvocationTargetException e) {
            fail("CelestialObject is not correctly defined", e);
        }
    }

    @Test
    void object_shouldBeCorrectlyInitializedWithFullParametersConstructor() {

        try {
            Constructor<CelestialObject> constructor = CelestialObject.class.getDeclaredConstructor(String.class, double.class, double.class, double.class);
            CelestialObject celestialObject = constructor.newInstance("Deneb", 14857.032, 32874.3283, 93802.231);

            Field fieldX = CelestialObject.class.getDeclaredField("x");
            Field fieldY = CelestialObject.class.getDeclaredField("y");
            Field fieldZ = CelestialObject.class.getDeclaredField("z");
            Field fieldName = CelestialObject.class.getDeclaredField("name");

            assertThat(fieldX.get(celestialObject))
                    .withFailMessage("x property should be initialized at 0.0")
                    .isEqualTo(14857.032);
            assertThat(fieldY.get(celestialObject))
                    .withFailMessage("y property should be initialized at 0.0")
                    .isEqualTo(32874.3283);
            assertThat(fieldZ.get(celestialObject))
                    .withFailMessage("z property should be initialized at 0.0")
                    .isEqualTo(93802.231);
            assertThat(fieldName.get(celestialObject))
                    .withFailMessage("name property should be initialized at Deneb")
                    .isEqualTo("Deneb");

        } catch (NoSuchFieldException | IllegalAccessException | NoSuchMethodException | InstantiationException |
                 InvocationTargetException e) {
            fail("CelestialObject is not correctly defined", e);
        }
    }
}