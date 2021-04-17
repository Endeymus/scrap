package com.endeymus.scrap.patterns.decorator;

/**
 * @author Mark Shamray
 */
public class MilkFoam extends CondimentDecorator {
    private Beverage beverage;

    public MilkFoam(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public double cost() {
        return .10 + beverage.cost();
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", Milk foam";
    }
}
