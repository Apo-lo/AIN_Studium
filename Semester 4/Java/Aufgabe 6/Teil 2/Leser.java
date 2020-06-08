
import java.util.concurrent.locks.ReentrantReadWriteLock;

class Leser extends Thread {
    private Speicher speicher;
    private ReentrantReadWriteLock.ReadLock lock;

    Leser(Speicher speicher, ReentrantReadWriteLock.ReadLock lock) {
        this.speicher = speicher;
        this.lock = lock;
    }

    public void run() {
        for(int i=0; i<4; i++) {
            lock.lock();
            speicher.leserRein();

            if(speicher.readLine(i) != null)
                System.out.println(speicher.readLine(i));
            else
                i--;

            speicher.leserRaus();
            lock.unlock();
        }
    }
}
