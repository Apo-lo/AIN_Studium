package Aufgabe_6;

public abstract class EUR extends Zahlungsmittel {
    public EUR(double wert) {
        super("EUR", wert);
    }
    public abstract boolean wertIstGueltig();
}

