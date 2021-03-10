package com.psamatt.fluentbuilders.coffeeshop.drink.hot.coffee;

import static com.psamatt.fluentbuilders.coffeeshop.DrinkBuilder.Option.extraHot;
import static com.psamatt.fluentbuilders.coffeeshop.DrinkBuilder.Option.skinny;
import static com.psamatt.fluentbuilders.coffeeshop.DrinkBuilder.Option.syrup;
import static com.psamatt.fluentbuilders.coffeeshop.DrinkBuilder.Size.LARGE;
import static com.psamatt.fluentbuilders.coffeeshop.DrinkBuilder.Size.SMALL;
import static com.psamatt.fluentbuilders.coffeeshop.DrinkBuilder.Size.STANDARD;
import static com.psamatt.fluentbuilders.coffeeshop.drink.hot.coffee.CoffeeBuilder.Type.AMERICANO;
import static com.psamatt.fluentbuilders.coffeeshop.drink.hot.coffee.CoffeeBuilder.Type.FLAT_WHITE;
import static com.psamatt.fluentbuilders.coffeeshop.drink.hot.coffee.CoffeeBuilder.Type.LATTE;

import com.psamatt.fluentbuilders.coffeeshop.DrinkBuilder;
import com.psamatt.fluentbuilders.coffeeshop.DrinkSizeUnavailable;
import com.psamatt.fluentbuilders.coffeeshop.OptionNotAvailable;
import com.psamatt.fluentbuilders.coffeeshop.drink.hot.coffee.CoffeeBuilder.Type;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Singular;

public class CoffeeFactory {

    private final Collection<CoffeeConfiguration<Coffee>> config;

    public CoffeeFactory() {
        this.config =
                List.of(
                        CoffeeConfiguration.builder()
                                .type(AMERICANO)
                                .availableSize(STANDARD)
                                .availableOption(extraHot())
                                .builder(builder -> new Americano(builder.size, builder.options))
                                .build(),
                        CoffeeConfiguration.builder()
                                .type(LATTE)
                                .availableSizes(List.of(STANDARD, LARGE))
                                .availableOption(skinny())
                                .availableOption(syrup(DrinkBuilder.Syrup.HAZLENUT))
                                .builder(builder -> new Latte(builder.size, builder.options))
                                .build(),
                        CoffeeConfiguration.builder()
                                .type(FLAT_WHITE)
                                .availableSize(SMALL)
                                .availableOption(skinny())
                                .builder(builder -> new FlatWhite(builder.size, builder.options))
                                .build());
    }

    public <T> T makeCoffee(Type type, CoffeeSelection coffeeSelection) {
        Optional<CoffeeConfiguration<Coffee>> first =
                config.stream().filter(c -> c.type == type).findFirst();

        return (T)
                first.map(config -> config.make(coffeeSelection))
                        .orElseThrow(() -> new UnknownCoffeeTypeException(type));
    }

    @Builder
    public static class CoffeeConfiguration<T extends Coffee> {
        private final Type type;
        @Singular private final Collection<DrinkBuilder.Size> availableSizes;
        @Singular private final Collection<DrinkBuilder.Option> availableOptions;
        private final CoffeeBuilder<T> builder;

        public T make(CoffeeSelection coffeeSelection) {
            if (!availableSizes.contains(coffeeSelection.size)) {
                throw new DrinkSizeUnavailable(coffeeSelection.size);
            }
            coffeeSelection.options.forEach(
                    option -> {
                        if (!availableOptions.contains(option)) {
                            throw new OptionNotAvailable(option, availableOptions);
                        }
                    });
            return builder.build(coffeeSelection);
        }
    }

    @Getter
    @Data
    public static class CoffeeSelection {
        private final DrinkBuilder.Size size;
        private final Collection<DrinkBuilder.Option> options;
    }

    private interface CoffeeBuilder<T extends Coffee> {
        T build(CoffeeSelection builder);
    }
}
