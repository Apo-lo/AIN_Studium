package Aufgabe_6;

public class EUR_Schein extends EUR implements Schein {
    private eigenschaften x;

    public EUR_Schein(double wert) {
        super(wert);
        x=select(wert);
    }
    public boolean wertIstGueltig() {
        return x!=null;
    }

    public double getLaenge() {
        return (x!=null) ? x.laenge : 0;
    }

    public double getBreite() {
        return (x!=null) ? x.breite : 0;
    }


    private eigenschaften select(double wert) {
        final eigenschaften daten[] = {new eigenschaften(  5, 120.00, 62.00),
                new eigenschaften( 10, 127.00, 67.00),
                new eigenschaften( 20, 133.00, 72.00),
                new eigenschaften( 50, 140.00, 77.00),
                new eigenschaften(100, 147.00, 82.00),
                new eigenschaften(200, 153.00, 82.00),
                new eigenschaften(500, 160.00, 82.00)};
        for (eigenschaften x:daten)
            if (getWert()==x.wert)
                return x;
        return null;
    }

}
