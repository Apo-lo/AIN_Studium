package Aufgabe_7;

import Aufgabe_5.Bruch;

public class MyListTest {

    public static void main(String[] args) {
        MyList<Integer> l = new MyList<Integer>();
        for (int i = 1; i <= 10; ++i)
            l.add(8 * i);
        l.remove(9);
        for (int i = l.size() - 1; i >=0 ; --i)
            System.out.print(" " + l.get(i));
        System.out.println();

        //Aufgabe 4
        MyList<Bruch> b = new MyList<Bruch>();
        b.add(new Bruch(1,3)); //index: 3
        b.add(new Bruch(2,3)); //index: 2
        b.add(new Bruch(3,5)); //index: 1
        b.add(new Bruch(5,7)); //index: 0 (head)
        b.remove(2);
        for (int i = b.size() - 1; i >=0 ; --i)
            System.out.print(" " + b.get(i));
        System.out.println();
    }
}
