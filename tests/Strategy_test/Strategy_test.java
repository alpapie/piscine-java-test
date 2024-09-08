import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(StopAfterFailureExtension.class)
class StrategyTest {

    @Test
    void checkClass() {
        var operationStrategyClass = OperationStrategy.class;
        assertThat(operationStrategyClass)
                .withFailMessage("OperationStrategy should be an interface")
                .isInterface();
        var addStrategyClass = AddStrategy.class;
        assertThat(addStrategyClass.getInterfaces())
                .withFailMessage("AddStrategy should implement OperationStrategy")
                .containsExactly(OperationStrategy.class);
        var maxStrategyClass = MaxStrategy.class;
        assertThat(maxStrategyClass.getInterfaces())
                .withFailMessage("MaxStrategy should implement OperationStrategy")
                .containsExactly(OperationStrategy.class);
        var concatStrategyClass = ConcatStrategy.class;
        assertThat(concatStrategyClass.getInterfaces())
                .withFailMessage("ConcatStrategy should implement OperationStrategy")
                .containsExactly(OperationStrategy.class);
    }

    @Test
    void strategy() {
        Context context = new Context();
        int res = context.execute(324, 38274);
        assertThat(res)
                .withFailMessage("The result of default strategy should be 38598, but was %d", res)
                .isEqualTo(38598);

        context.changeStrategy(new MaxStrategy());
        res = context.execute(438573, 1234);
        assertThat(res)
                .withFailMessage("The result of max strategy should be 438573, but was %d", res)
                .isEqualTo(438573);

        context.changeStrategy(new ConcatStrategy());
        res = context.execute(4439, 23);
        assertThat(res)
                .withFailMessage("The result of concat strategy should be 443923, but was %d", res)
                .isEqualTo(443923);

        context.changeStrategy(new AddStrategy());
        res = context.execute(12321, 433);
        assertThat(res)
                .withFailMessage("The result of add strategy should be 12754, but was %d", res)
                .isEqualTo(12754);
    }

}