public class Speicherzelle {
    private int wert;

    private String name;

    public Speicherzelle(String name, int wert) {
        this.name = name;
        this.wert = wert;
    }

    private synchronized void setWert(int w ) {
        wert = w;
    }
    private synchronized int getWert() {
        return wert;
    }
    public synchronized void swapWert(Speicherzelle s) {
        int h = s.getWert();
        s.setWert(wert);
        setWert(h);

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("swapWert wurde ausgeführt");

    }
}
