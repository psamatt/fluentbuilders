package com.psamatt.fluentbuilders.coffeeshop;

import static com.psamatt.fluentbuilders.coffeeshop.DrinkBuilder.Option.OptionChoice.EXTRA_HOT;
import static com.psamatt.fluentbuilders.coffeeshop.DrinkBuilder.Option.OptionChoice.SKINNY;
import static com.psamatt.fluentbuilders.coffeeshop.drink.hot.coffee.CoffeeBuilder.Type.AMERICANO;

import com.psamatt.fluentbuilders.coffeeshop.drink.cold.WaterBuilder;
import com.psamatt.fluentbuilders.coffeeshop.drink.hot.coffee.CoffeeBuilder;
import com.psamatt.fluentbuilders.coffeeshop.drink.hot.tea.TeaBuilder;
import lombok.Value;

public class DrinkBuilder {

    private DrinkBuilder() {
        // empty constructor
    }

    public static CoffeeBuilder coffee() {
        return new CoffeeBuilder(AMERICANO);
    }

    public static CoffeeBuilder coffee(CoffeeBuilder.Type type) {
        return new CoffeeBuilder(type);
    }

    public static TeaBuilder tea() {
        return new TeaBuilder();
    }

    public static WaterBuilder water() {
        return new WaterBuilder();
    }

    @FunctionalInterface
    public interface Option {

        OptionChoice getChoice();

        enum OptionChoice {
            EXTRA_HOT,
            SKINNY,
            SYRUP
        }

        static Option extraHot() {
            return () -> EXTRA_HOT;
        }

        static Option skinny() {
            return () -> SKINNY;
        }

        static Option syrup(Syrup syrup) {
            return new SyrupOption(syrup);
        }
    }

    @Value
    static class SyrupOption implements Option {
        Syrup syrup;
        OptionChoice choice = OptionChoice.SYRUP;
    }

    public enum Syrup {
        HAZLENUT,
        CARAMEL
    }

    public enum Size {
        SMALL,
        STANDARD,
        LARGE
    }
}
