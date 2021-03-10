package com.psamatt.fluentbuilders.coffeeshop.drink.hot.coffee;

import static com.psamatt.fluentbuilders.coffeeshop.drink.Drink.SkillLevel.BARISTA;

import com.psamatt.fluentbuilders.coffeeshop.DrinkBuilder;
import java.util.Collection;
import lombok.EqualsAndHashCode;
import lombok.Value;

@Value
@EqualsAndHashCode(callSuper = true)
public class Latte extends Coffee {

    DrinkBuilder.Size size;
    Collection<DrinkBuilder.Option> options;

    public SkillLevel getSkillLevel() {
        return BARISTA;
    }
}
