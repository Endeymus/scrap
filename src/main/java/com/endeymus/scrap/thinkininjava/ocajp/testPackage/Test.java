package com.endeymus.scrap.thinkininjava.ocajp.testPackage;

/**
 * @author Mark Shamray
 */
public class Test {
    public static void main(String[] args) {
        String hello = "Hello", lo = "lo";
        System.out.print((com.endeymus.scrap.thinkininjava.ocajp.testPackage.Other.hello == hello) + " ");
        System.out.print((com.endeymus.scrap.thinkininjava.ocajp.other.Other.hello == hello) + " ");
        System.out.print((hello == ("Hel"+"lo")) + " ");
        System.out.print((hello == ("Hel"+lo)) + " ");
        System.out.println(hello == ("Hel"+lo).intern() );
    }
}

class Other { static String hello = "Hello"; }

