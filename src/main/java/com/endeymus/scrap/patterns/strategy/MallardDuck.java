package com.endeymus.scrap.patterns.strategy;

/**
 * @author Mark Shamray
 */
public class MallardDuck extends Duck {
    public MallardDuck(FlyBehavior flyBehavior, QuackBehavior quackBehavior) {
        this.flyBehavior = flyBehavior;
        this.quackBehavior = quackBehavior;
    }

    @Override
    public void display() {
        System.out.println("its mallard duck!");
    }
}
