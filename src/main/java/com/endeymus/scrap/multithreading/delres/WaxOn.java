package com.endeymus.scrap.multithreading.delres;

import java.util.concurrent.TimeUnit;

/**
 * @author Mark Shamray
 */
public class WaxOn implements Runnable {
    public static Car car;

    public WaxOn(Car car) {
        WaxOn.car = car;
    }

    @Override
    public void run() {
        car.waitingCall("WaxOn!");
        System.out.println("Ending wax on task");
    }
}
