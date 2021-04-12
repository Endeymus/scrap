package com.endeymus.scrap.patterns.strategy;

import lombok.Setter;

/**
 * @author Mark Shamray
 */
@Setter
public abstract class Duck {
    protected FlyBehavior flyBehavior;
    protected QuackBehavior quackBehavior;

    public Duck() {
    }

    public abstract void display();

    public void performQuack() {
        quackBehavior.quack();
    }

    public void performFly() {
        flyBehavior.fly();
    }

    public void swim() {
        System.out.println("all ducks float, even decoys!");
    }
}
