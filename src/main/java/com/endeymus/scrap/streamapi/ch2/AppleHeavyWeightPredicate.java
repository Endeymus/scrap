package com.endeymus.scrap.streamapi.ch2;

/**
 * @author Mark Shamray
 */
public class AppleHeavyWeightPredicate implements ApplePredicate {
    @Override
    public boolean test(Apple apple) {
        return apple.getWeight() > .150f;
    }
}
