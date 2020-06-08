public class Main {

    public static void main(String[] args) {
        double[] zahlenFeld = new double[Integer.MAX_VALUE]; //Um 16Gb zu belegen muss das Feld 250.000.000.000 double Zahlen enthalten
        long x,y;

        while(true) {
            x = System.currentTimeMillis();
            for(int i = 0; i < zahlenFeld.length; i++) {
                zahlenFeld[i] = Math.random();
            }
            y = System.currentTimeMillis();
            System.out.println(y - x);
        }

    }
}
