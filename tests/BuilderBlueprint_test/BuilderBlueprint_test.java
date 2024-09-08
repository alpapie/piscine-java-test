import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(StopAfterFailureExtension.class)
class BuilderBlueprintTest {
    private RegexDirector director;
    private RegexBuilder builder;

    @BeforeEach
    void setUp() {
        director = new RegexDirector();
        builder = new ConcreteRegexBuilder();
    }

    @Test
    void testConstructedPattern() {
        director.setBuilder(builder);
        Regex regex = director.construct();

        String expectedPattern = "Hello\\s\\w.";
        assertThat(regex.getPattern())
                .withFailMessage("Expected pattern to be %s but got %s", expectedPattern, regex.getPattern())
                .isEqualTo(expectedPattern);
    }

    @Test
    void testBuildLiteral() {
        builder.buildLiteral("Test");
        Regex regex = builder.getResult();

        String expectedPattern = "Test";
        assertThat(regex.getPattern())
                .withFailMessage("Expected pattern to be %s but got %s", expectedPattern, regex.getPattern())
                .isEqualTo(expectedPattern);
    }

    @Test
    void testBuildAnyCharacter() {
        builder.buildAnyCharacter();
        Regex regex = builder.getResult();

        String expectedPattern = ".";
        assertThat(regex.getPattern())
                .withFailMessage("Expected pattern to be %s but got %s", expectedPattern, regex.getPattern())
                .isEqualTo(expectedPattern);
    }

    @Test
    void testBuildDigit() {
        builder.buildDigit();
        Regex regex = builder.getResult();

        String expectedPattern = "\\d";
        assertThat(regex.getPattern())
                .withFailMessage("Expected pattern to be %s but got %s", expectedPattern, regex.getPattern())
                .isEqualTo(expectedPattern);
    }

    @Test
    void testBuildWhitespace() {
        builder.buildWhitespace();
        Regex regex = builder.getResult();

        String expectedPattern = "\\s";
        assertThat(regex.getPattern())
                .withFailMessage("Expected pattern to be %s but got %s", expectedPattern, regex.getPattern())
                .isEqualTo(expectedPattern);
    }

    @Test
    void testBuildWordCharacter() {
        builder.buildWordCharacter();
        Regex regex = builder.getResult();

        String expectedPattern = "\\w";
        assertThat(regex.getPattern())
                .withFailMessage("Expected pattern to be %s but got %s", expectedPattern, regex.getPattern())
                .isEqualTo(expectedPattern);
    }

    @Test
    void testBuilderInstance_isNotNull() {
        RegexBuilder builder = new ConcreteRegexBuilder();
        assertThat(builder)
                .withFailMessage("Expected builder instance to be not null, but got null")
                .isNotNull();
    }

    @Test
    void testRegexInstance_isNotNull() {
        Regex regex = new Regex();
        assertThat(regex)
                .withFailMessage("Expected regex instance to be not null, but got null")
                .isNotNull();
    }
}
