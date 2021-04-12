package com.endeymus.scrap.JPoint2020;

/**
 * @author Mark Shamray
 */
public class A {
    void m() throws MyException {};
}

class B extends A {
    @Override
    void m() throws MyException, Buisness {
        super.m();
    }
}

class MyException extends Exception {}
class Local extends Exception {}
class Buisness extends MyException {}

