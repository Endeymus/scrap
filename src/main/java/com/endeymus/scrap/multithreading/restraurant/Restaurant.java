package com.endeymus.scrap.multithreading.restraurant;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Mark Shamray
 */
public class Restaurant {
    public Chef chef = new Chef(this);
    public WaitPersonal waitPersonal = new WaitPersonal(this);
    public BusBoy busBoy = new BusBoy(this);
    public ExecutorService exec = Executors.newCachedThreadPool();
    Meal meal;

    public Restaurant() {
        exec.execute(chef);
        exec.execute(waitPersonal);
        exec.execute(busBoy);
    }

    public static void main(String[] args) {
        new Restaurant();
    }
}
