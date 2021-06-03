package com.endeymus.scrap.multithreading;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Mark Shamray
 */
public class Pair {
    private int x;
    private int y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Pair() {
        this(0, 0);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void incrementX() {
        x++;
    }

    public void incrementY() {
        y++;
    }

    @Override
    public String toString() {
        return "x: " + x +
                ", y: " + y;
    }

    public class PairValueNotEqualException extends RuntimeException {
        public PairValueNotEqualException() {
            super("Pair values not equal: " + Pair.this);
        }
    }

    public void checkState() {
        if (x != y) {
            throw new PairValueNotEqualException();
        }
    }
}

    abstract class PairManager {
        AtomicInteger checkCounter = new AtomicInteger(0);
        protected Pair p = new Pair();
        private final List<Pair> storage = Collections.synchronizedList(new ArrayList<>());

        public synchronized Pair getPair() {
            return new Pair(p.getX(), p.getY());
        }

        protected void store(Pair p) {
            storage.add(p);
            try {
                TimeUnit.MILLISECONDS.sleep(50);
            } catch (InterruptedException ignored) {
            }
        }

        public abstract void increment();
    }
    class PairManager1 extends PairManager {

        @Override
        public void increment() {
            p.incrementX();
            p.incrementY();
            store(getPair());
        }
    }

    class PairManager2 extends PairManager {

        @Override
        public void increment() {
            Pair temp;
            synchronized (this) {
                p.incrementX();
                p.incrementY();
                temp = getPair();
            }
            store(temp);
        }
    }

    class PairManipulator implements Runnable {

        private PairManager pm;

        public PairManipulator(PairManager pm) {
            this.pm = pm;
        }

        @Override
        public String toString() {
            return "Pair: " + pm.getPair() + ", checkCounter = " + pm.checkCounter.get();
        }

        @Override
        public void run() {
            while (true)
                pm.increment();
        }
    }

    class PairChecker implements Runnable {

        private PairManager pm;

        public PairChecker(PairManager pm) {
            this.pm = pm;
        }

        @Override
        public void run() {
            while (true) {
                pm.checkCounter.incrementAndGet();
                pm.getPair().checkState();
            }
        }
    }

    class CriticalSelection {
        static void testApproaches(PairManager pairManager1, PairManager pairManager2) {
            ExecutorService exec = Executors.newCachedThreadPool();
            PairManipulator
                    pairManipulator1 = new PairManipulator(pairManager1),
                    pairManipulator2 = new PairManipulator(pairManager2);
            PairChecker
                    pairChecker1 = new PairChecker(pairManager1),
                    pairChecker2 = new PairChecker(pairManager2);
            exec.execute(pairManipulator1);
            exec.execute(pairManipulator2);
            exec.execute(pairChecker1);
            exec.execute(pairChecker2);

            try {
                TimeUnit.MILLISECONDS.sleep(500);
            } catch (InterruptedException e) {
                System.out.println("Sleep interrupted");
            }
            System.out.println("pairManipulator1: " + pairManipulator1 + "\npairManipulator2: " + pairManipulator2);
            System.exit(0);
        }

        public static void main(String[] args) {
            PairManager
                    pairManager1 = new PairManager1(),
                    pairManager2 = new PairManager2();
            testApproaches(pairManager1, pairManager2);
        }
    }
