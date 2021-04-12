package com.endeymus.scrap.patterns.strategy;

/**
 * @author Mark Shamray
 */
public class Main {
    public static void main(String[] args) {
        Duck duck = new MallardDuck(new FlyWithWings(), new Quack());
        duck.performFly();
        duck.performQuack();
        duck.display();
    }
}
