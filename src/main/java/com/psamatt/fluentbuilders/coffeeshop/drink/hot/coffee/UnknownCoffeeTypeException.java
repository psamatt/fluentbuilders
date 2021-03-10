package com.psamatt.fluentbuilders.coffeeshop.drink.hot.coffee;

public class UnknownCoffeeTypeException extends RuntimeException {

    public UnknownCoffeeTypeException(CoffeeBuilder.Type type) {
        super("Unknown Coffee Type: " + type);
    }
}
