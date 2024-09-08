
import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(StopAfterFailureExtension.class)
class WeddingTest {

    @Test
    void createCouple_sameSize() {
        Set<String> tintin = Set.of("Tintin", "Milou", "Haddock", "Tournesol");
        Set<String> asterix = Set.of("Astérix", "Obélix", "Panoramix", "Idéfix");
        Map<String, String> res = Wedding.createCouple(tintin, asterix);

        assertThat(res.keySet())
                .withFailMessage("The first members of the couple must be %s, but were %s", tintin.toString(), res.keySet().toString())
                .containsExactlyInAnyOrderElementsOf(tintin);
        assertThat(res.values())
                .withFailMessage("The second members of the couple must be %s, but were %s", asterix.toString(), res.keySet().toString())
                .containsExactlyInAnyOrderElementsOf(asterix);
    }

    @Test
    void createCouple_firstHasMoreMembers() {
        Set<String> onePiece = Set.of("Luffy", "Zorro", "Sanji", "Nami", "Usopp");
        Set<String> naruto = Set.of("Naruto", "Sasuke", "Sakura");
        Map<String, String> res = Wedding.createCouple(onePiece, naruto);

        assertThat(res.keySet().size())
                .withFailMessage("The first members must contains 3 elements but were %d", res.keySet().size())
                .isEqualTo(3);
        assertThat(res.keySet())
                .withFailMessage("The first members of the couple must be part of %s, but were %s", onePiece.toString(), res.keySet().toString())
                .containsAnyElementsOf(onePiece);

        assertThat(res.values())
                .withFailMessage("The second members of the couple must be %s, but were %s", naruto.toString(), res.keySet().toString())
                .containsExactlyInAnyOrderElementsOf(naruto);
    }

    @Test
    void createCouple_secondHasMoreMembers() {
        Set<String> massEffect = Set.of("Sheppard", "Garrus");
        Set<String> ff = Set.of("Cloud", "Tifa", "Aeris", "Cid", "Sephiroth");
        Map<String, String> res = Wedding.createCouple(massEffect, ff);
        assertThat(res.keySet())
                .withFailMessage("The first members of the couple must be %s, but were %s", massEffect.toString(), res.keySet().toString())
                .containsExactlyInAnyOrderElementsOf(massEffect);

        assertThat(res.values().size())
                .withFailMessage("The second members must contains 2 elements but were %d", res.values().size())
                .isEqualTo(2);

        assertThat(new HashSet<>(res.values()))
                .withFailMessage("The second members of the couple must be elements of %s, but were %s", ff.toString(), res.values().toString())
                .containsAnyElementsOf(ff);
    }

    @Test
    void createCouple_withEmtpyList() {
        Set<String> ff = Set.of("Cloud", "Tifa", "Aeris", "Cid", "Sephiroth");
        Map<String, String> res = Wedding.createCouple(Set.of(), ff);

        assertThat(res)
                .withFailMessage("The wedding must be empty when a list is empty, but was not")
                .isEmpty();
    }
}