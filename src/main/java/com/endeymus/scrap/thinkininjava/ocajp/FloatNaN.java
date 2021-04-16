package com.endeymus.scrap.thinkininjava.ocajp;

/**
 * @author Mark Shamray
 */
public class FloatNaN {
    public static void main(String[] args) {
        Float f1 = Float.NaN;
        Float f2 = Float.NaN;
        System.out.println( ""+ (f1 == f2)+" "+f1.equals(f2)+ " "+(Float.NaN == Float.NaN) );
    }
}
