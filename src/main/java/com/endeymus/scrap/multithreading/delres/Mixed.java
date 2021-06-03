package com.endeymus.scrap.multithreading.delres;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author Mark Shamray
 */
public class Mixed {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService exec = Executors.newCachedThreadPool();
        Waiter waiter = new Waiter();
        exec.execute(waiter);
        exec.execute(new Notifier(waiter));
        TimeUnit.MILLISECONDS.sleep(5100);
        exec.shutdownNow();
    }
}
