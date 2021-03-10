package com.psamatt.fluentbuilders.coffeeshop.drink.hot.tea;

public class TeaBuilder {

    public MilkBuilder sugar(int sugar) {
        return new MilkBuilder(sugar);
    }

    public MilkBuilder noSugar() {
        return new MilkBuilder(0);
    }

    public Tea black() {
        return new MilkBuilder(0).noMilk();
    }

    public static class MilkBuilder {

        private final int sugar;

        public MilkBuilder(int sugar) {
            this.sugar = sugar;
        }

        public Tea noMilk() {
            return new Tea(false, sugar);
        }

        public Tea milk() {
            return new Tea(true, sugar);
        }
    }
}
