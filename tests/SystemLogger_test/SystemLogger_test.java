import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(StopAfterFailureExtension.class)
class SystemLoggerTest {

    String logPrefix = "System Log: ";
    @Test
    void logMessage() {
        String msg = "Message to log";
        String res = SystemLog.systemLog(msg);

        assertThat(res).isEqualTo(logPrefix + msg);
    }
    
    @Test
    void logEmptyMessage() {
        String msg = "";
        String res = SystemLog.systemLog(msg);

        assertThat(res).isEqualTo(logPrefix + msg);
    }
}