
import java.util.concurrent.locks.ReentrantReadWriteLock;

class Schreiber extends Thread {
    private Speicher speicher;
    private String[] text;
    private int zahlWiederholungen;
    private ReentrantReadWriteLock.WriteLock lock;

    Schreiber(Speicher speicher, String[] text, int zahlWiederholungen, ReentrantReadWriteLock.WriteLock lock) {
        this.speicher = speicher;
        this.text = text;
        this.zahlWiederholungen = zahlWiederholungen;
        this.lock = lock;
    }

    public void run() {
        for(int i=0; i<zahlWiederholungen; i++) {
            for(String s : text) {
                lock.lock();
                speicher.schreiberRein();

                speicher.writeLine(s);

                speicher.schreiberRaus();
                lock.unlock();
            }
        }
    }
}
