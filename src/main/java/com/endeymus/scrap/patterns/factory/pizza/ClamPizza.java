package com.endeymus.scrap.patterns.factory.pizza;

import com.endeymus.scrap.patterns.factory.PizzaIngredientFactory;

/**
 * @author Mark Shamray
 */
public class ClamPizza extends Pizza {

    PizzaIngredientFactory ingredientFactory;
    public ClamPizza(PizzaIngredientFactory ingredientFactory) {
        this.ingredientFactory = ingredientFactory;
    }
    public void prepare() {
        dough = ingredientFactory.createDough();
        sauce = ingredientFactory.createSauce();
        cheese = ingredientFactory.createCheese();
        clam = ingredientFactory.createClam();
    }
}
