
public class Main {
    public static void main(String[] args) {
        String[] text1 = {"text 1: Zeile 1", "text 1: Zeile 2"};
        String[] text2 = {"text 2: Zeile 1", "text 2: Zeile 2"};



        Speicher speicher = new Speicher();

        Schreiber s1 = new Schreiber(speicher, text1, 2, speicher.lock.writeLock());
        Schreiber s2 = new Schreiber(speicher, text2, 2, speicher.lock.writeLock());

        Leser l1 = new Leser(speicher, speicher.lock.readLock());
        Leser l2 = new Leser(speicher, speicher.lock.readLock());

        s1.start();
        s2.start();
        l1.start();
        l2.start();
    }
}
