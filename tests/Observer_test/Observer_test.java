import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(StopAfterFailureExtension.class)
class ObserverTest {

    @Test
    void checkClass() {
        var numericBaseObserverClass = NumericBaseObserver.class;
        assertThat(numericBaseObserverClass)
                .withFailMessage("NumericBaseObserver should be an interface")
                .isInterface();
        var binaryBaseObserverClass = BinaryBaseObserver.class;
        assertThat(binaryBaseObserverClass.getInterfaces())
                .withFailMessage("BinaryBaseObserver should implement NumericBaseObserver")
                .containsExactly(NumericBaseObserver.class);
        var decimalBaseObserverClass = DecimalBaseObserver.class;
        assertThat(decimalBaseObserverClass.getInterfaces())
                .withFailMessage("DecimalBaseObserver should implement NumericBaseObserver")
                .containsExactly(NumericBaseObserver.class);
        var hexaBaseObserverClass = HexaBaseObserver.class;
        assertThat(hexaBaseObserverClass.getInterfaces())
                .withFailMessage("HexaBaseObserver should implement NumericBaseObserver")
                .containsExactly(NumericBaseObserver.class);
    }

    @Test
    void observer() {
        ValuePublisher valuePublisher = new ValuePublisher();

        BinaryBaseObserver binaryBaseObserver = new BinaryBaseObserver();
        DecimalBaseObserver decimalBaseObserver = new DecimalBaseObserver();
        HexaBaseObserver hexaBaseObserver = new HexaBaseObserver();
        BinaryBaseObserver binaryBaseObserver1 = new BinaryBaseObserver();

        valuePublisher.subscribe(binaryBaseObserver);
        valuePublisher.subscribe(decimalBaseObserver);
        valuePublisher.subscribe(hexaBaseObserver);

        valuePublisher.updateState(10);
        valuePublisher.updateState(8372);

        valuePublisher.unsubscribe(binaryBaseObserver);
        valuePublisher.subscribe(binaryBaseObserver1);

        valuePublisher.updateState(382736);

        assertThat(binaryBaseObserver.getEvents())
                .withFailMessage("The events of removed binary should be [1010, 10000010110100], but was %s", binaryBaseObserver.getEvents())
                .containsExactlyElementsOf(List.of("1010", "10000010110100"));
        assertThat(decimalBaseObserver.getEvents())
                .withFailMessage("The events of decimal should be [10, 8372, 382736], but was %s", decimalBaseObserver.getEvents())
                .containsExactlyElementsOf(List.of("10", "8372", "382736"));
        assertThat(hexaBaseObserver.getEvents())
                .withFailMessage("The events of hexadecimal should be [a, 20b4, 5d710], but was %s", hexaBaseObserver.getEvents())
                .containsExactlyElementsOf(List.of("a", "20b4", "5d710"));
        assertThat(binaryBaseObserver1.getEvents())
                .withFailMessage("The events of late added binary should be [1011101011100010000], but was %s", binaryBaseObserver1.getEvents())
                .containsExactlyElementsOf(List.of("1011101011100010000"));
    }

}