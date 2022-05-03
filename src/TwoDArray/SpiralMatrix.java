package TwoDArray;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public static List<Integer> spiralOrder(int[][] matrix) {

        List<Integer> result = new ArrayList<>();

        int row = matrix.length;
        int col = matrix[0].length;

        int count = 0;
        int total = row*col;

        // indexes
        int startingRow = 0;
        int startingCol = 0;

        int endingRow = row - 1;
        int endingCol = col - 1;

        while(count < total) {

            // add starting row
            for(int i = startingCol; count < total && i <= endingCol; i++) {
                result.add(matrix[startingRow][i]);
                ++count;
            }
            ++startingRow;

            // add ending col
            for(int i = startingRow; count < total && i <= endingRow; i++) {
                result.add(matrix[i][endingCol]);
                ++count;
            }

            --endingCol;

            //add ending row
            for(int i = endingCol; count < total && i >= startingCol; i--) {
                result.add(matrix[endingRow][i]);
                ++count;
            }
            --endingRow;

            //add starting col
            for(int i = endingRow; count < total && i >= startingRow; i--) {
                result.add(matrix[i][startingCol]);
                ++count;
            }
            ++startingCol;
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] arr = {{1,2,3},{4,5,6},{7,8,9}};

        List<Integer> sp = spiralOrder(arr);
        System.out.println(sp);

    }
}
