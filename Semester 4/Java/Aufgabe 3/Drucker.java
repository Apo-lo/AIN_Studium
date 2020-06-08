import java.io.*;
import java.util.concurrent.Semaphore;

class Drucker {
    Semaphore semaphore;

    Drucker()   {
        semaphore = new Semaphore(1);
    }

    void druckeDruckjob(String datei, int anzahl) {
        for (int i=0; i<anzahl; i++) {
            druckeDatei(datei);       //Methode Teilaufgabe 5
        }
    }

     synchronized void druckeDatei(String dateiname) {

        try {
            BufferedReader in = new BufferedReader(
                    new FileReader(dateiname));
            String line = in.readLine();
            while (line != null) {
                System.out.println(line);
                line = in.readLine();
            }
        } catch (Exception e) {
            System.out.println(
                    "Eine Ausnahme ist aufgetreten.");
        }
    }
}
