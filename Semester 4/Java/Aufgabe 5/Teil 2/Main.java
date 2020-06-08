package main;

public class Main {
    
    public static void main(String[] args) {
        Queue input_1 = new Queue(5, "InputQueue_1");
        Queue input_2 = new Queue(5, "InputQueue_2");
        Queue output  = new Queue(10,"OutputQueue");

        Einspeiser einspeiser_1 = new Einspeiser(input_1,0);
        Einspeiser einspeiser_2 = new Einspeiser(input_2,1);
        Merge merge_1 = new Merge(input_1, output);
        Merge merge_2 = new Merge(input_2, output);

        einspeiser_1.start();
        einspeiser_2.start();
        merge_1.start();
        merge_2.start();

        try {
            einspeiser_1.join();
            einspeiser_2.join();
            merge_1.interrupt();
            merge_2.interrupt();
            merge_1.join();
            merge_2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        output.print();
    }
}