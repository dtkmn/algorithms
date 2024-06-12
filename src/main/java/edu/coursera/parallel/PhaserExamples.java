package edu.coursera.parallel;

import java.util.concurrent.Phaser;

public class PhaserExamples {

    public static void main(String[] args) {
        System.out.println("Run Threads...");

        final Phaser ph0 = new Phaser(1);
        final Phaser ph1 = new Phaser(1);
        final Phaser ph2 = new Phaser(1);

        Thread t0 = new Thread(() -> {
            doWork(100);
            ph0.arrive();
            System.out.println("Arrive on thread t0");
            ph1.awaitAdvance(0);
            doWork(100);
            System.out.println("Finish work on t0");
        });

        Thread t1 = new Thread(() -> {
           doWork(200);
           ph1.arrive();
           System.out.println("Arrive on thread t1");
           ph0.awaitAdvance(0);
           ph2.awaitAdvance(0);
           doWork(100);
           System.out.println("Finish work on t1");
        });

        Thread t2 = new Thread(() -> {
           doWork(300);
           ph2.arrive();
           System.out.println("Arrive on thread t2");
           ph1.awaitAdvance(0);
           doWork(100);
           System.out.println("Finish work on t2");
        });

        t0.start();
        t1.start();
        t2.start();


        try {
            t0.join();
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void doWork(int n) {
        try {
            Thread.sleep(n * 100L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
