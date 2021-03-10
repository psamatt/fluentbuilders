package com.psamatt.fluentbuilders.coffeeshop.drink.hot.coffee;

import com.psamatt.fluentbuilders.coffeeshop.DrinkBuilder;
import com.psamatt.fluentbuilders.coffeeshop.DrinkBuilder.Size;
import com.psamatt.fluentbuilders.coffeeshop.drink.hot.HotDrink;
import java.util.Collection;

public abstract class Coffee implements HotDrink {
    Size size;

    public abstract Collection<DrinkBuilder.Option> getOptions();
}
