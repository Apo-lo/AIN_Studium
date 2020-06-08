package Aufgabe_5;

public class Sortierungsbeispiel {


    public static void aufgabe1() {
        System.out.println("Aufgabe 1:");
        Integer[] a= {15, 3, 8, 9, 20, 70, 4, 6};
        Sort.mergesort(a);
        System.out.print("a: ");
        for (int i=0; i<a.length; i++)
            System.out.print(a[i] + " ");
        System.out.println();
    }

    public static void aufgabe2(String[] args) {
        System.out.println();
        System.out.println("Aufgabe 2:");
        Sort.mergesort(args);
        System.out.print("args: ");
        for (int i=0; i<args.length; i++)
            System.out.print(args[i] + " ");
        System.out.println();
    }

    public static void aufgabe3() {
        System.out.println();
        System.out.println("Aufgabe 3:");
        Bruch[] b = new Bruch[5];
        b[0] = new Bruch(7, 3);
        b[1] = new Bruch(1, 2);
        b[2] = new Bruch(2, 3);
        b[3] = new Bruch(3, 5);
        b[4] = new Bruch(3, 4);
        System.out.print("unsortiert: ");
        for (int i=0; i<b.length; i++)
            System.out.print(b[i] + " ");
        System.out.println();

        Sort.mergesort(b);
        System.out.print("sortiert: ");
        for (int i=0; i<b.length; i++)
            System.out.print(b[i] + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        aufgabe1();
        aufgabe2(args);
        aufgabe3();
    }
}
