package Aufgabe_1;

public class Counter {
    protected int counter;
    protected int saved_counter;
    protected boolean saved;

    //Konstruktor
    public Counter() {
        counter = 0;
        saved_counter = 0;
        saved = false;
    }

    public void increment() {
        counter++;
    }

    public void decrement() {
        if(counter > 0) counter--;
    }

    public int get() {
        return counter;
    }

    public void save() {
        saved_counter = counter;
        saved = true;
    }

    public void restore() {
        if(saved) counter = saved_counter;
        else System.out.println("+++ no saved counter +++");
        saved = false;
    }

    public void reset() {
        counter = 0;
    }
}

