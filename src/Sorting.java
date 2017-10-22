import java.util.Arrays;

public class Sorting {

    static void insertionSort(int arr[]) {
        for (int i = 1; i < arr.length; i++) {
            int current = arr[i];
            int j = i - 1;
            while(j >= 0 && arr[j] > current) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = current;
        }
    }

    static void bubbleSort(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            boolean swapped = false;
            for (int j =0; j < arr.length - 1; j++) {
                if (arr[j] > arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) return;
        }
    }

    static void maxSelectionSort(int arr[]) {
        for (int i = 0; i < arr.length; i++){
            int maxIndex = 0;
            for(int j = 1; j < arr.length - i; j++) {
                if (arr[j] > arr[maxIndex]) maxIndex = j;
            }
            int temp = arr[maxIndex];
            arr[maxIndex] = arr[arr.length - i - 1];
            arr[arr.length-i - 1] = temp;
        }
    }

    static void minSelectionSort(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;
            for (int j = i+1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) minIndex = j;
            }
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }



    static void mergesort(int[] arr) {
        if (arr.length < 2) return;
        int mid = arr.length / 2;
        int[] left = new int[mid];
        int[] right = new int[arr.length - mid];
        for (int i = 0; i < mid; i++){
            left[i] = arr[i];
        }
        for (int i = mid; i < arr.length; i++){
            right[i - mid] = arr[i];
        }
        mergesort(left);
        mergesort(right);
        merge(arr, left, right);
    }

    private static void merge(int[] arr, int[] l, int[] r) {
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < l.length && j < r.length) {
            if (l[i] > r[j]) {
                arr[k] = r[j];
                j++;
            }
            else {
                arr[k] = l[i];
                i++;
            }
            k++;
        }
        while (i < l.length) {
            arr[k] = l[i];
            k++;i++;
        }

        while (j < r.length) {
            arr[k] = r[j];
            k++;j++;
        }
    }

    static void quickSort(int arr[], int start, int end) {
        if (end > start) {
            int pIndex = partition2(arr, start, end);
            quickSort(arr, start, pIndex - 1);
            quickSort(arr, pIndex + 1, end);
        }
    }

    private static int partition(int arr[], int start, int end) {
        int pivot = arr[end];
        int pIndex = start;
        for (int i = start; i < end; i++) {
            if (arr[i] < pivot) {
                if(i!=pIndex) {
                    int temp = arr[i];
                    arr[i] = arr[pIndex];
                    arr[pIndex] = temp;
                }
                pIndex++;
            }
        }
        int temp = arr[pIndex];
        arr[pIndex] = pivot;
        arr[end] = temp;
        return pIndex;
    }

    private static int partition2(int[] arr, int start, int end) {
        int pivot = arr[start];
        int pIndex = end;
        for (int i = end; i > start; i--) {
            if (arr[i] > pivot) {
                int temp = arr[i];
                arr[i] = arr[pIndex];
                arr[pIndex] = temp;
                pIndex--;
            }
        }
        int temp = arr[pIndex];
        arr[pIndex] = pivot;
        arr[start] = temp;
        return pIndex;
    }

    public static void main (String[] args) {
        int[] arr = {5,6,3,0,8,2,9,7,4};
        quickSort(arr, 0, arr.length-1);
//        mergesort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
