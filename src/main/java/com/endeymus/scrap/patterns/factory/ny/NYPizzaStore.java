package com.endeymus.scrap.patterns.factory.ny;

import com.endeymus.scrap.patterns.factory.*;
import com.endeymus.scrap.patterns.factory.pizza.*;

/**
 * @author Mark Shamray
 */
public class NYPizzaStore extends PizzaStore {
    @Override
    protected Pizza createPizza(String name) {
        PizzaIngredientFactory ingredientFactory = new NYPizzaIngredientFactory();
        switch (name) {
            case "cheese":
                return new CheesePizza(ingredientFactory);
            case "veggie":
                return new VeggiePizza(ingredientFactory);
            case "clam":
                return new ClamPizza(ingredientFactory);
            case "pepperoni":
                return new PepperoniPizza(ingredientFactory);
            default:
                return null;
        }
    }
}
