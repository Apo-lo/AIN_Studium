package main;

import java.util.concurrent.Semaphore;

class Queue {
    private int capacity;
    private String name;

    private int head;
    private int tail;
    private int numberOfElements;
    private int[] data;

    Semaphore semaphore;

    Queue(int groesse, String name) {
        this.capacity = groesse;
        this.name = name;

        head = -1;
        tail = -1;
        numberOfElements = 0;
        data = new int[capacity];

        semaphore = new Semaphore(1);
    }

    synchronized void put(int zahl) {
        incrementTail();
        numberOfElements++;
        data[tail] = zahl;
    }

    synchronized int get() {
        incrementHead();
        numberOfElements--;
        int zahl = data[head];
//        data[head] = null;


        if(this.isEmpty()) {
            head = -1;
            tail = -1;
        }

        return zahl;
    }

    private void incrementTail() {
        //Write Position
        tail++;

        if(tail == capacity) {
            tail = 0;
            if (head == -1) {
                head = 0;
            }
            return;
        }

        if(tail == head) {
            incrementHead();
        }
    }

    private void incrementHead() {
        //Read Potition
        head++;

        if (head == capacity) {
            head = 0;
        }
    }

    boolean isEmpty() {
        return (numberOfElements <= 0);
    }

    void print() {
        System.out.print(this.name + ": [");

        int readPos = head;
        for (int i=0; i<capacity; i++) {
            readPos++;
            if (readPos == capacity)
                readPos = 0;

            System.out.print(data[readPos]);
            if (i < capacity-1)
                System.out.print(", ");
        }

        System.out.println("]");
    }

    String getName() {
        return name;
    }
}