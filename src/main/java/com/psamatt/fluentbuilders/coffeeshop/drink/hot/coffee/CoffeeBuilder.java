package com.psamatt.fluentbuilders.coffeeshop.drink.hot.coffee;

import com.psamatt.fluentbuilders.coffeeshop.DrinkBuilder;
import com.psamatt.fluentbuilders.coffeeshop.DrinkBuilder.Option;
import java.util.ArrayList;
import java.util.Collection;

public class CoffeeBuilder {

    private final Collection<Option> options = new ArrayList<>();
    private final CoffeeBuilder.Type type;
    private final CoffeeFactory factory;

    public CoffeeBuilder(Type type) {
        factory = new CoffeeFactory();
        this.type = type;
    }

    public CoffeeBuilder withOption(Option option) {
        options.add(option);
        return this;
    }

    public <T> T size(DrinkBuilder.Size size) {
        return (T) factory.makeCoffee(type, new CoffeeFactory.CoffeeSelection(size, options));
    }

    public enum Type {
        AMERICANO,
        LATTE,
        FLAT_WHITE
    }
}
