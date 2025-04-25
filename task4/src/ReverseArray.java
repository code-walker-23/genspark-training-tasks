public class ReverseArray {
    public static void reverseArr(int[] arr, int low, int high) {
        if (low >= high) return;

        int temp = arr[low];
        arr[low] = arr[high];
        arr[high] = temp;

        reverseArr(arr, low + 1, high - 1);
    }

}
