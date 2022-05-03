package TwoDArray;

public class SearchInMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {

        int row = matrix.length;
        int col = matrix[0].length;

        int s = 0;
        int e = row * col - 1;

        int mid = s + (e - s) / 2;

        while (s <= e) {
            int elm = matrix[mid / col][mid % col];

            if (elm == target) {
                return true;
            }

            if (elm < target) {
                s = mid + 1;
            }

            if (elm > target) {
                e = mid - 1;
            }

            mid = s + (e - s) / 2;
        }

        return false;
    }
}
