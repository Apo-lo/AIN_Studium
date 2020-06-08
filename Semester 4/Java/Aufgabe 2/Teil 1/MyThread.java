public class MyThread extends Thread {
    private Speicherzelle speicher1;
    private Speicherzelle speicher2;

    public MyThread(Speicherzelle speicher1, Speicherzelle speicher2) {
        super();
        this.speicher1 = speicher1;
        this.speicher2 = speicher2;
    }

    public void run() {
        while(true)
            speicher1.swapWert(speicher2);
    }
}
