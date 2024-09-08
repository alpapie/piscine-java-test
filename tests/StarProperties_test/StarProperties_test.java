
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Fail.fail;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(StopAfterFailureExtension.class)
class StarPropertiesTest {

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
    void object_shouldBeCorrectlyInitialized() {
        CelestialObject celestialObject = new CelestialObject();

        try {
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
                    .withFailMessage("name property should be initialized at null")
                    .isNull();

        } catch (NoSuchFieldException | IllegalAccessException e) {
            fail("CelestialObject is not correctly defined", e);
        }
    }

    @Test
    void object_shouldBeCorrectlyModified() {
        CelestialObject celestialObject = new CelestialObject();

        try {
            Field fieldX = CelestialObject.class.getDeclaredField("x");
            Field fieldY = CelestialObject.class.getDeclaredField("y");
            Field fieldZ = CelestialObject.class.getDeclaredField("z");
            Field fieldName = CelestialObject.class.getDeclaredField("name");

            fieldX.set(celestialObject, 14.9);
            fieldY.set(celestialObject, 98.32);
            fieldZ.set(celestialObject, -123.938);
            fieldName.set(celestialObject, "Soleil");

            assertThat(fieldX.get(celestialObject))
                    .withFailMessage("x property should be updated to 14.9")
                    .isEqualTo(14.9);
            assertThat(fieldY.get(celestialObject))
                    .withFailMessage("y property should be updated to 98.32")
                    .isEqualTo(98.32);
            assertThat(fieldZ.get(celestialObject))
                    .withFailMessage("z property should be updated to -123.938")
                    .isEqualTo(-123.938);
            assertThat(fieldName.get(celestialObject))
                    .withFailMessage("name property should be updated to Soleil")
                    .isEqualTo("Soleil");

        } catch (NoSuchFieldException | IllegalAccessException e) {
            fail("CelestialObject is not correctly defined", e);
        }
    }
}