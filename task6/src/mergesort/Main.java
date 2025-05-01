package mergesort;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int [] arr = new int[]{2, 1, 7, 4, 9};

        int[] array = { 5, 2, 9, 1, 6, 3 };

        System.out.println("Before sorting: " + Arrays.toString(array));
        MergeSort.mergeSort(array, 0, array.length - 1);
        System.out.println("After sorting:  " + Arrays.toString(array));
    }
}