public class A {
    private int wert;
    private static Object o = new Object();

    public A(int startWert) {
        wert = startWert;
    }

    public synchronized void tausche(A a) {          //0
        synchronized (a) {
            int h = wert;               //1
            wert = a.wert;              //2
            a.wert = h;                 //3
        }
    }

    public int getWert() {
        return wert;
    }
}
