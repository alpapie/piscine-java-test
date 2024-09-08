import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.Collections;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(StopAfterFailureExtension.class)
class MapInventoryTest {

    @Test
    void getProductPrice_shouldReturnCorrectPrice_whenProductIdExists() {
        Map<String, Integer> inventory = new HashMap<>();
        inventory.put("P001", 100);
        inventory.put("P002", 50);
        inventory.put("P003", 75);
        inventory.put("P004", 50);
        int res = MapInventory.getProductPrice(inventory, "P002");

        assertThat(res)
                .withFailMessage("Should return price %s for product ID %s, but got %s", 50, "P002", res)
                .isEqualTo(50);
    }

    @Test
    void getProductPrice_shouldReturnNegativeOne_whenProductIdDoesNotExist() {
        Map<String, Integer> inventory = new HashMap<>();
        inventory.put("P001", 100);
        inventory.put("P002", 50);
        inventory.put("P003", 75);
        inventory.put("P004", 50);
        int res = MapInventory.getProductPrice(inventory, "P006");

        assertThat(res)
                .withFailMessage("Should return -1 for non-existent product ID %s, but got %s", "P006", res)
                .isEqualTo(-1);
    }

    @Test
    void getProductIdsByPrice_shouldReturnCorrectProductIds_whenPriceExists() {
        Map<String, Integer> inventory = new HashMap<>();
        inventory.put("P001", 100);
        inventory.put("P002", 50);
        inventory.put("P003", 75);
        inventory.put("P004", 50);
        List<String> expected = List.of("P002", "P004");
        List<String> res = MapInventory.getProductIdsByPrice(inventory, 50);
        Collections.sort(res);
        assertThat(res)
                .withFailMessage("Should return product IDs %s for price %s, but got %s", expected.toString(), 50, res.toString())
                .isEqualTo(expected);
    }

    @Test
    void getProductIdsByPrice_shouldReturnEmptyList_whenPriceDoesNotExist() {
        Map<String, Integer> inventory = new HashMap<>();
        inventory.put("P001", 100);
        inventory.put("P002", 50);
        inventory.put("P003", 75);
        inventory.put("P004", 50);
        List<String> res = MapInventory.getProductIdsByPrice(inventory, 80);

        assertThat(res.isEmpty())
                .withFailMessage("Should return an empty list for non-existent price %s, but got %s", 80, res.toString())
                .isEqualTo(true);

    }
}
