package com.endeymus.scrap.patterns.factory.pizza;

import com.endeymus.scrap.patterns.factory.PizzaIngredientFactory;

/**
 * @author Mark Shamray
 */
public class PepperoniPizza extends Pizza {
    PizzaIngredientFactory ingredientFactory;

    public PepperoniPizza(PizzaIngredientFactory ingredientFactory) {
        this.ingredientFactory = ingredientFactory;
    }

    @Override
    public void prepare() {
        pepperoni = ingredientFactory.createPepperoni();
    }
}
