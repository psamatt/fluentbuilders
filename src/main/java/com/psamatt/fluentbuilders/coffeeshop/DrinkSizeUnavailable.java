package com.psamatt.fluentbuilders.coffeeshop;

public class DrinkSizeUnavailable extends RuntimeException {

    public DrinkSizeUnavailable(DrinkBuilder.Size size) {
        super(String.format("%s is not available", size));
    }
}
