import java.util.concurrent.Semaphore;

class Benutzer implements Runnable { //--Veränderung für Teilaufage 1---

    Drucker drucker;
    String dateiname;
    int anzahl;
    private Semaphore semaphore;

    Benutzer(Drucker drucker, String dateiname, int anzahl, Semaphore semaphore) {
        this.drucker = drucker;
        this.dateiname = dateiname;
        this.anzahl = anzahl;
        this.semaphore = semaphore;
    }

    public void run() {
        for (int i=0; i<anzahl; i++) {
            try {
//                semaphore.acquire();
//                drucker.druckeDatei(dateiname);
                drucker.druckeDruckjob(dateiname, anzahl);      //Teilaufgabe 5
            } catch (Exception e) {
                e.printStackTrace();
            }
//            semaphore.release();
        }
    }
}