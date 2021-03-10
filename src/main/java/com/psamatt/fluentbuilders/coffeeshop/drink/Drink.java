package com.psamatt.fluentbuilders.coffeeshop.drink;

import com.psamatt.fluentbuilders.coffeeshop.DrinkBuilder;

public interface Drink {

    SkillLevel getSkillLevel();

    DrinkBuilder.Size getSize();

    boolean isHot();

    public enum SkillLevel {
        APPRENTICE,
        MID_LEVEL,
        BARISTA
    }
}
