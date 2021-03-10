package com.psamatt.fluentbuilders.coffeeshop.drink.hot.coffee;

import com.psamatt.fluentbuilders.coffeeshop.DrinkBuilder;
import java.util.Collection;
import lombok.EqualsAndHashCode;
import lombok.Value;

@Value
@EqualsAndHashCode(callSuper = true)
public class Americano extends Coffee {

    DrinkBuilder.Size size;
    Collection<DrinkBuilder.Option> options;
}
