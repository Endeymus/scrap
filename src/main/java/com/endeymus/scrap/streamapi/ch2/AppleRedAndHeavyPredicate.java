package com.endeymus.scrap.streamapi.ch2;

/**
 * @author Mark Shamray
 */
public class AppleRedAndHeavyPredicate implements ApplePredicate {
    @Override
    public boolean test(Apple apple) {
        return Color.RED.equals(apple.getColor())
                && apple.getWeight() > .150f;
    }
}
