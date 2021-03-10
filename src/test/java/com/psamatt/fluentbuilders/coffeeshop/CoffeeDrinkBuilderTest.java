package com.psamatt.fluentbuilders.coffeeshop;

import static com.psamatt.fluentbuilders.coffeeshop.DrinkBuilder.Option.extraHot;
import static com.psamatt.fluentbuilders.coffeeshop.DrinkBuilder.Option.skinny;
import static com.psamatt.fluentbuilders.coffeeshop.DrinkBuilder.Option.syrup;
import static com.psamatt.fluentbuilders.coffeeshop.DrinkBuilder.Size.LARGE;
import static com.psamatt.fluentbuilders.coffeeshop.DrinkBuilder.Size.SMALL;
import static com.psamatt.fluentbuilders.coffeeshop.DrinkBuilder.Size.STANDARD;
import static com.psamatt.fluentbuilders.coffeeshop.DrinkBuilder.Syrup.CARAMEL;
import static com.psamatt.fluentbuilders.coffeeshop.DrinkBuilder.Syrup.HAZLENUT;
import static com.psamatt.fluentbuilders.coffeeshop.DrinkBuilder.coffee;
import static com.psamatt.fluentbuilders.coffeeshop.drink.hot.coffee.CoffeeBuilder.Type.FLAT_WHITE;
import static com.psamatt.fluentbuilders.coffeeshop.drink.hot.coffee.CoffeeBuilder.Type.LATTE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import com.psamatt.fluentbuilders.coffeeshop.drink.hot.coffee.Americano;
import com.psamatt.fluentbuilders.coffeeshop.drink.hot.coffee.FlatWhite;
import com.psamatt.fluentbuilders.coffeeshop.drink.hot.coffee.Latte;
import org.junit.jupiter.api.Test;

class CoffeeDrinkBuilderTest {

    @Test
    void shouldMakeCoffeeExtraHotSizeStandard() {
        Americano coffee = coffee().withOption(extraHot()).size(STANDARD);

        assertThat(coffee).isExactlyInstanceOf(Americano.class);
        assertThat(coffee.getSize()).isEqualTo(STANDARD);
    }

    @Test
    void shouldMakeLatteSizeLarge() {
        Latte coffee = coffee(LATTE).size(LARGE);

        assertThat(coffee).isExactlyInstanceOf(Latte.class);
        assertThat(coffee.getSize()).isEqualTo(LARGE);
    }

    @Test
    void shouldMakeFlatWhite() {
        FlatWhite coffee = coffee(FLAT_WHITE).size(SMALL);

        assertThat(coffee).isExactlyInstanceOf(FlatWhite.class);
    }

    @Test
    void shouldMakeLatteWithTwoOptions() {
        Latte coffee =
                coffee(LATTE).withOption(syrup(HAZLENUT)).withOption(skinny()).size(STANDARD);

        assertThat(coffee.getOptions()).containsExactly(syrup(HAZLENUT), skinny());
    }

    @Test
    void shouldThrowDrinkSizeUnavailableWhenFlatWhiteMadeAsLarge() {
        Throwable t = catchThrowable(() -> coffee(FLAT_WHITE).size(LARGE));

        assertThat(t).isExactlyInstanceOf(DrinkSizeUnavailable.class);
    }

    @Test
    void shouldThrowOptionNotAvailableWhenOptionChosenIsNotAvailable() {
        Throwable t =
                catchThrowable(() -> coffee(FLAT_WHITE).withOption(syrup(CARAMEL)).size(SMALL));

        assertThat(t)
                .isExactlyInstanceOf(OptionNotAvailable.class)
                .hasMessage("Option [SYRUP] not available");
    }
}
