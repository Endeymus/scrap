package com.endeymus.scrap.multithreading.blockingqueue.toast;

import java.util.concurrent.TimeUnit;

/**
 * @author Mark Shamray
 */
public class Toaster implements Runnable{
    private ToastQueue toasts;
    private int count = 0;
    public Toaster(ToastQueue toasts) {
        this.toasts = toasts;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()){
                TimeUnit.MILLISECONDS.sleep(200);
                Toast toast = new Toast(count++);
                System.out.println(toast);
                toasts.put(toast);
            }
        } catch (InterruptedException e) {
            System.out.println("Toaster interrupted");
        }
        System.out.println("Toaster off!");
    }
}
