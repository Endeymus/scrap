package com.endeymus.scrap.streamapi.ch3;

import java.util.function.Function;

/**
 * @author Mark Shamray
 */
public class ComposFunc {
    public static void main(String[] args) {
        Function<Integer, Integer> f  = x -> x + 1;
        Function<Integer, Integer> g  = x -> x * 2;
        Function<Integer, Integer> h  = f.andThen(g);
        Function<Integer, Integer> j  = f.compose(g);
        System.out.println(h.apply(1));
        System.out.println(j.apply(1));
    }
}
