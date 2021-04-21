package com.endeymus.scrap.patterns.factory;

import com.endeymus.scrap.patterns.factory.pizza.Pizza;

/**
 * @author Mark Shamray
 */
public abstract class PizzaStore {

    public Pizza orderPizza(String name) {
        Pizza pizza;

        pizza = createPizza(name);

        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();

        return pizza;
    }

    protected abstract Pizza createPizza(String name);

}
