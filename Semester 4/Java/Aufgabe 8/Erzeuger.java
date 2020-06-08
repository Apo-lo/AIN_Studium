//original
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.util.List;
import java.util.concurrent.*;

class Erzeuger extends JFrame {
    static final int ZEILEN_ZAHL = 10;
    static final int SPALTEN_ZAHL = 10;
    static final int PIXEL_GROESSE = 50;
    static final double prozentSchwarz = 60;
    static final int OFFSET = 23; // wegen oberer Bildleiste mit Rahmentitel

    static private Erzeuger singleInstance = null;

    static Erzeuger getSingleInstance() {
        return singleInstance;
    }

    // Bild mit schwarzen Pixeln, wo true steht
    static private boolean[][] bild = new boolean[ZEILEN_ZAHL][SPALTEN_ZAHL];

    // Farben der einzelnen Pixel
    static Color[][] farben = new Color[ZEILEN_ZAHL][SPALTEN_ZAHL];

    static Color[] farbAuswahl = { Color.BLUE, Color.CYAN, Color.GREEN,
            Color.MAGENTA, Color.ORANGE, Color.PINK, Color.RED, Color.YELLOW };

    boolean[][] gibBild() {
        return bild;
    }

    public static void main(String[] args) {
        Erzeuger erzeuger = new Erzeuger();
        erzeuger.setSize(SPALTEN_ZAHL * PIXEL_GROESSE, ZEILEN_ZAHL
                * PIXEL_GROESSE + OFFSET);
        erzeuger.setVisible(true);
    }

    static int gibZahlSchwarzerPixel() {
        int zahl = 0;

        for (int zeile = 0; zeile < bild.length; zeile++) {
            for (int spalte = 0; spalte < bild[0].length; spalte++) {
                if (bild[zeile][spalte]) {
                    zahl++;
                }
            }
        }

        return zahl;
    }

    List<int[]> gibKopieSchwarzePixel() {
        List<int[]> schwarzePixelPositionen = new LinkedList<int[]>();

        for (int zeile = 0; zeile < bild.length; zeile++) {
            for (int spalte = 0; spalte < bild[0].length; spalte++) {
                if (bild[zeile][spalte]) {
                    schwarzePixelPositionen.add(new int[] { zeile, spalte });
                }
            }
        }

        return schwarzePixelPositionen;
    }

    Erzeuger() {

        singleInstance = this;

        for (int zeilenNr = 0; zeilenNr < bild.length; zeilenNr++) {
            for (int spaltenNr = 0; spaltenNr < bild[0].length; spaltenNr++) {
                bild[zeilenNr][spaltenNr] = (Math.random() < prozentSchwarz / 100.); // true
                // =
                // schwarz
                if (bild[zeilenNr][spaltenNr]) {
                    farben[zeilenNr][spaltenNr] = Color.BLACK;
                }
            }
        }

        final Exchanger<Object> stopper = new Exchanger<Object>();

        // Weiter durch Maus Klick
        this.getContentPane().addMouseListener(new MouseListener() {
            public void mouseClicked(MouseEvent event) {
                System.out.println("Maus geklickt");
                machWeiter();

            }

            public void mouseEntered(MouseEvent event) {

            }

            public void mousePressed(MouseEvent event) {

            }

            public void mouseReleased(MouseEvent event) {

            }

            public void mouseExited(MouseEvent event) {

            }
        });

        this.setSize(SPALTEN_ZAHL * PIXEL_GROESSE, ZEILEN_ZAHL * PIXEL_GROESSE
                + OFFSET);
        this.setVisible(true);

    }

    synchronized void machWeiter() {
        notify();
    }

    static void bereicheDrucken(List<Bereich> alleBereiche) {
        for (Bereich bereich : alleBereiche) {
            bereich.drucke();
        }
    }

    public void paint(Graphics g) {
        g.clearRect(0, OFFSET, SPALTEN_ZAHL * PIXEL_GROESSE, ZEILEN_ZAHL
                * PIXEL_GROESSE + OFFSET);
        g.setColor(new Color(0, 0, 0));
        for (int zeilenNr = 0; zeilenNr < bild.length; zeilenNr++) {
            for (int spaltenNr = 0; spaltenNr < bild[0].length; spaltenNr++) {
                if (bild[zeilenNr][spaltenNr]) {
                    g.setColor(farben[zeilenNr][spaltenNr]);
                    g.fillRect(spaltenNr * PIXEL_GROESSE, zeilenNr
                                    * PIXEL_GROESSE + OFFSET, PIXEL_GROESSE,
                            PIXEL_GROESSE);
                }
            }
        }

        for (BereichFinder finder : BereichFinder.gibAlleFinder()) {
            int[] position = finder.gibAktPosition();
            g.setColor(Color.LIGHT_GRAY);
            g.fillOval(position[1] * PIXEL_GROESSE, position[0] * PIXEL_GROESSE
                    + OFFSET, PIXEL_GROESSE, PIXEL_GROESSE);
        }

    }

    synchronized void bereicheEinfaerben(Collection<BereichFinder> alleFinder) {
        for (BereichFinder finder : alleFinder) {
            int nummer = finder.gibNummer();
            Bereich bereich = finder.gibBereich();
            List<int[]> positionen = bereich.gibKopieVonPositionen();
            bereichEinfaerben(nummer, positionen);
        }

        repaint();
        try {
            wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private int aktFarbInd = -1;

    // Leider kann nicht garantiert werden, dass nicht zwei unterschiedliche
    // Bereich mit gleicher Farbe
    // aneinandergrenzen
    private int gibAktFarbInd() {
        aktFarbInd = (aktFarbInd + 1) % farbAuswahl.length;
        return aktFarbInd;
    }

    synchronized void bereichEinfaerben(int farbNummer, List<int[]> positionen) {
        for (int[] aktPosition : positionen) {
            Erzeuger.farben[aktPosition[0]][aktPosition[1]] = Erzeuger.farbAuswahl[farbNummer
                    % farbAuswahl.length];
        }
    }
}