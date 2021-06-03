package com.endeymus.scrap.multithreading.delres;

import java.util.concurrent.TimeUnit;

/**
 * @author Mark Shamray
 */
public class WaxOff implements Runnable {
    public static Car car;

    public WaxOff(Car car) {
        WaxOff.car = car;
    }

    @Override
    public void run() {
        car.waitingCall("WaxOff!");
        System.out.println("Ending wax off task");
    }
}
