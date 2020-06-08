package Aufgabe_4;

public class PowerFunctionsTest {

    public static void main(String[] args) {
        int limit = 10000;

        int sum = 0;

        for (int i=0; i<limit; i++) {
            double x = Math.random();
            int n = (int)(Math.random() * 1000);
            sum = sum + n;

            PowerFunctions.power(x,n);

            PowerFunctions.fastPower(x,n);
        }



        System.out.println("Durchschn. Multiplikationen power: " + PowerFunctions.getCountPower()/limit);
        System.out.println("Durchschn. Multiplikationen fastPower: " + PowerFunctions.getCountFastPower()/limit);
        System.out.println("sum = "+ sum/limit);
    }
}
