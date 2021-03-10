package com.psamatt.fluentbuilders.coffeeshop;

import static com.psamatt.fluentbuilders.coffeeshop.DrinkBuilder.water;
import static org.assertj.core.api.Assertions.assertThat;

import com.psamatt.fluentbuilders.coffeeshop.drink.Drink;
import com.psamatt.fluentbuilders.coffeeshop.drink.cold.BottledWater;
import com.psamatt.fluentbuilders.coffeeshop.drink.cold.TapWater;
import com.psamatt.fluentbuilders.coffeeshop.drink.cold.Water;
import org.junit.jupiter.api.Test;

class WaterDrinkBuilderTest {

    @Test
    void shouldMakeTapWater() {
        Water water = water().tap();

        assertThat(water).isExactlyInstanceOf(TapWater.class);
    }

    @Test
    void shouldMakeBottledWater() {
        Water water = water().bottled();

        assertThat(water).isExactlyInstanceOf(BottledWater.class);
    }

    @Test
    void shouldBeSizeStandard() {
        Water water = water().bottled();

        assertThat(water.getSize()).isEqualTo(DrinkBuilder.Size.STANDARD);
    }

    @Test
    void shouldNotBeHot() {
        Water water = water().bottled();

        assertThat(water.isHot()).isFalse();
    }

    @Test
    void shouldBeSkillLevelApprentice() {
        Water water = water().bottled();

        assertThat(water.getSkillLevel()).isEqualTo(Drink.SkillLevel.APPRENTICE);
    }
}
