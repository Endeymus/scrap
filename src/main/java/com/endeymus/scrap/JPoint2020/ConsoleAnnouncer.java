package com.endeymus.scrap.JPoint2020;

public class ConsoleAnnouncer implements Announcer {
    private Recommendator recommendator = ObjectFactory.getInstance().createObject(Recommendator.class);
    @Override
    public void announce(String message) {
        System.out.println(message);
        recommendator.recommend();
    }
}
