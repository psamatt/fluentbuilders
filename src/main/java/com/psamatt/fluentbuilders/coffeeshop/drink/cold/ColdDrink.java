package com.psamatt.fluentbuilders.coffeeshop.drink.cold;

import static com.psamatt.fluentbuilders.coffeeshop.drink.Drink.SkillLevel.APPRENTICE;

import com.psamatt.fluentbuilders.coffeeshop.drink.Drink;

public interface ColdDrink extends Drink {

    default SkillLevel getSkillLevel() {
        return APPRENTICE;
    }

    default boolean isHot() {
        return false;
    }
}
