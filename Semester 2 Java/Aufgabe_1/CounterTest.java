package Aufgabe_1;

public class CounterTest {

    public static void main(String[] args) {
        RestrictedCounter c= new RestrictedCounter(15);
        Counter b = new Counter();
        for (int i=0; i<20; ++i) {
            c.increment();
            b.increment();
            System.out.println("c=" + c.get() + " (free capacity=" +
                    c.freeCapacity() + ")" );
        }
        for (int i=0; i<20; ++i) {
            c.decrement();
            b.decrement();
            System.out.println("c=" + c.get() + " (free capacity=" +
                    c.freeCapacity() + ")" );
        }
    }
}
