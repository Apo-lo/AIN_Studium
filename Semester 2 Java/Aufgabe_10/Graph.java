package Aufgabe_10;

import java.util.*;

public class Graph {
    private Map<String, Node> nodes;

    private class Node implements Comparable<Node> {
        Set<Edge> edges;
        String name;
        int d_value;
        boolean seen;
        Node prev;

        Node(String name) {
            edges = new HashSet<Edge>();
            this.name = name;
        }

        @Override
        public int compareTo(Node other) {
            return (int)(this.d_value - other.d_value);
        }
    }

    private class Edge {
        Node end;
        int weight;

        Edge(Node end, int weight) {
            this.end = end;
            this.weight = weight;
        }
    }

    Graph() {
        nodes = new HashMap<String, Node>();
    }

    public void insertEdges(String a, String b, int weight) {

        Node node1 = new Node(a);
        Node node2 = new Node(b);

        if (nodes.containsKey(node1.name))
            node1 = nodes.get(node1.name);
        else
            nodes.put(node1.name, node1);

        if (nodes.containsKey(node2.name))
            node2 = nodes.get(node2.name);
        else
            nodes.put(node2.name,  node2);

        node1.edges.add(new Edge(node2, weight));
        node2.edges.add(new Edge(node1, weight));
    }

    public Set<String> getNodes() {
        Set<String> result = new HashSet<String>();
        for (String s: nodes.keySet())
            result.add(s);
        return result;
    }

    public void dijkstra(String start, Map<String, Integer> result) {
        PriorityQueue<Node> queue = new PriorityQueue<Node>();

        for (Node n : nodes.values()) {
            n.d_value = Integer.MAX_VALUE;
            n.seen = false;
            n.prev = null;
        }

        nodes.get(start).d_value = 0;
        queue.add(nodes.get(start));

        while (!queue.isEmpty()) {

            Node node1 = queue.poll();
            if (node1.seen) continue;
            node1.seen = true;

            for (Edge e : node1.edges) {
                Node node2 = e.end;
                int dist = e.weight;
                if (node2.d_value > node1.d_value + dist) {
                    node2.d_value = node1.d_value + dist;
                    node2.prev = node1;
                    queue.add(node2);
                }
            }
        }

        for (Node n : nodes.values()) {
            result.put(n.name, n.d_value);
        }

    }

    public void dump() {
        for (String s: nodes.keySet()) {
            System.out.print(s + ": ");
            String connections = "";
            for (Edge e: nodes.get(s).edges) {
                connections = connections + e.end.name + "(" + e.weight + ") ";
            }
            System.out.print(connections);
            System.out.println();
        }
    }
}
