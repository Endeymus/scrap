package com.endeymus.scrap.multithreading.delres;

/**
 * @author Mark Shamray
 */
public class Waiter implements Runnable{
    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                synchronized (this) {
                    wait();
                    System.out.println("Waiter after wait");
                }
            }
        } catch (InterruptedException e) {
            System.out.println("Waiter is done");
        }
    }
}
