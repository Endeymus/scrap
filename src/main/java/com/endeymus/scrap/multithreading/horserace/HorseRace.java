package com.endeymus.scrap.multithreading.horserace;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author Mark Shamray
 */
public class HorseRace {
    static final int FINISH_LINE = 75;
    private List<Horse> horses = new ArrayList<>();
    private ExecutorService exec = Executors.newCachedThreadPool();
    private CyclicBarrier barrier;

    public HorseRace(int nHorses, final int pause) {
        barrier = new CyclicBarrier(nHorses, ()->{
            System.out.println("=".repeat(FINISH_LINE));
            for (Horse hors : horses) {
                System.out.println(hors.tracks());
            }
            for (Horse hors : horses) {
                if (hors.getStrides() >= FINISH_LINE){
                    System.out.println(hors + " won!");
                    exec.shutdownNow();
                    return;
                }
                try {
                    TimeUnit.MILLISECONDS.sleep(pause);
                } catch (InterruptedException e) {
                    System.out.println("barrier-action sleep interrupted");
                }
            }
        });
        for (int i = 0; i < nHorses; i++) {
            Horse horse = new Horse(barrier);
            horses.add(horse);
            exec.execute(horse);
        }
    }

    public static void main(String[] args) {
        int nHorses = 7;
        int pause = 25;
        new HorseRace(nHorses, pause);
    }
}
