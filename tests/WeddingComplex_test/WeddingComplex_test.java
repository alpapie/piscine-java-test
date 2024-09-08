
import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(StopAfterFailureExtension.class)
class WeddingComplexTest {

    @Test
    void createBestCouple_onlyTwoCouples() {
        Map<String, List<String>> men = Map.of("Naruto", List.of("Sakura", "Hinata"), "Sasuke",
                List.of("Sakura", "Hinata"));
        Map<String, List<String>> women = Map.of("Sakura", List.of("Sasuke", "Naruto"), "Hinata",
                List.of("Naruto", "Sasuke"));
        Map<String, String> res = WeddingComplex.createBestCouple(men, women);

        assertThat(res.keySet())
                .withFailMessage("First elements should be of %s, but was %s", men.keySet().toString(), res.keySet().toString())
                .containsExactlyInAnyOrderElementsOf(men.keySet());
        assertThat(res.values())
                .withFailMessage("Second elements should be of %s, but was %s", women.keySet().toString(), res.values().toString())
                .containsExactlyInAnyOrderElementsOf(women.keySet());

        for (Entry<String, String> couple : res.entrySet()) {
            String man = couple.getKey();
            String woman = couple.getValue();
            int indexMan = women.get(woman).indexOf(man);

            for (int i = 0; i < indexMan; i++) {
                String candidateMan = women.get(woman).get(i);
                String womanOfCandidateMan = res.get(candidateMan);
                int indexOfWomanInCandidateMan = men.get(candidateMan).indexOf(woman);
                int indexOfWomanOfCandidateMan = men.get(candidateMan).indexOf(womanOfCandidateMan);

                assertThat(indexOfWomanInCandidateMan)
                        .withFailMessage("%s and %s prefer to be together than to be with %s and %s", woman, candidateMan, man, womanOfCandidateMan)
                        .isGreaterThan(indexOfWomanOfCandidateMan);
            }
        }
    }

    @Test
    void createBestCouple_threeCouples() {
        Map<String, List<String>> men = Map.of("Rachel", List.of("Joey", "Chandler", "Ross"), "Monica", List.of("Ross", "Joey", "Chandler"), "Phoebe", List.of("Chandler", "Ross", "Joey"));
        Map<String, List<String>> women = Map.of("Chandler", List.of("Monica", "Rachel", "Phoebe"), "Joey", List.of("Phoebe", "Monica", "Rachel"), "Ross", List.of("Rachel", "Phoebe", "Monica"));
        Map<String, String> res = WeddingComplex.createBestCouple(men, women);

        assertThat(res.keySet())
                .withFailMessage("First elements should be of %s, but was %s", men.keySet().toString(), res.keySet().toString())
                .containsExactlyInAnyOrderElementsOf(men.keySet());
        assertThat(res.values())
                .withFailMessage("Second elements should be of %s, but was %s", women.keySet().toString(), res.values().toString())
                .containsExactlyInAnyOrderElementsOf(women.keySet());

        for (Entry<String, String> couple : res.entrySet()) {
            String man = couple.getKey();
            String woman = couple.getValue();
            int indexMan = women.get(woman).indexOf(man);

            for (int i = 0; i < indexMan; i++) {
                String candidateMan = women.get(woman).get(i);
                String womanOfCandidateMan = res.get(candidateMan);
                int indexOfWomanInCandidateMan = men.get(candidateMan).indexOf(woman);
                int indexOfWomanOfCandidateMan = men.get(candidateMan).indexOf(womanOfCandidateMan);

                assertThat(indexOfWomanInCandidateMan)
                        .withFailMessage("%s and %s prefer to be together than to be with %s and %s", woman, candidateMan, man, womanOfCandidateMan)
                        .isGreaterThan(indexOfWomanOfCandidateMan);
            }
        }
    }

    @Test
    void createBestCouple_fiveCouples() {
        Map<String, List<String>> men = Map.of(
                "Alice", List.of("Maths", "Littérature", "Physique", "Economie", "Histoire"),
                "Bob", List.of("Littérature", "Economie", "Physique", "Maths", "Histoire"),
                "Charlie", List.of("Physique", "Littérature", "Economie", "Histoire", "Maths"),
                "Daphnee", List.of("Littérature", "Histoire", "Physique", "Economie", "Maths"),
                "Emily", List.of("Physique", "Maths", "Economie", "Histoire", "Littérature"));
        Map<String, List<String>> women = Map.of(
                "Maths", List.of("Alice", "Bob", "Charlie", "Daphnee", "Emily"),
                "Littérature", List.of("Charlie", "Daphnee", "Emily", "Alice", "Bob"),
                "Physique", List.of("Charlie", "Alice", "Daphnee", "Bob", "Emily"),
                "Economie", List.of("Daphnee", "Emily", "Charlie", "Alice", "Bob"),
                "Histoire", List.of("Emily", "Bob", "Alice", "Charlie", "Daphnee"));
        Map<String, String> res = WeddingComplex.createBestCouple(men, women);

        System.out.println(res);


        assertThat(res.keySet())
                .withFailMessage("First elements should be of %s, but was %s", men.keySet().toString(), res.keySet().toString())
                .containsExactlyInAnyOrderElementsOf(men.keySet());
        assertThat(res.values())
                .withFailMessage("Second elements should be of %s, but was %s", women.keySet().toString(), res.values().toString())
                .containsExactlyInAnyOrderElementsOf(women.keySet());

        for (Entry<String, String> couple : res.entrySet()) {
            String man = couple.getKey();
            String woman = couple.getValue();
            int indexMan = women.get(woman).indexOf(man);

            for (int i = 0; i < indexMan; i++) {
                String candidateMan = women.get(woman).get(i);
                String womanOfCandidateMan = res.get(candidateMan);
                int indexOfWomanInCandidateMan = men.get(candidateMan).indexOf(woman);
                int indexOfWomanOfCandidateMan = men.get(candidateMan).indexOf(womanOfCandidateMan);

                assertThat(indexOfWomanInCandidateMan)
                        .withFailMessage("%s and %s prefer to be together than to be with %s and %s", woman, candidateMan, man, womanOfCandidateMan)
                        .isGreaterThan(indexOfWomanOfCandidateMan);
            }
        }
    }

}