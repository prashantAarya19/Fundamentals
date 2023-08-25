package love50.searchingSorting;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class KthSmallestNumber {
    public static void main(String[] args) throws InterruptedException {
        int[][] arr = {{1, 3}, {2, 6}, {8, 10}};

        int counter = 0;
        for(int i = 1; i < arr.length; i++) {
            if(arr[counter][1] >= arr[i][0]) {
                arr[counter][1] = Math.max(arr[counter][1], arr[i][1]);
            } else {
                arr[++counter] = arr[i];
            }
        }

        for(int i = 0; i <= counter; i++) {
            System.out.println("{"+arr[i][0] +","+ arr[i][1]+"}");
        }

        System.out.println(getKthElement(arr, counter, 9));
        

    }

    private static int getKthElement(int[][] arr, int n, int key) {
        int result = -1;
        for(int i = 0; i <= n; i++) {
            if((arr[i][1] - arr[i][0] + 1) >= key) {
                result =  arr[i][0] + key - 1;
                break;
            } else {
                key = key - (arr[i][1] - arr[i][0] + 1);
            }
        }
        return result;
    }
}
