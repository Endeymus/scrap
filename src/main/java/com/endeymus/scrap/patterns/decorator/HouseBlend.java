package com.endeymus.scrap.patterns.decorator;

/**
 * @author Mark Shamray
 */
public class HouseBlend extends Beverage {
    public HouseBlend() {
        description = "House Blend Coffee";
    }

    @Override
    public double cost() {
        return .89;
    }
}
