package Aufgabe_5;

public class Sort {

    @SuppressWarnings("rawtypes")
    public static void mergesort(Comparable[] input) {
        int size = input.length;
        if (size < 2)
            return;

        int middle = size/2;
        int leftSize = middle;
        int rightSize = size - middle;
        Comparable[] left = new Comparable[leftSize];
        Comparable[] right = new Comparable[rightSize];

        for (int i = 0; i < leftSize; i++) {
            left[i] = input[i];
        }
        for (int i = 0; i < rightSize; i++) {
            right[i] = input[i + middle];
        }

        mergesort(left);
        mergesort(right);
        merge(left, right, input);
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    private static void merge(Comparable[] left, Comparable[] right, Comparable[] output) {
        int leftSize = left.length;
        int rightSize = right.length;
        int l = 0;		//loop counter for left
        int r = 0;		//loop counter for right
        int i = 0;		//loop counter for output

        while (l < leftSize && r < rightSize) {
            if (left[l].compareTo(right[r]) <= 0)
                output[i++] = left[l++];
            else
                output[i++] = right[r++];
        }
        while (l < leftSize)
            output[i++] = left[l++];
        while (r < rightSize)
            output[i++] = right[r++];
    }
}
