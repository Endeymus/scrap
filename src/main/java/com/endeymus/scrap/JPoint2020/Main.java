package com.endeymus.scrap.JPoint2020;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        CoronaDesinfector coronaDesinfector = new CoronaDesinfector();
        coronaDesinfector.start(new Room());
    }
}
