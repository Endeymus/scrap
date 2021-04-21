package com.endeymus.scrap.streamapi.ch3;

import java.util.concurrent.TimeUnit;

/**
 * @author Mark Shamray
 */
public class ThreadLambda {
    public static void main(String[] args) {

        for (int j = 0; j < 5; j++) {
            new Thread(() -> {
                int i = 0;
                while (i++ < 5) {
                    try {
                        System.out.println(Thread.currentThread());
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }).start();
        }
    }
}
