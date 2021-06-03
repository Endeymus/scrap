package com.endeymus.scrap.multithreading.delres;

/**
 * @author Mark Shamray
 */
public class Car {
    public synchronized void waitingCall(String text) {
        try {
            while (!Thread.interrupted()) {
                System.out.println(text);
                wait();
            }
        } catch (InterruptedException ignored) {
        }
    }
    public synchronized void prod() {
        notify();
    }
}
