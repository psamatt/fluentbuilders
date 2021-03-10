package com.psamatt.fluentbuilders.coffeeshop.drink.hot.tea;

import static com.psamatt.fluentbuilders.coffeeshop.DrinkBuilder.Size.STANDARD;

import com.psamatt.fluentbuilders.coffeeshop.DrinkBuilder;
import com.psamatt.fluentbuilders.coffeeshop.drink.hot.HotDrink;
import lombok.Value;

@Value
public class Tea implements HotDrink {

    boolean milk;
    int sugar;

    @Override
    public DrinkBuilder.Size getSize() {
        return STANDARD;
    }

    public boolean hasMilk() {
        return milk;
    }
}
