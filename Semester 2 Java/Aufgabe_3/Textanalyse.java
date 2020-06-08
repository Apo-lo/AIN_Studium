package Aufgabe_3;

public class Textanalyse {
    private static char gross(char c) {
        if (Character.isLowerCase(c))
            c = Character.toUpperCase(c);
        return c;
    }

    //Aufgabe 1:
    private static void aufgabe1(String[] args) {
        System.out.println("Aufgabe 1:");
        System.out.println("Anzahl Argumente: " + args.length);

        for (int i=0; i < args.length; i++) {
            System.out.println("Laenge Argument " + i + ": " + args[i].length());
        }
    }

    //Aufgabe 2:
    private static void aufgabe2(String[] args) {
        System.out.println();
        System.out.println("Aufgabe 2:");

        //Alphabet erstellen
        CharCounter[] alphabet = new CharCounter[26];
        char name = 'A';
        for (int i=0; i < alphabet.length; i++) {
            alphabet[i] = new CharCounter(name++);
        }

        for (int i=0; i < args.length; i++) {

            for (int j=0; j < args[i].length(); j++) {
                char c = args[i].charAt(j);
                c = gross(c);

                for (int k=0; k < alphabet.length; k++) {
                    if (c == alphabet[k].name()) {
                        alphabet[k].increment();
                        k = alphabet.length;
                    }
                }
            }
        }

        for (int i=0; i < alphabet.length; i++) {
            if (alphabet[i].get() != 0) {
                System.out.print(alphabet[i].name() + ":" + alphabet[i].get() + "  ");
            }
        }
    }

    public static void main(String[] args) {

        aufgabe1(args);

        aufgabe2(args);

    }
}
