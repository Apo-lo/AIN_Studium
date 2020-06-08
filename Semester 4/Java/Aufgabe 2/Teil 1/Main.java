
public class Main {

    public static void main(String[] args) {

        Speicherzelle speicherA = new Speicherzelle("A", 11);
        Speicherzelle speicherB = new Speicherzelle("B", 47);

        new MyThread(speicherA, speicherB).start();
        new MyThread(speicherB, speicherA).start();
    }
}
