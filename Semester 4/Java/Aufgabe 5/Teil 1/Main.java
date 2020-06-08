package main;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        final PipedInputStream pis = new PipedInputStream();
        final PipedOutputStream pos = new PipedOutputStream(pis);

        int INHALT_GROESSE = 1024;
        byte[] b = new byte[INHALT_GROESSE];

        //Producer
        Thread thread_A = new Thread(() -> {
            try {
                pos.write(b, 0, b.length);
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("[thread_A]::write terminated");
        });

        //Consumer
        Thread thread_B = new Thread(() -> {
            int i = 1;
            while(true) {
                try {
                    Thread.sleep(100);
                    System.out.println(i + ". byte: " + pis.read());
                    i++;
                } catch (InterruptedException | IOException e) {
                    e.printStackTrace();
                    try {
                        pis.close();
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
            }

        });

        thread_A.start();
        thread_B.start();

        System.out.println("[main]::terminated");
    }
}
