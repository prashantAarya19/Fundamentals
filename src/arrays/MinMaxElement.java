package arrays;

/*
Find the min max element in an array
{4, 10, 1, 3, 5}
Min: 1
Max: 10
 */
public class MinMaxElement {

    public static void main(String[] args) {
        int[] arr = {4, 10, 1, 3, 5};
        printMaxMinElement(arr);
    }

    public static void printMaxMinElement(int[] arr) {
        if(arr.length == 0) {
            return;
        }

        int minElement = arr[0];
        int maxElement = arr[0];
        int counter = 1;
        while(counter < arr.length) {
            if(arr[counter] > maxElement) {
                maxElement = arr[counter];
            }

            if(arr[counter] < minElement) {
                minElement = arr[counter];
            }
            ++counter;
        }

        System.out.println("Min element::"+ minElement);
        System.out.println("Max element::"+ maxElement);
    }
}
