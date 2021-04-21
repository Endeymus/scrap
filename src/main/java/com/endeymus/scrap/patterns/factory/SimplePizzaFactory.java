package com.endeymus.scrap.patterns.factory;

import com.endeymus.scrap.patterns.factory.pizza.*;

/**
 * @author Mark Shamray
 */
public class SimplePizzaFactory {
    public Pizza createPizza(String name) {
        Pizza pizza = null;
        switch (name) {
            case "cheese":
                pizza = new CheesePizza(null);
                break;
            case "pepperoni":
                pizza = new PepperoniPizza(null);
                break;
            case "clam":
                pizza = new ClamPizza(null);
                break;
            case "veggie":
                pizza = new VeggiePizza(null);
                break;
        }
        return pizza;
    }
}
