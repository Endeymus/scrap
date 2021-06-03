package com.endeymus.scrap.multithreading.delres;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * @author Mark Shamray
 */
public class Notifier implements Runnable {
    private final Runnable r;

    public Notifier(Runnable r) {
        this.r = r;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()){
                synchronized (r) {
//                    System.out.println("Notify waiter");
                    r.notifyAll();
                    TimeUnit.MILLISECONDS.sleep(200);
                }
            }
        } catch (InterruptedException e) {
            System.out.println("Notifier end");
        }
    }
}
