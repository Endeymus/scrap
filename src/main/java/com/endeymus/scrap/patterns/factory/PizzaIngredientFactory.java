package com.endeymus.scrap.patterns.factory;

import com.endeymus.scrap.patterns.factory.ingredient.*;

/**
 * @author Mark Shamray
 */
public interface PizzaIngredientFactory {
    public Dough createDough();
    public Sauce createSauce();
    public Cheese createCheese();
    public Veggies[] createVeggies();
    public Pepperoni createPepperoni();
    public Clams createClam();
}
