package Aufgabe_3;

public class CharCounter {
    private int counter;
    private char name;

    public CharCounter(char c) {
        counter = 0;
        name = c;
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

    public char name() {
        return name;
    }
}
