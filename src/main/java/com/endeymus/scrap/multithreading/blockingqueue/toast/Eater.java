package com.endeymus.scrap.multithreading.blockingqueue.toast;

/**
 * @author Mark Shamray
 */
public class Eater implements Runnable{
    protected ToastQueue finished;
    private int counter = 0;

    public Eater(ToastQueue finished) {
        this.finished = finished;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()){
                Toast t = finished.take();
                if (t.getId() != counter++ || t.getStatus() != Toast.Status.JAMMED) {
                    System.out.println(">>> Error: " + t);
                    System.exit(1);
                } else {
                    System.out.println("Chomp! " + t);
                }
            }
        } catch (InterruptedException e) {
            System.out.println("Eater interrupted");
        }
        System.out.println("Eater off!");
    }
}
