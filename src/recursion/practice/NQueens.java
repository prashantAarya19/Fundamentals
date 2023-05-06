package recursion.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NQueens {
    private void solve(int n, int col, char[][] board, List<List<String>> result, int[] upperDiagonal, int[] lowerDiagonal, int[] horizontal) {
        if(col == n) {
            result.add(getListOfString(board));
            return;
        }

        for(int row = 0; row < n; row++) {
            if(horizontal[row] == 0 && upperDiagonal[row + col] == 0 && lowerDiagonal[(n - 1) + col - row] == 0  ) {
                horizontal[row] = 1;
                upperDiagonal[row + col] = 1;
                lowerDiagonal[n - 1 + col - row] = 1;
                board[row][col] = 'Q';
                solve(n, col + 1, board, result, upperDiagonal, lowerDiagonal, horizontal);
                horizontal[row] = 0;
                upperDiagonal[row + col] = 0;
                lowerDiagonal[(n - 1) + col - row] = 0;
                board[row][col] = '.';
            }
        }
    }

    private List<String> getListOfString(char[][] board) {
        List<String> list = new ArrayList<>();
        for(char[] c : board) {
            list.add(new String(c));
        }
        return list;
    }
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        char[][] board = new char[n][n];
        int[] upperDiagonal = new int[n + n];
        int[] lowerDiagonal = new int[n + n];
        int[] horizontal = new int[n];
        Arrays.stream(board).forEach(e -> Arrays.fill(e, '.'));
        solve(n, 0, board, result, upperDiagonal, lowerDiagonal, horizontal);
        return result;
    }
}
