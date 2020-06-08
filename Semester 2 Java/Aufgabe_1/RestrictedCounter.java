package Aufgabe_1;

public class RestrictedCounter extends Counter{
    private int capacity;

    //Konstruktor
    public RestrictedCounter(int c) {
        super();
        capacity = c;
    }

    public void increment() {
        if(counter < capacity) {
            counter++;
        }
        else System.out.println("+++ max. capacity reached +++");
    }

    public void decrement() {
        if(counter > 0) {
            counter--;
        }
        else {
            System.out.println("+++ counter can't be negative +++");
        }
    }

    public int freeCapacity() {
        return (capacity - counter);
    }
}
