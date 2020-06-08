package main;

import java.util.concurrent.Semaphore;

class Einspeiser extends Thread {
    private Integer parameter;
    private Queue target;

    private Semaphore semaphore;

    Einspeiser(Queue zielQueue, int kennWert) {
        this.target = zielQueue;
        this.parameter = kennWert;
        this.semaphore = target.semaphore;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            try {
                semaphore.acquire();
                target.put(parameter);
                System.out.println("Einspeiser hat produziert: " + parameter);

                semaphore.release();
//                semaphore.notify();
                Thread.sleep((long)(Math.random() * 2000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                semaphore.release();
            }
        }
    }
}