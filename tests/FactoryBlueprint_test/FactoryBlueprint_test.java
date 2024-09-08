import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(StopAfterFailureExtension.class)
class FactoryBlueprintTest {

    @Test
    void testCreateProductA() {
        Factory factory = new Factory();
        Product product = factory.createProduct("A");

        assertThat(product)
                .withFailMessage("Expected product to be instance of ConcreteProductA")
                .isInstanceOf(ConcreteProductA.class);

        assertThat(product)
                .isNotNull();

        // Capture the output of showDetails
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        product.showDetails();
        assertThat(outContent.toString().trim())
                .withFailMessage("Expected showDetails to output 'This is ConcreteProductA.'")
                .isEqualTo("This is ConcreteProductA.");

        // Reset the System.out
        System.setOut(System.out);
    }

    @Test
    void testCreateProductB() {
        Factory factory = new Factory();
        Product product = factory.createProduct("B");

        assertThat(product)
                .withFailMessage("Expected product to be instance of ConcreteProductB")
                .isInstanceOf(ConcreteProductB.class);

        assertThat(product)
                .isNotNull();

        // Capture the output of showDetails
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        product.showDetails();
        assertThat(outContent.toString().trim())
                .withFailMessage("Expected showDetails to output 'This is ConcreteProductB.'")
                .isEqualTo("This is ConcreteProductB.");

        // Reset the System.out
        System.setOut(System.out);
    }

    @Test
    void testCreateInvalidProduct() {
        Factory factory = new Factory();
        Product product = factory.createProduct("C");

        assertThat(product)
                .withFailMessage("Expected product to be null for invalid type")
                .isNull();
    }

    @Test
    void testFactoryHandlesNullType() {
        Factory factory = new Factory();
        Product product = factory.createProduct(null);

        assertThat(product)
                .withFailMessage("Expected product to be null for null type")
                .isNull();
    }
}
