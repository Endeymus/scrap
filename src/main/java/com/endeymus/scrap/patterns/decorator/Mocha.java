package com.endeymus.scrap.patterns.decorator;

/**
 * @author Mark Shamray
 */
public class Mocha extends CondimentDecorator {
    private Beverage beverage;

    public Mocha(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public double cost() {
        return .20 + beverage.cost();

    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", Mocha";
    }
}
