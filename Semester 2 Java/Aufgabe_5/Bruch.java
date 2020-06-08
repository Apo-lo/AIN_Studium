package Aufgabe_5;

@SuppressWarnings("rawtypes")
public class Bruch implements Comparable<Bruch> {
    public int nenner;
    public int zaehler;

    private int ggT(int a, int b) {
        if (b>a) {
            return (ggT(b,a));
        }
        else {
            if (b==0) {
                return a;
            }
            else return ggT(b,a%b);
        }
    }

    private int kgV(int a, int b) {
        return (a * b) / ggT(a, b);
    }

    private void kuerzen() {
        int temp = ggT(zaehler, nenner);
        zaehler /= temp;
        nenner /= temp;
    }


    public Bruch(int z, int n) {
        zaehler = z;
        nenner = n;
        kuerzen();
    }

    public void add(Bruch x) {
        int temp = kgV(nenner, x.nenner);
        zaehler = zaehler * (temp / nenner) + x.zaehler * (temp / x.nenner);
        nenner = temp;
        kuerzen();
    }

    public void sub(Bruch x) {
        int temp = kgV(nenner, x.nenner);
        zaehler = zaehler * (temp / nenner) - x.zaehler * (temp / x.nenner);
        nenner = temp;
        kuerzen();
    }

    public void multi(Bruch x) {
        zaehler *= x.zaehler;
        nenner *= x.nenner;
        kuerzen();
    }

    public void div(Bruch x) {
        zaehler *= x.nenner;
        nenner *= x.zaehler;
        kuerzen();
    }

    public String get() {
        return (zaehler + "/" + nenner);
    }

    public String toString() {
        return (zaehler + "/" + nenner);
    }

    public int compareTo(Bruch x) {

        double bruch1 = zaehler/nenner;
        double bruch2 = x.zaehler/x.nenner;

        if (bruch1 > bruch2)
            return 1;
        else if (bruch1 < bruch2)
            return -1;
        else return 0;
    }

}
