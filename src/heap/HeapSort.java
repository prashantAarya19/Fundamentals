package heap;

import java.util.Arrays;

public class HeapSort {

    public static void swap(int i1, int i2, int[] arr) {
        int temp = arr[i1];
        arr[i1] = arr[i2];
        arr[i2] = temp;
    }

    public static void heapiFy(int[] arr, int n, int k) {
        int max = k;
        int left = k * 2 + 1;
        int right = k * 2 + 2;

        if(left <= n && arr[max] < arr[left]) {
            max = left;
        }

        if(right <= n && arr[max] < arr[right]) {
            max = right;
        }

        if(max != k) {
            swap(k, max, arr);
            heapiFy(arr, n, max);
        }
    }

    // max heap
    public static void buildHeap(int[] arr) {
        int n = arr.length - 1;

        for(int i = n/2; i >= 0; i--) {
            heapiFy(arr, n, i);
        }
    }

    public static void printArray(int[] arr) {
        Arrays.stream(arr).filter(e -> e > 0).forEach(e -> System.out.print(e+ " "));
        System.out.println();
    }

    public static void heapSort(int[] arr) {
        int size = arr.length - 1;

        while(size > 0) {
            swap(size, 0, arr);
            --size;
            heapiFy(arr, size, 0);
        }
    }

    public static void main(String[] args) {
        int[] arr = {54, 53, 55, 52, 50};
        buildHeap(arr);
        printArray(arr);
        System.out.println("<=== Heap sort ===>");
        heapSort(arr);
        printArray(arr);
    }

}
