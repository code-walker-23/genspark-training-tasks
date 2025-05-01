package mergesort;
public class MergeSort {
    public static void merge(int [] arr,int low, int mid, int high){
        int i = low;
        int j = mid+1;
        int k = 0;
        int [] b = new int[high-low+1];

        while(i <= mid && j <= high){
            if(arr[i] < arr[j]){
                b[k] = arr[i];
                i++;
            }else{
                b[k] = arr[j];
                j++;
            }
            k++;
        }

        while(i <= mid){
            b[k] = arr[i];
            i++;
            k++;
        }

        while(j <= high){
            b[k] = arr[j];
            j++;
            k++;
        }

        if (high + 1 - low >= 0) System.arraycopy(b, 0, arr, low, high + 1 - low);

    }
    public static void mergeSort(int [] arr, int low, int high){
        if(low < high){
            int mid = (low + high)/2;
            mergeSort(arr,low,mid);
            mergeSort(arr,mid+1,high);
            merge(arr,low,mid,high);
        }
    }
}
