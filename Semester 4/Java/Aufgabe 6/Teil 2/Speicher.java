
import java.util.LinkedList;
import java.util.concurrent.locks.ReentrantReadWriteLock;

class Speicher extends LinkedList<String> {
    ReentrantReadWriteLock lock;

    private int schreibendeThreads;
    private int lesendeThreads;

    Speicher() {
        lock = new ReentrantReadWriteLock();

        schreibendeThreads = 0;
        lesendeThreads = 0;
    }

    void writeLine(String zeile) {
        try {
            Thread.sleep((long)(Math.random() * 2000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.add(zeile);
    }

    String readLine(int zeilenNummer) {
        try {
            Thread.sleep((long)(Math.random() * 2000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            return this.get(zeilenNummer);
        } catch (IndexOutOfBoundsException e) {
            return null;
        }
    }

    synchronized void schreiberRein() {
        ++schreibendeThreads;
        System.out.println("Schreibende Threads erhoeht auf: " + schreibendeThreads);
    }

    synchronized void schreiberRaus() {
        System.out.println("Schreibende Threads verringert auf: " + --schreibendeThreads);
    }

    synchronized void leserRein() {
        System.out.println("Lesende Threads erhoeht auf: " + ++lesendeThreads);
    }

    synchronized void leserRaus() {
        System.out.println("Lesende Threads verringert auf: " + --lesendeThreads);
    }
}
