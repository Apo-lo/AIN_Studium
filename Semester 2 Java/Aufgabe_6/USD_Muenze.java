package Aufgabe_6;

class USD_Muenze extends USD implements Muenze {
    private eigenschaften x;

    public USD_Muenze(double wert) {
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
        final eigenschaften daten[] = {new eigenschaften(0.01,  2.50, 19.05, 1.55),
                new eigenschaften(0.05,  5.00, 21.21, 1.95),
                new eigenschaften(0.10,  2.27, 19.91, 1.35),
                new eigenschaften(0.25,  5.67, 24.26, 1.75),
                new eigenschaften(0.50, 11.34, 30.61, 2.15),
                new eigenschaften(1.00,  8.10, 26.50, 2.00)};
        for (eigenschaften x:daten)
            if (getWert()==x.wert)
                return x;
        return null;
    }

}
