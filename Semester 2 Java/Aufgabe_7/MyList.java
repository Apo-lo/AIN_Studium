package Aufgabe_7;

public class MyList<T> {
    private Node tail;
    private int size;

    public MyList() {
        tail = null;
        size = 0;
    }

    public void add(T x) {
        Node temp = new Node();
        temp.data = x;
        temp.next = tail;
        tail = temp;
        size++;
    }

    public T get(int index) {
        Node temp = tail;
        if (index > 0) {
            for (int i = 1; i <= index; i++)
                temp = temp.next;
        }
        return temp.data;
    }

    public T remove(int index) {
        Node temp = tail;
        if (index == 0) {
            tail = temp.next;
            size--;
            return temp.data;
        }

        for (int i = 1; i < index; i++)
            temp = temp.next;
        Node del = temp.next;
        if (del.next != null) {
            temp.next = del.next;
        }
        else {
            temp.next = null;
        }

        size--;
        return del.data;
    }

    public int size() {
        return size;
    }

    class Node {
        private T data;
        private Node next;
        Node() {
            data = null;
            next = null;
        }
    }
}
