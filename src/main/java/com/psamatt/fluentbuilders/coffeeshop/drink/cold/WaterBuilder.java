package com.psamatt.fluentbuilders.coffeeshop.drink.cold;

public class WaterBuilder {

    public TapWater tap() {
        return new TapWater();
    }

    public BottledWater bottled() {
        return new BottledWater();
    }
}
