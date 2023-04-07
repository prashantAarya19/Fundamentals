package love50.matrix;

public class TransposeOfMatrix {
    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}};

        printMatrix(matrix);
        System.out.println("\n<===After transpose===>");
        getTranspose(matrix);
        printMatrix(matrix);
        System.out.println("\n<===After rotating===>");
        //rotateBy90Clockwise(matrix);
        rotate90AntiClockwise(matrix);
        printMatrix(matrix);
    }

    private static void getTranspose(int[][] matrix) {
        for(int row = 0; row < matrix.length; row++) {
            for(int col = row; col < matrix[row].length; col++) {
                int temp = matrix[row][col];
                matrix[row][col] = matrix[col][row];
                matrix[col][row] = temp;
            }
        }
    }

    private static void rotateBy90Clockwise(int[][] matrix) {
        for(int col = 0; col < matrix[0].length/2; col++) {
            for(int row = 0; row < matrix.length; row++) {
                int temp = matrix[row][col];
                matrix[row][col] = matrix[row][matrix[0].length - 1 - col];
                matrix[row][matrix[0].length - 1 - col] = temp;
            }
        }

    }

    private static void rotate90AntiClockwise(int[][] matrix) {
        for(int row = 0; row < matrix.length / 2; row++) {
            for(int col = 0; col < matrix[row].length; col++) {
                int temp = matrix[row][col];
                matrix[row][col] = matrix[matrix.length - 1 - row][col];
                matrix[matrix.length - 1 - row][col] = temp;
            }
        }
    }

    public static void printMatrix(int[][] matrix) {
        for(int row = 0; row < matrix.length; row++) {
            for(int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col]+" ");
            }
            System.out.println();
        }
    }
}
