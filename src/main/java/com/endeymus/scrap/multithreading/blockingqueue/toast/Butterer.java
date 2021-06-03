package com.endeymus.scrap.multithreading.blockingqueue.toast;

import java.util.concurrent.TimeUnit;

/**
 * @author Mark Shamray
 */
public class Butterer implements Runnable{
    private ToastQueue dry;
    private ToastQueue butter;

    public Butterer(ToastQueue dry, ToastQueue butter) {
        this.dry = dry;
        this.butter = butter;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()){
                Toast t = dry.take();
                t.butter();
                System.out.println(t);
                butter.put(t);
            }
        } catch (InterruptedException e) {
            System.out.println("Butterer interrupted");
        }
        System.out.println("Butterer off!");
    }
}
