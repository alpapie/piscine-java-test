import static org.assertj.core.api.Assertions.assertThat;

import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(StopAfterFailureExtension.class)
class BreakdownURLTest {
    private BreakdownURL parser;

    @BeforeEach
    void setUp() {
        parser = new BreakdownURL();
    }

    @Test
    void testParseURL_withCompleteURL() {
        String url = "https://www.example.com:8080/path?name=value";
        Map<String, String> components = parser.parseURL(url);

        assertThat(components)
                .withFailMessage("Expected components to be {protocol=https, domain=www.example.com, port=8080, path=/path, query=name=value} but got %s", components)
                .containsEntry("protocol", "https")
                .containsEntry("domain", "www.example.com")
                .containsEntry("port", "8080")
                .containsEntry("path", "/path")
                .containsEntry("query", "name=value")
                .hasSize(5);  // Ensure only these 5 components are present
    }

    @Test
    void testParseURL_withoutPortAndQuery() {
        String url = "http://example.com/";
        Map<String, String> components = parser.parseURL(url);

        assertThat(components)
                .withFailMessage("Expected components to be {protocol=http, domain=example.com, path=/} but got %s", components)
                .containsEntry("protocol", "http")
                .containsEntry("domain", "example.com")
                .containsEntry("path", "/")
                .hasSize(3);  // Ensure only these 3 components are present
    }

    @Test
    void testParseURL_withoutPortAndPath() {
        String url = "https://www.example.com";
        Map<String, String> components = parser.parseURL(url);

        assertThat(components)
                .withFailMessage("Expected components to be {protocol=https, domain=www.example.com, path=/} but got %s", components)
                .containsEntry("protocol", "https")
                .containsEntry("domain", "www.example.com")
                .hasSize(2);  // Ensure only these 3 components are present
    }

    @Test
    void testParseURL_withPathOnly() {
        String url = "https://www.example.com/path";
        Map<String, String> components = parser.parseURL(url);

        assertThat(components)
                .withFailMessage("Expected components to be {protocol=https, domain=www.example.com, path=/path} but got %s", components)
                .containsEntry("protocol", "https")
                .containsEntry("domain", "www.example.com")
                .containsEntry("path", "/path")
                .hasSize(3);  // Ensure only these 3 components are present
    }

    @Test
    void testParseURL_withComplexQuery() {
        String url = "https://www.example.com:9090/path/to/resource?param1=value1&param2=value2";
        Map<String, String> components = parser.parseURL(url);

        assertThat(components)
                .withFailMessage("Expected components to be {protocol=https, domain=www.example.com, port=9090, path=/path/to/resource, query=param1=value1&param2=value2} but got %s", components)
                .containsEntry("protocol", "https")
                .containsEntry("domain", "www.example.com")
                .containsEntry("port", "9090")
                .containsEntry("path", "/path/to/resource")
                .containsEntry("query", "param1=value1&param2=value2")
                .hasSize(5);  // Ensure only these 5 components are present
    }
}
