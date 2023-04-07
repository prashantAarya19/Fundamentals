package love50.matrix;

public class SpecificPair {
    public static void main(String[] args) {
        int mat[][] = {
                { 1, 2, -1, -4, -20 },
                { -8, -3, 4, 2, 1 },
                { 3, 8, 6, 1, 3 },
                { -4, -1, 1, 7, -6 },
                { 0, -4, 10, -5, 1 }
        };

        int N = 5;
        System.out.println(findMaxValue(mat, N));
    }

    private static int findMaxValue(int[][] matrix, int n) {
        int totalRow = n;
        int totalCol = matrix[0].length;

        int[][] maxValMatrix = new int[n][totalCol];
        maxValMatrix[totalRow - 1][totalCol - 1] = matrix[totalRow - 1][totalCol - 1];

        // adding last row
        int maxVal = matrix[totalRow - 1][totalCol - 1];
        for(int col = totalCol - 2; col >= 0; col--) {
            if(matrix[totalRow - 1][col] > maxVal)
                maxVal = matrix[totalRow - 1][col];
            maxValMatrix[totalRow - 1][col] = maxVal;
        }

        // adding last column
        maxVal = matrix[totalRow - 1][totalCol - 1];
        for(int row = totalRow - 2; row >= 0; row--) {
            if(matrix[row][totalCol - 1] > maxVal)
                maxVal = matrix[row][totalCol - 1];
            maxValMatrix[row][totalCol - 1] = maxVal;
        }

        int maxValue = Integer.MIN_VALUE;
        // adding rest of the row and col
        for(int row = totalRow - 2; row >= 0; row--) {
            for(int col = totalCol - 2; col >= 0; col--) {
                if(maxValMatrix[row + 1][col + 1] - matrix[row][col] > maxValue)
                    maxValue = maxValMatrix[row + 1][col + 1] - matrix[row][col];

                maxValMatrix[row][col] = Math.max(matrix[row][col],
                            Math.max(maxValMatrix[row+1][col], maxValMatrix[col][row+1]));
            }
        }
        return maxValue;
    }
}
