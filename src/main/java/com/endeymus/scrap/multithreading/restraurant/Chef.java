package com.endeymus.scrap.multithreading.restraurant;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Mark Shamray
 */
public class Chef implements Runnable {
    private Restaurant restaurant;
    private int count = 0;
    public Lock lock = new ReentrantLock();
    public Condition condition = lock.newCondition();

    public Chef(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()){
                lock.lock();
                try {
                    while (restaurant.meal != null) {
                        condition.await();
                    }
                } finally {
                    lock.unlock();
                }
                if (++count == 10) {
                    System.out.println("Out of food, Closing!");
                    restaurant.exec.shutdownNow();
                }
                System.out.println("Order up! ");
                restaurant.waitPersonal.lock.lock();
                try {
                    restaurant.meal = new Meal(count);
                    restaurant.waitPersonal.condition.signalAll();
                } finally {
                    restaurant.waitPersonal.lock.unlock();
                }
                TimeUnit.MILLISECONDS.sleep(100);
            }
        } catch (InterruptedException e) {
            System.out.println("Chef interrupted");
        }
    }
}
