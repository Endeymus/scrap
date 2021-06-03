package com.endeymus.scrap.multithreading.blockingqueue.toast;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author Mark Shamray
 */
public class ToastOMatic {
    public static void main(String[] args) throws InterruptedException {
        ToastQueue dry = new ToastQueue(),
                buttered = new ToastQueue(),
                finished = new ToastQueue();
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(new Toaster(dry));
        exec.execute(new Butterer(dry, buttered));
        exec.execute(new Jammer(buttered, finished));
        exec.execute(new Eater(finished));
        TimeUnit.SECONDS.sleep(5);
        exec.shutdownNow();
    }
}
