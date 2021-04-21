package com.endeymus.scrap.patterns.factory;

import com.endeymus.scrap.patterns.factory.ny.NYPizzaStore;
import com.endeymus.scrap.patterns.factory.pizza.Pizza;

/**
 * @author Mark Shamray
 */
public class PizzaTestDrive {
    public static void main(String[] args) {
        PizzaStore nyStore = new NYPizzaStore();

        Pizza pizza = nyStore.orderPizza("cheese");
    }
}
