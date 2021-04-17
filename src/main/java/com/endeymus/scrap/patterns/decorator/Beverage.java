package com.endeymus.scrap.patterns.decorator;

/**
 * @author Mark Shamray
 */
public abstract class Beverage {
    protected String description = "Unknown Beverage";

    public String getDescription() {
        return description;
    }
    public abstract double cost();
}
