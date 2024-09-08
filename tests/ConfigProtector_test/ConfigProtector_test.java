import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(StopAfterFailureExtension.class)
class ConfigProtectorTest {
    private ConfigProtector protector;

    @BeforeEach
    void setUp() {
        protector = new ConfigProtector();
    }

    @Test
    void testHideSensitiveData_singleSensitiveKey() {
        String configFile = "username=admin\npassword=secret\nhost=localhost\n";
        List<String> sensitiveKeys = Arrays.asList("password");
        String expected = "username=admin\npassword=******\nhost=localhost\n";
        assertThat(protector.hideSensitiveData(configFile, sensitiveKeys))
                .withFailMessage("Expected protected config to be:\n%s\nbut got:\n%s", expected, protector.hideSensitiveData(configFile, sensitiveKeys))
                .isEqualTo(expected);
    }

    @Test
    void testHideSensitiveData_multipleSensitiveKeys() {
        String configFile = "apiKey=12345\napi-Secret=abcdef\nendpoint=https://api.example.com\n";
        List<String> sensitiveKeys = Arrays.asList("apiKey", "api-Secret");
        String expected = "apiKey=*****\napi-Secret=******\nendpoint=https://api.example.com\n";
        assertThat(protector.hideSensitiveData(configFile, sensitiveKeys))
                .withFailMessage("Expected protected config to be:\n%s\nbut got:\n%s", expected, protector.hideSensitiveData(configFile, sensitiveKeys))
                .isEqualTo(expected);
    }

    @Test
    void testHideSensitiveData_allSensitiveKeys() {
        String configFile = "username=user\npassword=pass\n";
        List<String> sensitiveKeys = Arrays.asList("username", "password");
        String expected = "username=****\npassword=****\n";
        assertThat(protector.hideSensitiveData(configFile, sensitiveKeys))
                .withFailMessage("Expected protected config to be:\n%s\nbut got:\n%s", expected, protector.hideSensitiveData(configFile, sensitiveKeys))
                .isEqualTo(expected);
    }

    @Test
    void testHideSensitiveData_noSensitiveKeys() {
        String configFile = "username=admin\npassword=secret\nhost=localhost\n";
        List<String> sensitiveKeys = Arrays.asList();
        String expected = "username=admin\npassword=secret\nhost=localhost\n";
        assertThat(protector.hideSensitiveData(configFile, sensitiveKeys))
                .withFailMessage("Expected protected config to be:\n%s\nbut got:\n%s", expected, protector.hideSensitiveData(configFile, sensitiveKeys))
                .isEqualTo(expected);
    }

    @Test
    void testHideSensitiveData_keyNotPresent() {
        String configFile = "username=admin\npassword=secret\nhost=localhost\n";
        List<String> sensitiveKeys = Arrays.asList("apiKey");
        String expected = "username=admin\npassword=secret\nhost=localhost\n";
        assertThat(protector.hideSensitiveData(configFile, sensitiveKeys))
                .withFailMessage("Expected protected config to be:\n%s\nbut got:\n%s", expected, protector.hideSensitiveData(configFile, sensitiveKeys))
                .isEqualTo(expected);
    }

    @Test
    void testHideSensitiveData_whitespaces() {
        String configFile = "username=user name\npassword=this is password\nhost name=localhost\n";
        List<String> sensitiveKeys = Arrays.asList("host name", "username");
        String expected = "username=*********\npassword=this is password\nhost name=*********\n";
        assertThat(protector.hideSensitiveData(configFile, sensitiveKeys))
                .withFailMessage("Expected protected config to be:\n%s\nbut got:\n%s", expected, protector.hideSensitiveData(configFile, sensitiveKeys))
                .isEqualTo(expected);
    }

    @Test
    void testHideSensitiveData_repeatedKeys() {
        String configFile = "username=firstName\nusername=secondName\npassword=pass\n";
        List<String> sensitiveKeys = Arrays.asList("username");
        String expected = "username=*********\nusername=**********\npassword=pass\n";
        assertThat(protector.hideSensitiveData(configFile, sensitiveKeys))
                .withFailMessage("Expected protected config to be:\n%s\nbut got:\n%s", expected, protector.hideSensitiveData(configFile, sensitiveKeys))
                .isEqualTo(expected);
    }

    @Test
    void testHideSensitiveData_caseSensitive() {
        String configFile = "userName=admin\nusername=Admin\nhost=localhost\n";
        List<String> sensitiveKeys = Arrays.asList("username");
        String expected = "userName=admin\nusername=*****\nhost=localhost\n";
        assertThat(protector.hideSensitiveData(configFile, sensitiveKeys))
                .withFailMessage("Expected protected config to be:\n%s\nbut got:\n%s", expected, protector.hideSensitiveData(configFile, sensitiveKeys))
                .isEqualTo(expected);
    }

    @Test
    void testHideSensitiveData_emptyConfiguration() {
        String configFile = "";
        List<String> sensitiveKeys = Arrays.asList("password");
        String expected = "";
        assertThat(protector.hideSensitiveData(configFile, sensitiveKeys))
                .withFailMessage("Expected protected config to be:\n%s\nbut got:\n%s", expected, protector.hideSensitiveData(configFile, sensitiveKeys))
                .isEqualTo(expected);
    }
}
