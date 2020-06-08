package Aufgabe_6;

public interface Muenze {
    public double getGewicht();
    public double getDurchmesser();
    public double getDicke();

    class eigenschaften {
        double wert;
        double gewicht;
        double durchmesser;
        double dicke;
        eigenschaften(double wert, double gewicht, double durchmesser, double dicke){
            this.wert=wert;
            this.gewicht=gewicht;
            this.durchmesser=durchmesser;
            this.dicke=dicke;
        }
    };
}
