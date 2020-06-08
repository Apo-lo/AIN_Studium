package Aufgabe_6;

public class SFR_Muenze extends SFR implements Muenze {
    private eigenschaften x;

    public SFR_Muenze(double wert) {
        super(wert);
        x=select(wert);
    }

    public boolean wertIstGueltig() {
        return x!=null;
    }

    public double getGewicht() {
        if (x!=null)
            return x.gewicht;
        else
            return 0;
    }

    public double getDurchmesser() {
        if (x!=null)
            return x.durchmesser;
        else
            return 0;
    }

    public double getDicke() {
        if (x!=null)
            return x.dicke;
        else
            return 0;
    }


    eigenschaften select(double wert) {
        final eigenschaften daten[] = {new eigenschaften(0.05,  1.80, 17.15, 1.25),
                new eigenschaften(0.10,  3.00, 19.15, 1.45),
                new eigenschaften(0.20,  4.00, 21.05, 1.65),
                new eigenschaften(0.50,  2.20, 18.20, 1.25),
                new eigenschaften(1.00,  4.40, 23.20, 1.55),
                new eigenschaften(2.00,  8.80, 27.40, 2.15),
                new eigenschaften(5.00, 13.20, 31.45, 2.35)};
        for (eigenschaften x:daten)
            if (getWert()==x.wert)
                return x;
        return null;
    }

}

