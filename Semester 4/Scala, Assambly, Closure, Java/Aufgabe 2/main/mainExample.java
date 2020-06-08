package main;
import java.io.*;
public class mainExample {


    public static void main(String[] args) throws FileNotFoundException {

        String filename = "/Users/fh/FH/Semester 4/Programmiermodelle/Praktikum/Aufgabe 2/Test.txt";
        File file = new File(filename);
        Reader reader = new FileReader(file);
        LineReader lines = new LineReader(reader);
        for(String line : lines)
            System.out.println(line);
    }
}
