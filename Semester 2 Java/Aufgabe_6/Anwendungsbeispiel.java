package Aufgabe_6;

public class Anwendungsbeispiel {

    private static void aufgabe2(Zahlungsmittel[] geld) {
        double sumSFR = 0.00, sumEUR = 0.00, sumUSD = 0.00;
        for (int i = 0; i < geld.length; i++) {
            if (geld[i] instanceof SFR)
                sumSFR = sumSFR + geld[i].getWert();
            if (geld[i] instanceof EUR)
                sumEUR = sumEUR + geld[i].getWert();
            if (geld[i] instanceof USD)
                sumUSD = sumUSD + geld[i].getWert();
        }
        System.out.println("Summe SFR: " + sumSFR);
        System.out.println("Summe EUR: " + sumEUR);
        System.out.println("Summe USD: " + sumUSD);
    }

    private static void aufgabe3(Zahlungsmittel[] geld) {
        double gewicht = 0, flaeche = 0;

        for (int i = 0; i < geld.length; i++) {
            if (geld[i] instanceof Muenze) {
                gewicht = gewicht + ((Muenze) geld[i]).getGewicht();
            }

            if (geld[i] instanceof Schein) {
                flaeche = flaeche + ((Schein) geld[i]).getLaenge() * ((Schein) geld[i]).getBreite();
            }
        }
        System.out.println("Gewicht Muenzen: " + gewicht + " g");
        System.out.println("Flaeche Scheine: " + flaeche + " cm^2");
    }

    private static void aufgabe4(Zahlungsmittel[] geld) {
        double hoehe = 0;
        for (int i = 0; i < geld.length; i++)
            if (geld[i] instanceof Muenze)
                hoehe = hoehe + ((Muenze) geld[i]).getDicke();

        System.out.println("Hoehe Muenzstapel: " + hoehe + " cm");
    }


    public static void main(String[] args) {
        Zahlungsmittel geld[]= {
                new USD_Muenze(0.10), new USD_Schein(20),   new SFR_Schein(5),
                new SFR_Muenze(0.50), new USD_Muenze(0.50), new EUR_Schein(50),
                new USD_Schein(100),  new USD_Muenze(0.2),  new USD_Muenze(0.25),
                new EUR_Muenze(0.01), new SFR_Schein(200),  new USD_Schein(100),
                new EUR_Muenze(2),    new EUR_Schein(5),    new USD_Muenze(0.25),
                new SFR_Muenze(0.10), new SFR_Muenze(0.01), new USD_Muenze(0.50),
                new USD_Schein(100),  new USD_Schein(100),  new USD_Muenze(0.2),
                new USD_Muenze(0.01), new SFR_Schein(20),   new SFR_Muenze(0.50),
                new USD_Muenze(0.50), new EUR_Schein(50),   new USD_Schein(5),
                new EUR_Muenze(0.50), new EUR_Muenze(0.01), new SFR_Schein(10),
                new SFR_Schein(20),   new SFR_Muenze(0.50), new SFR_Muenze(0.02)
        };

        //Aufgabe 1
        int size = geld.length;
        int counter = 0;
        System.out.println("Gültige Zahlungsmittel: ");
        for (int i = 0; i < size; i++) {
            if (geld[i].wertIstGueltig())
                System.out.println(geld[i]);
            else
                counter++;
        }
        System.out.println("Anzahl ungültiger Zahlungsmittel: " + counter);

        int newsize = size - counter;
        Zahlungsmittel[] temp = new Zahlungsmittel[newsize];
        for (int i = 0, j = 0; i < size; i++) {
            if (geld[i].wertIstGueltig())
                temp[j++] = geld[i];
        }
        geld = temp;

        System.out.println();

        //Aufgabe 2
        aufgabe2(geld);
        System.out.println();

        //Aufgabe 3
        aufgabe3(geld);
        System.out.println();

        //Aufgabe 4
        aufgabe4(geld);
        System.out.println();

        //Aufgabe 5
        Sort.mergesort(geld);
        System.out.println("Sortierte Zahlungsmittel:");
        for (int i = 0; i < geld.length; i++) {
            System.out.println(geld[i]);
        }
    }
}
