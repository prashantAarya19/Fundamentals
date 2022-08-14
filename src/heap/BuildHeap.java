package heap;

import java.util.Arrays;

public class BuildHeap {
    public void buildHeap(int[] arr) {
        int n = arr.length - 1;
        for(int i = n / 2; i > 0; i--) {
            heapiFy(arr, n, i);
        }
        printArray(arr);
    }

    private void heapiFy(int[] arr, int n, int i) {
        int largest = i;
        int left = 2 * largest;
        int right = 2 * largest + 1;

        if(left < n && arr[largest] < arr[left]) {
            largest = left;
        }

        if(right < n && arr[largest] < arr[right]) {
            largest = right;
        }

        if(largest != i) {
            swap(largest, i, arr);
            heapiFy(arr, n, largest);
        }
    }

    public void swap(int i1, int i2, int[] arr) {
        int temp = arr[i1];
        arr[i1] = arr[i2];
        arr[i2] = temp;
    }

    public void printArray(int[] arr) {
        Arrays.stream(arr).filter(e -> e > 0).forEach(e -> System.out.print(e+ " "));
        System.out.println();
    }

    public static void main(String[] args) {
        BuildHeap heap = new BuildHeap();
        int[] arr = {-1, 54, 53, 55, 52, 50};
        heap.buildHeap(arr);
       // heap.printArray(arr);
    }


}
