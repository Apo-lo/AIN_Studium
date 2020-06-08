import java.io.IOException;

public class RegexTest {

    public static void main(String[] args) throws IOException {

        System.out.println("Aufgabe 3");
        TimeChecker x = new TimeChecker();
        System.out.println("Time to check: 19:24" + " " + x.timematcherschlau("19:24"));
        System.out.println("Time to check: 19:24" + " " + x.timematcherdumm("19:24"));
        System.out.println("Time to check: 09:41" + " " + x.timematcherdumm("09:41"));
        System.out.println("Time to check: 14:09" + " " + x.timematcherdumm("14:09"));
        System.out.println("Time to check: 99:24" + " " + x.timematcherdumm("99:24"));
        System.out.println("Time to check: 19:60" + " " + x.timematcherdumm("19:60"));

        System.out.println("--------------------------------");
        System.out.println("Aufgabe 6");
        Shakespeare y = new Shakespeare();
        System.out.println("Word Count: " + y.wordCount());
    }
}
