package com.psamatt.fluentbuilders.coffeeshop;

import static com.psamatt.fluentbuilders.coffeeshop.DrinkBuilder.tea;
import static org.assertj.core.api.Assertions.assertThat;

import com.psamatt.fluentbuilders.coffeeshop.drink.Drink;
import com.psamatt.fluentbuilders.coffeeshop.drink.hot.tea.Tea;
import org.junit.jupiter.api.Test;

class TeaDrinkBuilderTest {

    @Test
    void shouldMakeTeaWithTwoSugarsMilk() {
        Tea tea = tea().sugar(2).milk();

        assertThat(tea.getSugar()).isEqualTo(2);
        assertThat(tea.hasMilk()).isTrue();
    }

    @Test
    void shouldMakeTeaWithNoMilk() {
        Tea tea = tea().noSugar().noMilk();

        assertThat(tea.getSugar()).isEqualTo(0);
        assertThat(tea.hasMilk()).isFalse();
    }

    @Test
    void shouldMakeBlackTea() {
        Tea tea = tea().black();

        assertThat(tea.getSugar()).isEqualTo(0);
        assertThat(tea.hasMilk()).isFalse();
    }

    @Test
    void shouldBeSkillLevelMidLevel() {
        Tea tea = tea().black();

        assertThat(tea.getSkillLevel()).isEqualTo(Drink.SkillLevel.MID_LEVEL);
    }

    @Test
    void shouldBeHot() {
        Tea tea = tea().black();

        assertThat(tea.isHot()).isTrue();
    }
}
