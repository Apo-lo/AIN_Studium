//Original

import java.util.LinkedList;
import java.util.List;



public class Utility {
    static int[] gibZufaelligeReihenfolge(int anzahl) {
        int[] reihenfolge = new int[anzahl];
        List<Integer> indizes = new LinkedList<Integer>();

        for (int i = 0; i < reihenfolge.length; i++) {
            indizes.add(i);
        }

        int i = 0;

        while (!indizes.isEmpty()) {
            int ind = (int) (Math.random() * ((double) indizes.size()));
            reihenfolge[i] = indizes.remove(ind);
            i++;
        }

        return reihenfolge;
    }


    static int[] gibZufaelligeReihenfolgeMitVertauschen(int anzahl) {
        int[] reihenfolge = new int[anzahl];

        for (int i = 0; i < reihenfolge.length; i++) {
            reihenfolge[i] = i;
        }

        // Bei ungerader Anzahl bleibt ein zufaelliger Index dort, wo er ist
        int indBleibtStehen = -1;
        if (anzahl % 2 == 1) {
            indBleibtStehen = (int) (Math.random() * ((double) anzahl));
        }

        // index Urne befuellen

        List<Integer> indexUrne = new LinkedList<Integer>();

        for (int i = 0; i < anzahl; i++) {
            if (i != indBleibtStehen) {
                indexUrne.add(i);
            }
        }

        // zufaellig zwei Indizes aus Urne nehmen
        while (indexUrne.size() != 0) {
            int ersterInd = indexUrne
                    .remove((int) (Math.random() * ((double) indexUrne.size())));
            int zweiterInd = indexUrne
                    .remove((int) (Math.random() * ((double) indexUrne.size())));

            // Vertauschen

            int temp = reihenfolge[ersterInd];
            reihenfolge[ersterInd] = reihenfolge[zweiterInd];
            reihenfolge[zweiterInd] = temp;
        }

        return reihenfolge;

    }
}