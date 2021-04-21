package com.endeymus.scrap.patterns.factory.pizza;

import com.endeymus.scrap.patterns.factory.PizzaIngredientFactory;

/**
 * @author Mark Shamray
 */
public class VeggiePizza extends Pizza {
    PizzaIngredientFactory ingredientFactory;

    public VeggiePizza(PizzaIngredientFactory ingredientFactory) {
        this.ingredientFactory = ingredientFactory;
    }

    @Override
    public void prepare() {
        veggies = ingredientFactory.createVeggies();
    }
}
