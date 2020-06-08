package Aufgabe_6;

public class SFR_Schein extends SFR implements Schein{
    private eigenschaften x;

    public SFR_Schein(double wert) {
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
        final eigenschaften daten[] = {new eigenschaften(  10,  74.00, 126.00),
                new eigenschaften(  20,  74.00, 137.00),
                new eigenschaften(  50,  74.00, 148.00),
                new eigenschaften( 100,  74.00, 159.00),
                new eigenschaften( 200,  74.00, 170.00),
                new eigenschaften(1000,  74.00, 181.00)};
        for (eigenschaften x:daten)
            if (getWert()==x.wert)
                return x;
        return null;
    }

}

