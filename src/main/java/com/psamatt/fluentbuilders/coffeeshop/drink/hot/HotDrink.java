package com.psamatt.fluentbuilders.coffeeshop.drink.hot;

import static com.psamatt.fluentbuilders.coffeeshop.drink.Drink.SkillLevel.MID_LEVEL;

import com.psamatt.fluentbuilders.coffeeshop.drink.Drink;

public interface HotDrink extends Drink {

    default SkillLevel getSkillLevel() {
        return MID_LEVEL;
    }

    default boolean isHot() {
        return true;
    }
}
