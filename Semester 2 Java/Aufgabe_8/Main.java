package Aufgabe_8;

import java.util.*;

public class Main {

    private static void aufgabe1u2() {
        ArrayList<String> li = new ArrayList<String>();
        li.add("Montag");
        li.add("Dienstag");
        li.add("Mittwoch");
        li.add("Donnerstag");
        li.add("Freitag");
        li.add("Samstag");
        li.add("Sonntag");


        TreeSet<String> bb = new TreeSet<String>();
        bb.addAll(li);


        HashSet<String> ht = new HashSet<String>();
        ht.addAll(li);

        //aufgabe1(li, bb, ht);
        aufgabe2(li, bb, ht);
    }

    private static void aufgabe1(ArrayList<String> li, TreeSet<String> bb, HashSet<String> ht) {
        System.out.println("Ausgabe li:");
        for (String s: li)
            System.out.println(s);
        System.out.println();

        System.out.println("Ausgabe bb:");
        for (String s: bb)
            System.out.println(s);
        System.out.println();

        System.out.println("Ausgabe ht:");
        for (String s: ht)
            System.out.println(s);
        System.out.println();
    }

    private static void aufgabe2(ArrayList<String> li, TreeSet<String> bb, HashSet<String> ht) {
        System.out.println("Ausgabe li:");
        for (Iterator<String> it = li.iterator(); it.hasNext(); ) {
            System.out.println(it.next());
            if (it.hasNext())
                it.next();
        }
        System.out.println();

        System.out.println("Ausgabe bb:");
        for (Iterator<String> it = bb.iterator(); it.hasNext(); ) {
            System.out.println(it.next());
            if (it.hasNext())
                it.next();
        }
        System.out.println();

        System.out.println("Ausgabe ht:");
        for (Iterator<String> it = ht.iterator(); it.hasNext(); ) {
            System.out.println(it.next());
            if (it.hasNext())
                it.next();
        }
        System.out.println();

//		for (int i = 0; i < li.size(); i+=2) {
//		if (i%2 != 0) {
//			String s = li.get(i);
//			System.out.println(s);
//			}
//		}
//		System.out.println();
//
//		System.out.println("Ausgabe bb:");
//		for (int i = 0; i < bb.size(); i++) {
//			if (i%2 != 0) {
//				String s = bb.get(i);
//				System.out.println(s);
//			}
//		}
//		System.out.println();
//
//		System.out.println("Ausgabe ht:");
//		for (int i = 0; i < ht.size(); i++) {
//			if (i%2 != 0) {
//				String s = ht.get(i);
//				System.out.println(s);
//				}
//			}
//		System.out.println();
    }

    private static void aufgabe3() {
        int n = 1000;
        SortedSet<Integer> list = new TreeSet<Integer>();

        for (int i = 2; i <= n; i++)
            list.add(i);
        System.out.println("Primzahlen bis 1000:");
        while (!list.isEmpty()) {
            int p = list.first();
            System.out.println(p);
            for(int j = p; j <= n; j = j + p)
                list.remove(j);
        }
        System.out.println();
    }

    private static void aufgabe4() {
        int n = 1000;
        SortedSet<Integer> list = new TreeSet<Integer>();
        ArrayList<Integer> prime = new ArrayList<Integer>();

        for (int i = 2; i <= n; i++)
            list.add(i);
        System.out.println("Primzahlzwillinge bis 1000:");
        while (!list.isEmpty()) {
            int p = list.first();
            prime.add(p);
            for(int j = p; j <= n; j = j + p)
                list.remove(j);
        }


        for (int i = 1; i < prime.size(); i++) {
            int p = prime.get(i-1);
            int q = prime.get(i);

            if (q - p <= 2)
                System.out.println("(" + p + "," + q + ")");
        }
    }

    public static void main(String[] args) {
        aufgabe1u2();
        aufgabe3();
        aufgabe4();
    }
}
