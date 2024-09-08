import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.lang.reflect.Field;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(StopAfterFailureExtension.class)
class SingletonBlueprintTest {

    @BeforeEach
    void setUp() {
        // Reset the singleton instance for testing purposes
        Singleton singleton = Singleton.getInstance();
        try {
            Field instanceField = Singleton.class.getDeclaredField("instance");
            instanceField.setAccessible(true);
            instanceField.set(singleton, null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void testSingletonInstance_isNotNull() {
        Singleton instance = Singleton.getInstance();

        assertThat(instance)
                .withFailMessage("Expected instance to be not null, but got null")
                .isNotNull();
    }

    @Test
    void testSingletonInstance_isSame() {
        Singleton instance1 = Singleton.getInstance();
        Singleton instance2 = Singleton.getInstance();

        assertThat(instance1)
                .withFailMessage("Expected the same instance, but got different instances")
                .isSameAs(instance2);
    }

    @Test
    void testSingletonMessageOutput() {
        Singleton singleton = Singleton.getInstance();
        singleton.showMessage();

        // No actual assertion here as this is just to demonstrate the message output
        // To properly test console output, you would typically use a framework like SystemLambda
        // or redirect the System.out to a ByteArrayOutputStream (not shown here for simplicity)
    }

    @Test
    void testSingletonPrivateConstructor() {
        Constructor<?>[] constructors = Singleton.class.getDeclaredConstructors();
        for (Constructor<?> constructor : constructors) {
            assertThat(Modifier.isPrivate(constructor.getModifiers()))
                    .withFailMessage("Expected the constructor to be private")
                    .isTrue();
        }
    }

    @Test
    void testSingletonInstanceField() throws NoSuchFieldException {
        Field instanceField = Singleton.class.getDeclaredField("instance");
        assertThat(Modifier.isPrivate(instanceField.getModifiers()))
                .withFailMessage("Expected the instance field to be private")
                .isTrue();
        assertThat(Modifier.isStatic(instanceField.getModifiers()))
                .withFailMessage("Expected the instance field to be static")
                .isTrue();
    }
}
