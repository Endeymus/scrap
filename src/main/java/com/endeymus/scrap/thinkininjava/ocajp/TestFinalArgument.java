package com.endeymus.scrap.thinkininjava.ocajp;

import java.util.Collections;

/**
 * @author Mark Shamray
 */
public class TestFinalArgument {
    public static void main(String[] args) {
        int a;
        m();
        Collections.singletonList(1).add(1);
    }

    public static void m(String...args) {
        for (String arg : args) {
            System.out.println(arg);
        }
    }
}
