package TwoDArray;

import java.util.Arrays;

public class Wave {
    public static int[] wavePrint(int[][] arr, int row, int col) {
        int[] resultArr = new int[row*col];
        int counter = 0;
        for(int i = 0; i < col; i++) {
            if(i%2==0)  {
                int j = 0;
                while(j < row) {
                    resultArr[counter++] = arr[j][i];
                    ++j;
                }
            } else {
                int j = row-1;
                while(j >=0) {
                    resultArr[counter++] = arr[j][i];
                    --j;
                }
            }
        }

        return resultArr;
    }

    public static void main(String[] args) {
        int[][] arr = {{1, 2, 3},
                       {4, 5, 6},
                       {7, 8, 9 },
                       {7, 8, 9 }};
        Arrays.stream(wavePrint(arr, 4, 3)).forEach(e -> System.out.print(e +" "));
        System.out.println("\n"+arr[0].length);
    }
}
