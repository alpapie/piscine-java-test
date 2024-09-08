import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.fail;

import java.lang.reflect.Modifier;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(StopAfterFailureExtension.class)
class BuilderTest {

    @Test
    void checkClass() {
        var housing = Housing.class;
        assertThat(housing)
                .withFailMessage("Housing should be an interface")
                .isInterface();
        var apartmentClass = Apartment.class;
        assertThat(apartmentClass.getInterfaces())
                .withFailMessage("Apartment should implement Housing interface")
                .containsExactly(Housing.class);
        var houseClass = House.class;
        assertThat(houseClass.getInterfaces())
                .withFailMessage("House should implement Housing interface")
                .containsExactly(Housing.class);
        try {
            apartmentClass.getDeclaredConstructor();
        } catch (NoSuchMethodException e) {
            fail("Apartment should have a empty constructor");
        }
        try {
            houseClass.getDeclaredConstructor();
        } catch (NoSuchMethodException e) {
            fail("House should have a empty constructor");
        }

        var housingBuilderClass = HousingBuilder.class;
        assertThat(housingBuilderClass)
                .withFailMessage("HousingBuilder should be an interface")
                .isInterface();
        var apartmentBuilderClass = ApartmentBuilder.class;
        assertThat(apartmentBuilderClass.getInterfaces())
                .withFailMessage("ApartmentBuilder should implement HousingBuilder interface")
                .containsExactly(HousingBuilder.class);
        var houseBuilderClass = HouseBuilder.class;
        assertThat(houseBuilderClass.getInterfaces())
                .withFailMessage("HouseBuilder should implement HousingBuilder interface")
                .containsExactly(HousingBuilder.class);
        try {
            apartmentBuilderClass.getDeclaredConstructor();
        } catch (NoSuchMethodException e) {
            fail("ApartmentBuilder should have a empty constructor");
        }
        try {
            houseBuilderClass.getDeclaredConstructor();
        } catch (NoSuchMethodException e) {
            fail("HouseBuilder should have a empty constructor");
        }
    }

    @Test
    void createInstanceHouse() {
        House expected = new House();
        expected.setSize(63);
        expected.setPrice(194837);
        expected.setName("Name Test");
        expected.setRooms(12);

        Housing house = new HouseBuilder()
                .setName("Name Test")
                .setRooms(12)
                .setPrice(194837)
                .setSize(63)
                .build();

        assertThat(house)
                .withFailMessage("The built house should be an instance of House class")
                .isInstanceOf(House.class);

        assertThat(house)
                .withFailMessage("The built house should be %s, but was %s", expected, house)
                .usingRecursiveComparison()
                .isEqualTo(expected);
    }

    @Test
    void createInstanceApartment() {
        Apartment expected = new Apartment();
        expected.setSize(42);
        expected.setPrice(384762);
        expected.setName("Name Test Again");
        expected.setRooms(7);

        Housing apartment = new ApartmentBuilder()
                .setName("Name Test Again")
                .setRooms(7)
                .setPrice(384762)
                .setSize(42)
                .build();

        assertThat(apartment)
                .withFailMessage("The built apartment should be an instance of Apartment class")
                .isInstanceOf(Apartment.class);

        assertThat(apartment)
                .withFailMessage("The built apartment should be %s, but was %s", expected, apartment)
                .usingRecursiveComparison()
                .isEqualTo(expected);
    }

}