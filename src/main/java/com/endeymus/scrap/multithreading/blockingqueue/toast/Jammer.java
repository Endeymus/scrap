package com.endeymus.scrap.multithreading.blockingqueue.toast;

import java.util.concurrent.TimeUnit;

/**
 * @author Mark Shamray
 */
public class Jammer implements Runnable{
    protected ToastQueue butter;
    protected ToastQueue jammer;

    public Jammer(ToastQueue butter, ToastQueue jammer) {
        this.butter = butter;
        this.jammer = jammer;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()){
                Toast t = butter.take();
                t.jam();
                System.out.println(t);
                jammer.put(t);
            }
        } catch (InterruptedException e) {
            System.out.println("Jammer interrupted");
        }
        System.out.println("Jammer off!");

    }

}
