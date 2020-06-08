
import java.util.concurrent.*;
import java.util.concurrent.atomic.*;
import java.util.*;

class BereichFinder implements Runnable {

    // Alle Dinge, die alle Threads gemeinsam benutzen sind static.
    static final int ZAHL_THREADS = 10;

    static Erzeuger erzeuger = new Erzeuger();

    static Collection<BereichFinder> alleFinder = new ConcurrentLinkedQueue();
    //static Set<BereichFinder> alleFinder = new HashSet<BereichFinder>();

    static Collection<BereichFinder> gibAlleFinder() {
        // zu implementieren
        return BereichFinder.alleFinder;
    }
                                                //--
    static CyclicBarrier gemeinsamerStop  = new CyclicBarrier(ZAHL_THREADS,new Runnable() {

        @Override
        public void run() {
            erzeuger.bereicheEinfaerben(alleFinder);

        }
    } );//<hier ein Runnable Objekt uebergeben, dass die Methode bereicheEinfaerben der Klasse Erzeuger aufruft>);

                //--
    static SynchronousQueue<Runnable> queue = new SynchronousQueue<Runnable>();
    //static LinkedBlockingQueue<Runnable> queue = new LinkedBlockingQueue<Runnable>();

    public static void main(String[] args) {            //--
        ThreadPoolExecutor pool = new ThreadPoolExecutor(ZAHL_THREADS,ZAHL_THREADS,1, TimeUnit.SECONDS , queue); // konstante Thread Zahl


        List<int[]> positions = erzeuger.gibKopieSchwarzePixel();       //--
        int[] reihenfolge = Utility.gibZufaelligeReihenfolge(positions.size()); //--


        for (int i = 0; i < ZAHL_THREADS; i++) {
            BereichFinder finder = new BereichFinder(i,positions.get(reihenfolge[i]));//--
            // finder in den Pool "alleFinder" einfuegen - wird fuer Einfaerben der Bereich gebraucht
            alleFinder.add(finder);
            // finder in den ThreadPool einfuegen
            pool.execute(finder);
        }
    }

    // Die folgenden Attribute hat jeder Thread fuer sich alleine
    private int nummer = 0;

    int[] aktuellePosition = null;

    Bereich bereich = new Bereich();

    int gibNummer() {
        return nummer;
    }

    void setzeNummer(int nummer) {
        this.nummer = nummer;
    }



    public void run() {
        while (true) {
            // ein neues Schwarzes Pixel suchen
            this.sucheSchwarzesPixel(erzeuger.gibBild(), this.aktuellePosition);
            // neues schwarzes Pixel dem Bereich dieses BereichFinders hinzufuegen
            this.bereich.add(this.aktuellePosition);
            // wenn alle Threads warten, werden die Bereiche in der Darstellung
            // eingefaerbt - das macht das Runnable, das man dem
            // Konstruktor von CyclicBarrier mitgegeben hat

            try {
                gemeinsamerStop.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
    }


    int[] gibAktPosition() {
        // zu implementieren
        return this.aktuellePosition;
    }

    /*
     * die Position eines Pixels ist eine int Feld mit zwei Plaetzen: int[0] ist
     * die Zeilennummer, int[1] ist die Spaltennummer des Pixels
     */
    void setzeAktPosition(int[] position) {
        // zu implementieren
        this.aktuellePosition = position;
    }

    Bereich gibBereich() {
        // zu implementieren
        return this.bereich;
    }


    BereichFinder(int nummer, int[] startPosition) {
        // zu implementieren
        this.nummer = nummer;
        this.aktuellePosition = startPosition;
        this.bereich = new Bereich();
        this.bereich.add(startPosition);
    }

    /*
     * Diese Methode liefert true, wenn ein NachbarPixel gefunden wurde und
     * false, wenn keines gefunden wurde. In aktPosition steht nach Ausführung der
     * Methode die evtl. neu gefundene Postition eines schwarzen Pixels
     */
    private boolean sucheSchwarzesPixel(boolean[][] bild, int[] aktPosition) {
        int zeilenNr = aktPosition[0];
        int spaltenNr = aktPosition[1];

        int[] zeilenShift = { -1, 0, 1, 0 }; // oberes Pixel, rechtes,
        // unteres, linkes
        int[] spaltenShift = { 0, 1, 0, -1 };

        // In welcher Reihenfolge sollen die Nachbarpixel untersucht werden ?
        int[] reihenfolge = Utility.gibZufaelligeReihenfolge(4);

        for (int i = 0; i < 4; i++) {
            int zeilenNrNachbar = zeilenNr + zeilenShift[reihenfolge[i]];
            int spaltenNrNachbar = spaltenNr + spaltenShift[reihenfolge[i]];

            // Ist Nachbar ausserhalb vom Bild?
            if (zeilenNrNachbar >= 0 && zeilenNrNachbar < bild.length
                    && spaltenNrNachbar >= 0
                    && spaltenNrNachbar < bild[0].length) {
                // ist Nachbar Pixel schwarz?
                if (bild[zeilenNrNachbar][spaltenNrNachbar]) {
                    aktPosition[0] = zeilenNrNachbar;
                    aktPosition[1] = spaltenNrNachbar;

                    System.out.println("Finder Nr.: " + this.nummer
                            + " Neue aktPosition: " + zeilenNrNachbar + " "
                            + spaltenNrNachbar);

                    return true;
                }
            }
        }

        // kein schwarzes Pixel benachbart = Einzelpixel
        return false;
    }

}