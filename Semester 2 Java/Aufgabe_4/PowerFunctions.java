package Aufgabe_4;
import Aufgabe_1.Counter;

public class PowerFunctions {
    private static Counter countPower = new Counter();
    private static Counter countFastPower = new Counter();

    public static double power(double x, int n) {
        double result = 1;
        for (int i = 0; i < n; i++) {
            result = result * x;
            countPower.increment();
        }
        return result;
    }

    public static double fastPower(double x, int n) {
        double result = 1;
        String bin = Integer.toBinaryString(n);

        for (int i = 0; i < bin.length(); i++) {
            if (bin.charAt(i) == '1') {
                result = x * result * result;
                countFastPower.increment();
            }

            else
                result = result * result;
            countFastPower.increment();
        }
        return result;
    }

    public static void resetCounters() {
        countPower.reset();
        countFastPower.reset();
    }

    public static int getCountPower() {
        return countPower.get();
    }

    public static int getCountFastPower() {
        return countFastPower.get();
    }

}
