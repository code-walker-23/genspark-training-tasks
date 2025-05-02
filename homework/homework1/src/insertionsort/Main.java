package insertionsort;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] arr = {5, 2, 4, 6, 1, 3};
        System.out.println("Before sorting: " + Arrays.toString(arr));

        InsertionSort.insertionSort(arr);

        System.out.println("After sorting: " + Arrays.toString(arr));
    }
}
