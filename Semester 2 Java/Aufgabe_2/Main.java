package Aufgabe_2;

import Aufgabe_5.Bruch;

public class Main {
    //Aufgabe 1:
    private static void aufgabe_1() {
        Bruch x = new Bruch(1,2);          // x= 1/2
        Bruch y = new Bruch(2,3);          // y= 2/3
        y.add(x);                               // 2/3 + 1/2 = 4/6 + 3/6
        System.out.println("y= " + y.get());    // y= 7/6
    }

    //Aufgabe 2:
    private static void aufgabe_2() {
        int n = 5;
        Bruch s = new Bruch(0, 1);

        for(int i = 1; i <= n; i++) {
            s.add(new Bruch(1, i));
        }
        System.out.println("s = " + s.get());

    }

    //Aufgabe 3:
    private static int fakultaet(int n) {
        if(n == 0) {
            return 1;
        }
        else {
            int erg = n;
            for(int i = n-1; i > 0; i--) {
                erg = erg * i;
            }
            return erg;
        }
    }

    private static Bruch e(int n) {
        Bruch s = new Bruch(0, 1);

        for(int i = 0; i <= n; i++) {
            int fak_i = fakultaet(i);
            s.add(new Bruch(1, fak_i));
        }
        return s;
    }

    private static void aufgabe_3() {
        int n = 8;
        Bruch x = e(n);
        System.out.println(x.zaehler/(float)x.nenner);
    }

    public static void main(String[] args) {
        aufgabe_1();
        aufgabe_2();
        aufgabe_3();
    }
}
