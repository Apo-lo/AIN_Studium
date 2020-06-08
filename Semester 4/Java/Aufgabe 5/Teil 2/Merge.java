package main;

import java.util.concurrent.Semaphore;

class Merge extends Thread {
    private Queue input;
    private Queue output;

    private Semaphore semaphore_input;
    private Semaphore semaphore_output;

    Merge(Queue input, Queue output) {
        this.input = input;
        this.output = output;

        semaphore_input = input.semaphore;
        semaphore_output = output.semaphore;
    }

    @Override
    public void run() {
        int temp;

        try {
            while(true) {
                semaphore_input.acquire();
                if (!input.isEmpty()) {
                    temp = input.get();
                    semaphore_input.release();
                    semaphore_output.acquire();
                    output.put(temp);
                    semaphore_output.release();
                } else {
                    semaphore_input.release();
//                    semaphore_input.wait();
                    sleep(1000);
                }
            }
        } catch (InterruptedException e) {
            System.out.println("Merge von " + input.getName() + " wurde unterbrochen.");
            input.print();
        } finally {
            while(!input.isEmpty()) {
                temp = input.get();
                output.put(temp);

                semaphore_input.release();
                semaphore_output.release();
            }
        }
    }
}