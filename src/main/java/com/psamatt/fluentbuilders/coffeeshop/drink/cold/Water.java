package com.psamatt.fluentbuilders.coffeeshop.drink.cold;

import static com.psamatt.fluentbuilders.coffeeshop.DrinkBuilder.Size.STANDARD;

import com.psamatt.fluentbuilders.coffeeshop.DrinkBuilder;

public interface Water extends ColdDrink {

    @Override
    default DrinkBuilder.Size getSize() {
        return STANDARD;
    }
}
