public class Main {
    private static A a0;
    private static A a1;

    public static void main(String[] args) throws InterruptedException {
        a0 = new A(0);
        a1 = new A(1);
        
        System.out.println("Vor WertTausch:  a0.wert = " + a0.getWert() + "; a1.wert = " + a1.getWert());

        WertTausch t1 = new WertTausch(a0, a1);
        WertTausch t2 = new WertTausch(a1, a0);
        t1.start();
        t2.start();

        t1.join();
        t2.join();
        System.out.println("Nach WertTausch: a0.wert = " + a0.getWert() + "; a1.wert = " + a1.getWert());
    }
}
