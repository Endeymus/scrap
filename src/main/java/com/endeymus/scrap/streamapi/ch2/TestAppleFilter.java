package com.endeymus.scrap.streamapi.ch2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @author Mark Shamray
 */
public class TestAppleFilter {
    public static void main(String[] args) {
        List<Apple> apples = new ArrayList<>();
        apples.add(new Apple(Color.GREEN, .30f));
        apples.add(new Apple(Color.GREEN, .140f));
        apples.add(new Apple(Color.GREEN, .160f));
        apples.add(new Apple(Color.GREEN, .200f));
        apples.add(new Apple(Color.RED, .160f));
        apples.add(new Apple(Color.RED, .130f));
        apples.add(new Apple(Color.RED, .110f));

//        AppleFilter.filter(apples).forEach(System.out::println);
//        AppleFilter.filter(apples, Color.RED).forEach(System.out::println);
//        AppleFilter.filter(apples, new AppleHeavyWeightPredicate()).forEach(System.out::println);
        apples.sort((o1, o2) -> Float.compare(o1.getWeight(), o2.getWeight()));
        apples.forEach(System.out::println);
//        AppleFilter.filter(apples, new AppleRedAndHeavyPredicate()).forEach(System.out::println);
    }
}
