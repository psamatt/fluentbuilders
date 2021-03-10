package com.psamatt.fluentbuilders.coffeeshop;

import java.util.Collection;
import lombok.Getter;

@Getter
public class OptionNotAvailable extends RuntimeException {

    private final DrinkBuilder.Option option;
    private final Collection<DrinkBuilder.Option> availableOptions;

    public OptionNotAvailable(
            DrinkBuilder.Option option, Collection<DrinkBuilder.Option> availableOptions) {
        super(String.format("Option [%s] not available", option.getChoice()));
        this.option = option;
        this.availableOptions = availableOptions;
    }
}
