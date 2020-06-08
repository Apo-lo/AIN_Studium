package Aufgabe_10;

import java.util.*;

public class GraphTest {

    public static void main(String[] args)
    {
        Graph G = new Graph();

        G.insertEdges("Hamburg",   "Münster",   281);
        G.insertEdges("Hamburg",   "Hannover",  151);
        G.insertEdges("Hamburg",   "Berlin",    280);
        G.insertEdges("Münster",   "Aachen",    560);
        G.insertEdges("Aachen",    "Koblenz",   154);
        G.insertEdges("Koblenz",   "Frankfurt", 125);
        G.insertEdges("Hannover",  "Frankfurt", 351);
        G.insertEdges("Frankfurt", "Würzburg",  119);
        G.insertEdges("Würzburg",  "Stuttgart", 151);
        G.insertEdges("Stuttgart", "Basel",     273);
        G.insertEdges("Stuttgart", "München",   221);
        G.insertEdges("Koblenz",   "Basel",     403);
        G.insertEdges("Aachen",    "Basel",     539);
        G.insertEdges("Hannover",  "Erfurt",    217);
        G.insertEdges("Erfurt",    "Würzburg",  195);
        G.insertEdges("Berlin",    "Leipzig",   192);
        G.insertEdges("Leipzig",   "Erfurt",    146);
        G.insertEdges("Leipzig",   "München",   431);
        G.insertEdges("Basel",     "München",   394);


        Map<String,Integer> d = new HashMap<String,Integer>();
        G.dijkstra("Hamburg", d);

        for (String v: G.getNodes())
            System.out.println(v + ": " + d.get(v));
        System.out.println();
    }

}
