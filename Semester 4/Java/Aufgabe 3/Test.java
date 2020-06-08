class Test {

    public static void main (String[] argv) {

        if (argv.length >= 2) {
            Drucker d = new Drucker();
            Benutzer haensel = new Benutzer(d, argv[0], 5, d.semaphore);
            Benutzer gretel = new Benutzer(d, argv[1], 5, d.semaphore);

//            haensel.start();
//            gretel.start():

            new Thread(haensel).start();    //---Veränderung für Teilaufage 1---
            new Thread(gretel).start();     //---Veränderung für Teilaufage 1---

        } else {
            System.out.println(
                    "Bitte zwei Dateinamen als Argumente uebergeben!");
        }
    }
}


// Teilaufgabe 2 von Thread wird geerbt Runnable ist ein Interface
// In Java kann eine Klasse nur von einer Klasse erben deswegen will man das die Funktionalität nicht über veerung geschieht
// da sonst die Klassen keine andere parants Klasse haben können

// Teilaugabe 3 Wird ein Thread innerhalb der while-Schleife indruckeDatei() vom Scheduler blockiert wird der Druckvorgang
// des einen Jobs abgebrochen und mit dem anderen Druckjob weitergemacht, was zueiner Vermischung der Druckjobs führen kann.
// Auch kann es sein, dass sich das Drucken der Dateienvermischt.

// Teilaufgabe 4 Dies kann durch synchronized vor derdruckeDatei() Methode verhindert werden. Dies führt dazu, dass die
// Druckjobs der Threads zwar noch unterbrochen werden können, aber erst nach Vollendung einer Datei,
// dadruckeDatei() nicht mehr von zwei Threads gleichzeitig aufgerufen werdenkann.