package com.endeymus.scrap.patterns.decorator;

/**
 * @author Mark Shamray
 */
public class Decaf extends Beverage {
    public Decaf() {
        description = "Without caffeine";
    }

    @Override
    public double cost() {
        return 1.05;
    }
}
