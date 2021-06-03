package com.endeymus.scrap.streamapi.ch3;

import com.endeymus.scrap.streamapi.ch2.Apple;
import com.endeymus.scrap.streamapi.ch2.Color;
import com.endeymus.scrap.streamapi.util.AppleGenerator;
import com.endeymus.scrap.streamapi.util.Generator;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toMap;

/**
 * @author Mark Shamray
 */
public class ReferenceToMethod {
    public static void main(String[] args) {
        Generator<Apple> generator = new AppleGenerator();
        List<Apple> list = generator.generate(10);
//        List<Apple> sort = list.stream().sorted((a, b) -> Float.compare(a.getWeight(), b.getWeight())).collect(toList());

/*
        List<Apple> sort = list.stream().sorted(new Comparator<Apple>() {
            public int compare(Apple a1, Apple a2){
                return Float.compare(a1.getWeight(),a2.getWeight());
            }
        }).collect(toList());
*/

        List<Apple> sort = list.stream().sorted(Comparator.comparing(Apple::getWeight).reversed()).collect(toList());
        sort.forEach(System.out::println);
    }
}
