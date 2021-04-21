package com.endeymus.scrap.streamapi.ch2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Mark Shamray
 */
public class AppleFilter {

    public static List<Apple> filter(List<Apple> list) {
        List<Apple> res = new ArrayList<>();
        for (Apple apple : list) {
            if (Color.GREEN.equals(apple.getColor())) {
                res.add(apple);
            }
        }
        return res;
    }

    public static List<Apple> filter(List<Apple> list, Color color) {
        List<Apple> res = new ArrayList<>();
        for (Apple apple : list) {
            if (color.equals(apple.getColor())) {
                res.add(apple);
            }
        }
        return res;
    }

    public static List<Apple> filter(List<Apple> list, ApplePredicate p) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : list) {
            if (p.test(apple)) {
                result.add(apple);
            }
        }
        return result;
    }
}
