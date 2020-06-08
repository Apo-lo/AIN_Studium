//Original
import java.util.*;

class Bereich {

    private List<int[]> positionen = new LinkedList<int[]>();

    synchronized private boolean gehoertPixelZuDiesemBereich(int[] position) {
        Iterator<int[]> bereichsPositionen = positionen.iterator();

        while(bereichsPositionen.hasNext()) {
            int[] bereichsPosition = bereichsPositionen.next();
            if (bereichsPosition[0] == position[0] && bereichsPosition[1] == position[1]) {
                return true;
            }
        }

        return false;
    }

    void setzePositionen(List<int[]> positionen) {
        this.positionen = positionen;
    }



    private int[] kopierePosition(int[] position) {
        int[] kopie = new int[]{position[0], position[1]};
        return kopie;
    }

    private List<int[]> kopierePositionen() {
        List<int[]> kopie = new LinkedList<int[]>();

        for (int[] position : positionen) {
            kopie.add(kopierePosition(position));
        }

        return kopie;
    }

    Bereich gibKopie() {
        Bereich kopie = new Bereich();
        kopie.setzePositionen(this.gibKopieVonPositionen());
        return kopie ;
    }

    synchronized void drucke() {
        System.out.print("[");
        for (int[] position : this.positionen) {
            System.out.print("(" + position[0] + " " + position[1] + ")");
        }
        System.out.print("]");
        System.out.println();

    }

    // gibt eine Kopie, damit das Objekt schnell wieder entsperrt werden kann
    List<int[]> gibKopieVonPositionen() {
        return this.kopierePositionen();
    }

    int gibZahlSchwarzerPixel() {
        return positionen.size();
    }

    synchronized boolean enthaelt(int[] position) {

        for(int[] aktPosition : positionen) {
            if (aktPosition[0] == position[0] && aktPosition[1] == position[1]) {
                return true;
            }
        }

        return false;
    }

    // doppelte Positionen sollen nicht vorkommen
    synchronized void add(int[] position) {
        if (!enthaelt(position)) {
            positionen.add(position);
        }
    }

    synchronized void add(Bereich fremderBereich) {
        Iterator<int[]> it = fremderBereich.gibKopieVonPositionen().iterator();

        while(it.hasNext()) {
            int[] position = it.next();
            if (!this.gehoertPixelZuDiesemBereich(position)) {
                this.positionen.add(position);
            }
        }

    }



    Bereich gibSchnittbereich(Bereich fremderBereich) {
        Iterator<int[]> it = this.positionen.iterator();
        Bereich schnittmenge = new Bereich();

        while(it.hasNext()) {
            int[] position = it.next();
            if (fremderBereich.gehoertPixelZuDiesemBereich(position)) {
                schnittmenge.add(position);
            }
        }

        return schnittmenge;
    }

    synchronized boolean schneidet(Bereich fremderBereich) {
        Iterator<int[]> it = this.positionen.iterator();

        while(it.hasNext()) {
            int[] position = it.next();
            if (fremderBereich.gehoertPixelZuDiesemBereich(position)) {
                return true;
            }
        }

        return false;
    }
}

