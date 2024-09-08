
import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.Set;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(StopAfterFailureExtension.class)
class KeepTheChangeTest {

    @Test
    void computeChange_withOnlyOneCoin() {
        Set<Integer> coins = Set.of(1);
        List<Integer> expected = List.of(1, 1, 1, 1, 1, 1, 1, 1, 1);
        int amount = 9;
        List<Integer> res = KeepTheChange.computeChange(amount, coins);

        assertThat(res)
                .withFailMessage("The change for amount %d is %s, but %s was returned", amount, expected.toString(), res.toString())
                .containsExactlyInAnyOrderElementsOf(expected);
    }

    @Test
    void computeChange_withOnlyTwoCoins() {
        Set<Integer> coins = Set.of(1, 3);
        List<Integer> expected = List.of(1, 1, 3, 3, 3, 3, 3, 3);
        int amount = 20;
        List<Integer> res = KeepTheChange.computeChange(amount, coins);

        assertThat(res)
                .withFailMessage("The change for amount %d is %s, but %s was returned", amount, expected.toString(), res.toString())
                .containsExactlyInAnyOrderElementsOf(expected);
    }

    @Test
    void computeChange_withOnlyStandardCoinsAndAmountLessThanHigherCoin() {
        Set<Integer> coins = Set.of(1, 2, 5, 10);
        List<Integer> expected = List.of(2, 5, 2);
        int amount = 9;
        List<Integer> res = KeepTheChange.computeChange(amount, coins);

        assertThat(res)
                .withFailMessage("The change for amount %d is %s, but %s was returned", amount, expected.toString(), res.toString())
                .containsExactlyInAnyOrderElementsOf(expected);
    }

    @Test
    void computeChange_withOnlyStandardCoinsAndRandomAmount() {
        Set<Integer> coins = Set.of(1, 2, 5, 10);

        int amount = new Random().nextInt(500);
        List<Integer> expected = computeChange(amount, coins);
        List<Integer> res = KeepTheChange.computeChange(amount, coins);

        assertThat(res)
                .withFailMessage("The change for amount %d is %s, but %s was returned", amount, expected.toString(), res.toString())
                .containsExactlyInAnyOrderElementsOf(expected);
    }

    private static List<Integer> computeChange(int amount, Set<Integer> coins) {
        List<Integer> list = new ArrayList<>();

        for (Integer coin : coins.stream().sorted(Comparator.reverseOrder()).toList()) {
            while (amount - coin >= 0) {
                list.add(coin);
                amount -= coin;
            }
        }

        return list;
    }

}