package recursion.practice;

public class SudokuSolver {
    private boolean canFilled(char[][] board, int row, int col, char k) {
        for(int i = 0; i < 9; i++) {
            // check row
            if(board[i][col] == k)
                return false;

            // check col
            if(board[row][i] == k)
                return false;

            // check 3 x 3 matrix
            // Row = 3 * (row / 3) + i / 3;
            // Col = 3 * (col / 3) + i % 3;
            if(board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == k)
                return false;
        }

        return true;
    }
    private boolean solve(char[][] board) {

        for(int row = 0; row < 9; row++) {
            for(int col = 0; col < 9; col++) {
                if(board[row][col] == '.') {
                    for(char i = '1'; i <= '9'; i++) {
                        if(canFilled(board, row, col, i)) {
                            board[row][col] = i;
                            if(solve(board))
                                return true;
                            else
                                board[row][col] = '.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
    public void solveSudoku(char[][] board) {
        solve(board);
    }
}
