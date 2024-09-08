import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(StopAfterFailureExtension.class)
class HTMLValidatorTest {
    private HTMLValidator validator;

    @BeforeEach
    void setUp() {
        validator = new HTMLValidator();
    }

    @Test
    void testValidateHTML_withValidHTML() {
        String html = "<html><body><h1>Hello, World!</h1></body></html>";
        assertThat(validator.validateHTML(html))
                .withFailMessage("Expected HTML to be valid but got invalid")
                .isTrue();
    }

    @Test
    void testValidateHTML_withMissingClosingTag() {
        String html = "<html><body><h1>Hello, World!</body></html>";
        assertThat(validator.validateHTML(html))
                .withFailMessage("Expected HTML to be invalid but got valid")
                .isFalse();
    }

    @Test
    void testValidateHTML_withIncorrectNesting() {
        String html = "<html><body><h1><div>Hello, World!</h1></div></body></html>";
        assertThat(validator.validateHTML(html))
                .withFailMessage("Expected HTML to be invalid but got valid")
                .isFalse();
    }

    @Test
    void testValidateHTML_withMultipleTags() {
        String html = "<html><body><div><p>This is a <b>bold</b> word and this is <i>italic</i>.</p></div></body></html>";
        assertThat(validator.validateHTML(html))
                .withFailMessage("Expected HTML to be valid but got invalid")
                .isTrue();
    }

    @Test
    void testValidateHTML_withSelfClosingTag() {
        String html = "<html><body><div><p>This is a <br/> word.</p></div></body></html>";
        assertThat(validator.validateHTML(html))
                .withFailMessage("Expected HTML to be valid but got invalid")
                .isTrue();
    }

    @Test
    void testValidateHTML_withEmptyString() {
        String html = "";
        assertThat(validator.validateHTML(html))
                .withFailMessage("Expected HTML to be invalid but got valid")
                .isTrue();
    }

    @Test
    void testValidateHTML_withOnlyOpeningTags() {
        String html = "<html><body><div><p>";
        assertThat(validator.validateHTML(html))
                .withFailMessage("Expected HTML to be invalid but got valid")
                .isFalse();
    }

    @Test
    void testValidateHTML_withOnlyClosingTags() {
        String html = "</p></div></body></html>";
        assertThat(validator.validateHTML(html))
                .withFailMessage("Expected HTML to be invalid but got valid")
                .isFalse();
    }
}
