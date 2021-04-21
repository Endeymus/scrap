package com.endeymus.scrap.streamapi.ch3;

import com.endeymus.scrap.streamapi.ch2.Apple;
import com.endeymus.scrap.streamapi.ch2.Color;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Comparing {@code Apple} by weight using custom comparator with lambda expression
 * @author Mark Shamray
 */
public class ComparatorLambda {
    public static void main(String[] args) {
        Comparator<Apple> beWeight = ((o1, o2) -> Float.compare(o1.getWeight(), o2.getWeight()));

        List<Apple> list = new ArrayList<>();
        list.add(new Apple(Color.RED, .150f));
        list.add(new Apple(Color.RED, .140f));
        list.add(new Apple(Color.RED, .10f));
        list.add(new Apple(Color.RED, .170f));
        list.add(new Apple(Color.RED, .180f));

        System.out.println("before sort by weight");
        list.forEach(System.out::println);

//        list.sort(beWeight);
        list.sort(Comparator.comparing(Apple::getWeight));
        System.out.println("after sort by weight");
        list.forEach(System.out::println);
    }
}
