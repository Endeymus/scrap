package com.endeymus.scrap.patterns.strategy;

/**
 * @author Mark Shamray
 */
public class FlyWithWings implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("I'm flying!!");
    }
}
