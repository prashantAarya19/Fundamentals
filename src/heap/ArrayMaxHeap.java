package heap;

import java.util.Arrays;

public class ArrayMaxHeap {
    int[] heap;
    int size;

    public ArrayMaxHeap(int size) {
        this.heap = new int[size];
        this.heap[0] = -1;
        this.size = 0;
    }

    public void insert(int val) {
        ++size;
        int index = size;
        if(index >= heap.length)
            throw new ArrayIndexOutOfBoundsException("Heap is full");
        heap[index] = val;

        while(index > 1) {
            int root = index / 2;
            if(heap[root] < heap[index]) {
                swap(root, index);
                index = root;
            } else {
                break;
            }
        }
    }

    public void delete() {
        if(size == 0)
            return;
        heap[1] = heap[size];
        --size;
        int index = 1;
        while(index < size) {
            int left = index * 2;
            int right = index * 2 + 1;
            if(left <= size && heap[index] < heap[left]) {
                swap(index, left);
                index = left;
            } else if(right <= size && heap[index] < heap[right]) {
                swap(index, right);
                index = right;
            } else {
                break;
            }
        }

    }

    public void printHeap() {
        for(int i = 1; i <= size; i++)
            System.out.print(heap[i]+ " ");
        System.out.println();
    }

    public void swap(int i1, int i2) {
        int temp = heap[i1];
        heap[i1] = heap[i2];
        heap[i2] = temp;
    }

    public static void main(String[] args) {
        ArrayMaxHeap heap = new ArrayMaxHeap(10);
        heap.insert(50);
        heap.insert(55);
        heap.insert(53);
        heap.insert(52);
        heap.insert(54);

        System.out.println("<=== Before deletion");
        heap.printHeap();
        System.out.println("<=== After deletion");
        heap.delete();
        heap.printHeap();
    }
}
