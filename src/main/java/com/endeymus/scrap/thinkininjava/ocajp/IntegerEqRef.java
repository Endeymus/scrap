package com.endeymus.scrap.thinkininjava.ocajp;

/**
 * @author Mark Shamray
 */
public class IntegerEqRef {
    public static void main(String[] args) {
        Integer a = 120;
        Integer b = 120;
        Integer c = 128;
        Integer d = 128;
        System.out.println(a==b);
        System.out.println(c==d);
    }
}
