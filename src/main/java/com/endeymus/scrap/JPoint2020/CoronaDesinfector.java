package com.endeymus.scrap.JPoint2020;

public class CoronaDesinfector {
    private Announcer announcer = ObjectFactory.getInstance().createObject(Announcer.class);
    private Policeman policeman = ObjectFactory.getInstance().createObject(Policeman.class);

    public void start(Room room) {
        announcer.announce("Свалил!");
        policeman.makePeopleLeaveRoom();
        desinfect(room);
        announcer.announce("Зашли быро");
    }

    private void desinfect(Room room) {
        System.out.println("Нафиг Корону!!!");
    }
}
