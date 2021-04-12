package com.endeymus.scrap.patterns.strategy;

/**
 * @author Mark Shamray
 */
public class Quack implements QuackBehavior {
    @Override
    public void quack() {
        System.out.println("Кря кря!!");
    }
}
