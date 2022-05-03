package TwoDArray;

/** Rotate matrix by 90 degree **/
public class RotateMatrix {
    public static void rotate(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;

        int total = row*col;
        int counter = 0;

        int startingRow = 0;
        int startingCol = 0;
        int endingRow = row - 1;
        int endingCol = col - 1;

        int[] resultArr = new int[row*col];

        while(counter < total) {

            // add first col
            for(int i = endingRow; counter < total && i >= startingRow; i--) {
                resultArr[counter++] = matrix[i][startingCol];
            }
            ++startingCol;
            //add first row
            for(int i = startingCol; counter < total && i <= endingCol; i++) {
                resultArr[counter++] = matrix[startingRow][i];
            }
            ++startingRow;
            //add last col
            for(int i = startingRow; counter < total && i <= endingRow; i++) {
                resultArr[counter++] = matrix[i][endingCol];
            }
            --endingCol;
            //add end row
            for(int i = endingCol; counter < total && i >= startingCol; i--) {
                resultArr[counter++] = matrix[endingRow][i];
            }
            --endingRow;
        }

        // resetting all the indexes
        counter = 0;
        startingRow = 0;
        startingCol = 0;
        endingRow = row - 1;
        endingCol = col - 1;
        while(counter < total) {
            //add first row
            for(int i = startingCol; counter < total && i <= endingCol; i++) {
                matrix[startingRow][i] = resultArr[counter++];
            }
            ++startingRow;
            // add last col
            for(int i = startingRow; counter < total && i <= endingRow; i++) {
                matrix[i][endingCol] = resultArr[counter++];
            }
            --endingCol;
            //add end row
            for(int i = endingCol; counter < total && i >= startingCol; i--) {
                matrix[endingRow][i] = resultArr[counter++];
            }
            --endingRow;
            // add first col
            for(int i = endingRow; counter < total && i >= startingRow; i--) {
                matrix[i][startingCol] = resultArr[counter++];
            }
            ++startingCol;
        }

        printMatrix(matrix);

    }

    public static void printMatrix(int[][] matrix) {
        for(int i = 0; i < matrix[0].length; i++) {
            for(int j = 0; j < matrix.length; j++) {
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }

        System.out.println("\n");
    }

    public static void printArr(int[] arr) {
        for(int i : arr) {
            System.out.print(i+" ");
        }
        System.out.println("\n");
    }

    public static void rotateOptimized(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < (n + 1) / 2; i ++) {
            System.out.println("i : "+i);
            for (int j = 0; j < n / 2; j++) {
                System.out.println("j : "+j);
                int temp = matrix[n - 1 - j][i];
                matrix[n - 1 - j][i] = matrix[n - 1 - i][n - j - 1];
                matrix[n - 1 - i][n - j - 1] = matrix[j][n - 1 -i];
                matrix[j][n - 1 - i] = matrix[i][j];
                matrix[i][j] = temp;
            }
        }
        printMatrix(matrix);
    }

    public static void main(String[] args) {
        int[][] arr = {{5,1,9,11},{2,4,8,10},{13,3,6,7},{15,14,12,16}};
        System.out.println(arr.length);
        rotateOptimized(arr);
    }
}
