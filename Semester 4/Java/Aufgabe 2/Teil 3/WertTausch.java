public class WertTausch extends Thread {
    private A b0;
    private A b1;

    WertTausch(A b0, A b1) {
        this.b0 = b0;
        this.b1 = b1;
    }

    public void run() {
        b0.tausche(b1);
    }
}
