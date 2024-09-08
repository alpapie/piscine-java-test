import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.fail;

import java.lang.reflect.Modifier;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(StopAfterFailureExtension.class)
class DecoratorTest {

    @Test
    void checkClass() {
        var raclette = Raclette.class;
        assertThat(raclette)
                .withFailMessage("Raclette should be an interface")
                .isInterface();
        var racletteDecoratorClass = RacletteDecorator.class;
        assertThat(racletteDecoratorClass.getInterfaces())
                .withFailMessage("RacletteDecorator should implement Raclette interface")
                .containsExactly(Raclette.class);
        assertThat(racletteDecoratorClass)
                .withFailMessage("RacletteDecorator should be abstract")
                .isAbstract();
        var baseRacletteClass = BaseRaclette.class;
        assertThat(baseRacletteClass.getInterfaces())
                .withFailMessage("BaseRaclette should implement Raclette interface")
                .containsExactly(Raclette.class);
        var withPicklesClass = WithPickles.class;
        assertThat(withPicklesClass.getSuperclass())
                .withFailMessage("WithPickles should inherit RacletteDecorator")
                .isEqualTo(RacletteDecorator.class);
        var WithColdMeats = WithColdMeats.class;
        assertThat(WithColdMeats.getSuperclass())
                .withFailMessage("WithColdMeats should inherit RacletteDecorator")
                .isEqualTo(RacletteDecorator.class);
    }

    @Test
    void decorate() {
        Raclette r = new BaseRaclette();

        assertThat(r.getIngredients())
                .withFailMessage("The ingredients of the base raclette should be \"Patate, fromage à raclette\", but was %s", r.getIngredients())
                .isEqualTo("Patate, fromage à raclette");
        assertThat(r.getCalories())
                .withFailMessage("The calories of the base raclette should be 1000, but was %d", r.getCalories())
                .isEqualTo(1000);

        r = new WithPickles(r);
        assertThat(r.getIngredients())
                .withFailMessage("The ingredients of the raclette with pickles should be \"Patate, fromage à raclette, cornichons\", but was %s", r.getIngredients())
                .isEqualTo("Patate, fromage à raclette, cornichons");
        assertThat(r.getCalories())
                .withFailMessage("The calories of the base raclette should be 1050, but was %d", r.getCalories())
                .isEqualTo(1050);

        r = new WithPickles(r);
        assertThat(r.getIngredients())
                .withFailMessage("The ingredients of the raclette with double pickles should be \"Patate, fromage à raclette, cornichons, cornichons\", but was %s", r.getIngredients())
                .isEqualTo("Patate, fromage à raclette, cornichons, cornichons");
        assertThat(r.getCalories())
                .withFailMessage("The calories of the base raclette should be 1100, but was %d", r.getCalories())
                .isEqualTo(1100);

        r = new WithColdMeats(r);
        assertThat(r.getIngredients())
                .withFailMessage("The ingredients of the raclette with double pickles and cold meats should be \"Patate, fromage à raclette, cornichons, cornichons, charcuterie\", but was %s", r.getIngredients())
                .isEqualTo("Patate, fromage à raclette, cornichons, cornichons, charcuterie");
        assertThat(r.getCalories())
                .withFailMessage("The calories of the base raclette should be 1450, but was %d", r.getCalories())
                .isEqualTo(1450);
    }
}