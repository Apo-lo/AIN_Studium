package Aufgabe_6;

class EUR_Muenze extends EUR implements Muenze {
    private eigenschaften x;

    public EUR_Muenze(double wert) {
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
        final eigenschaften daten[] = {new eigenschaften(0.01,  2.30, 16.25, 1.67),
                new eigenschaften(0.02,  3.06, 18.75, 1.67),
                new eigenschaften(0.05,  3.92, 21.25, 1.67),
                new eigenschaften(0.10,  4.10, 19.75, 1.93),
                new eigenschaften(0.20,  5.74, 22.25, 2.14),
                new eigenschaften(0.50,  7.80, 24.25, 2.38),
                new eigenschaften(1.00,  7.50, 23.25, 2.33),
                new eigenschaften(2.00,  8.50, 25.75, 2.20)};
        for (eigenschaften x:daten)
            if (getWert()==x.wert)
                return x;
        return null;
    }

}

