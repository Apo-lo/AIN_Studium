package Aufgabe_9;

import java.io.*;
import java.util.TreeMap;

public class AnalyzeText {
    private static boolean isLetter(char c) {
        return ((('a' <= c) && (c <= 'z')) ||
                (('A' <= c) && (c <= 'Z')) ||
                (c=='�') ||
                (c=='Ä') || (c=='ä') || (c=='Ü') ||
                (c=='ö') || (c=='Ö') || (c=='ü')
        );
    }

    private static String readWord(BufferedReader f) throws IOException {
        String s= new String();
        char c;
        int ci;
        // wait for next letter
        do {
            ci=f.read();
            c=(char)ci;
        } while (!isLetter(c) && (ci!=-1));

        // wait for end of word
        while (isLetter(c)) {
            s += c;
            ci=f.read();
            c=(char)ci;
        }
        if (s.length()==0)
            return null;
        else
            return s;
    }

    private static void aufgabe1() {
        TreeMap<String, Integer> wordbook = new TreeMap<String, Integer>();

        try {
            BufferedReader file = new BufferedReader(new FileReader("/Users/fh/FH/Semester 2/Algorithmen & Datenstrukturen/Übung 9/Beispieltext.txt"));
            String s;
            while ((s=readWord(file))!=null) {
                if (wordbook.containsKey(s))
                    wordbook.put(s, wordbook.get(s) + 1);
                else
                    wordbook.put(s, 1);
            }
        }
        catch (IOException e) {
            System.out.println("Fehler beim Lesen der Datei:" +e.getMessage());
        }

        System.out.println("Aufgabe 1: ");
        for (String s: wordbook.keySet())
            System.out.println(s + ": " + wordbook.get(s));
    }

    @SuppressWarnings("resource")
    private static void aufgabe2() {
        TreeMap<String, String> line_counter = new TreeMap<String, String>();

        try {
            BufferedReader file = new BufferedReader(new FileReader("/Users/fh/FH/Semester 2/Algorithmen & Datenstrukturen/Übung 9/Beispieltext.txt"));
            String line;
            Integer counter = 1;

            while ((line = file.readLine()) != null) {
                String[] array = line.split("\\s");

                //Kommas, Punkte,... entfernen
                for (int i=0; i<array.length; i++) {
                    if (array[i].length() >0) {
                        if (!(isLetter(array[i].charAt(array[i].length() - 1))))
                            array[i] = array[i].substring(0, array[i].length() - 1);
                    }
                }

                for (String s: array) {
                    if (s != null) {
                        String temp;
                        if (line_counter.containsKey(s)) {
                            temp = line_counter.get(s) + ", " + counter.toString();
                        }
                        else {
                            temp = counter.toString();
                        }
                        line_counter.put(s, temp);
                    }
                }
                counter++;
            }
            line_counter.remove("");

            //Ausgabe
            System.out.println("Aufgabe 2: ");
            for (String s: line_counter.keySet())
                System.out.println(s + ": " + line_counter.get(s));
        }
        catch (IOException e) {
            System.out.println("Fehler beim Lesen der Datei:" +e.getMessage());
        }
    }

    @SuppressWarnings("resource")
    private static void aufgabe3() {
        TreeMap<String, String> line_counter = new TreeMap<String, String>();

        try {
            BufferedReader file = new BufferedReader(new FileReader("/Users/fh/IdeaProjects/Uebung9/src/AnalyzeText.java"));
            String line;
            Integer counter = 1;

            while ((line = file.readLine()) != null) {
                String[] array = line.split("\\s|\\p{Punct}");

                //Kommas, Punkte,... entfernen
                for(int i=0; i<array.length; i++) {
                    if (array[i].length() >0) {
                        if (!(isLetter(array[i].charAt(array[i].length() - 1))))
                            array[i]=array[i].substring(0, array[i].length() - 1);
                    }
                }

                for (String s: array) {
                    if (s != null) {
                        String temp;
                        if (line_counter.containsKey(s)) {
                            temp = line_counter.get(s) + ", " + counter.toString();
                        }
                        else {
                            temp = counter.toString();
                        }
                        line_counter.put(s, temp);
                    }
                }
                counter++;
            }
            line_counter.remove("");

            //Ausgabe
            System.out.println("Aufgabe 3: ");
            for (String s: line_counter.keySet())
                System.out.println(s + ": " + line_counter.get(s));
        }
        catch (IOException e) {
            System.out.println("Fehler beim Lesen der Datei:" +e.getMessage());
        }
    }

    public static void main(String[] args) {
        aufgabe1();
        System.out.println();
        aufgabe2();
        System.out.println();
        aufgabe3();
    }
}
