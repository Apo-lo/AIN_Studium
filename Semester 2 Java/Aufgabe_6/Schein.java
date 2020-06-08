package Aufgabe_6;

public interface Schein {
    public double getLaenge();
    public double getBreite();

    class eigenschaften {
        double wert;
        double laenge;
        double breite;
        eigenschaften(double wert, double laenge, double breite){
            this.wert=wert;
            this.laenge=laenge;
            this.breite=breite;
        }
    };

}
