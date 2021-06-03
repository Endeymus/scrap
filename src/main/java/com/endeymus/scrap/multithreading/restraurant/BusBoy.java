package com.endeymus.scrap.multithreading.restraurant;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Mark Shamray
 */
public class BusBoy implements Runnable {
    private Restaurant restaurant;
    public Lock lock = new ReentrantLock();
    public Condition condition = lock.newCondition();

    public BusBoy(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()){
                lock.lock();
                try {
                    while (!restaurant.waitPersonal.needClean) {
                        condition.await();
                    }
                } finally {
                    lock.unlock();
                }
                System.out.println("Cleaning Up!");

                restaurant.waitPersonal.lock.lock();
                try {
                    restaurant.waitPersonal.needClean = false;
                    restaurant.waitPersonal.condition.signalAll();
                } finally {
                    restaurant.waitPersonal.lock.unlock();
                }
            }
        } catch (InterruptedException e) {
            System.out.println("BusBoy interrupted");
        }
    }
}
