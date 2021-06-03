package com.endeymus.scrap.multithreading.restraurant;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Mark Shamray
 */
public class WaitPersonal implements Runnable{
    private Restaurant restaurant;
    public boolean needClean = false;
    public Lock lock = new ReentrantLock();
    public Condition condition = lock.newCondition();

    public WaitPersonal(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    @Override
    public void run() {
        try{
            while (!Thread.interrupted()) {
                lock.lock();
                try {
                    while (restaurant.meal == null || needClean)
                        condition.await();
                } finally {
                    lock.unlock();
                }
                System.out.println("WaitPerson got " + restaurant.meal);
                restaurant.chef.lock.lock();
                try{
                    restaurant.meal = null;
                    restaurant.chef.condition.signalAll();
                } finally {
                    restaurant.chef.lock.unlock();
                }
                restaurant.busBoy.lock.lock();
                try {
                    needClean = true;
                    restaurant.busBoy.condition.signalAll();
                } finally {
                    restaurant.busBoy.lock.unlock();
                }
            }
        } catch (InterruptedException e) {
            System.out.println("WaitPersonal interrupted");
        }
    }
}
