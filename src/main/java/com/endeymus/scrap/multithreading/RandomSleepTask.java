package com.endeymus.scrap.multithreading;

import lombok.SneakyThrows;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author Mark Shamray
 */
public class RandomSleepTask implements Runnable{
    private static Random random = new Random();
    private static int count = 0;
    private int id = count++;
    @SneakyThrows
    @Override
    public void run() {
        int R = random.nextInt(10) + 1;
        TimeUnit.SECONDS.sleep(R);
        System.out.println("#" + id + "(was sleep: " + R + " sec.)");
    }

    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
            exec.execute(new RandomSleepTask());
        }
        exec.shutdown();
    }
}
