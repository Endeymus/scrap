package com.endeymus.scrap.multithreading.delres;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author Mark Shamray
 */
public class WaxOMatic {

    public static void main(String[] args) throws InterruptedException {
        ExecutorService service = Executors.newCachedThreadPool();
        Car car = new Car();
        service.execute(new WaxOn(car));
        service.execute(new WaxOff(car));
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            boolean prod = true;
            @Override
            public void run() {
                if(prod) {
                    prod = false;
                    WaxOn.car.prod();
                } else {
                    prod = true;
                    WaxOff.car.prod();
                }
            }
        }, 200, 200);
        TimeUnit.SECONDS.sleep(5);
        timer.cancel();
        service.shutdownNow();
    }
}
