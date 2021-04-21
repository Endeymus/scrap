package com.endeymus.scrap.patterns.factory.pizza;

import com.endeymus.scrap.patterns.factory.ingredient.*;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Mark Shamray
 */
public abstract class Pizza {
    @Getter
    @Setter
    String name;

    Dough dough;
    Sauce sauce;
    Veggies[] veggies;
    Cheese cheese;
    Pepperoni pepperoni;
    Clams clam;

    public abstract void prepare();
    public void bake() {
        System.out.println("Испекли");
    }
    public void cut() {
        System.out.println("Нарезали");
    }
    public void box() {
        System.out.println("Упаковали");
    }
}
