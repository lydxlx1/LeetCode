/**
 * LeetCode 36 - Valid Sudoku
 */
public class _36 {
    private boolean tryAndPut(boolean[][] checker, int i, int j) {
        if (checker[i][j]) return false;
        checker[i][j] = true;
        return true;
    }

    public boolean isValidSudoku(char[][] board) {
        boolean[][] checker1 = new boolean[9][9];
        boolean[][] checker2 = new boolean[9][9];
        boolean[][] checker3 = new boolean[9][9];
        for (int i = 0; i < 9; i++)
            for (int j = 0; j < 9; j++)
                if (board[i][j] != '.') {
                    int num = board[i][j] - '1';
                    if (!tryAndPut(checker1, i, num)) return false;
                    if (!tryAndPut(checker2, j, num)) return false;
                    if (!tryAndPut(checker3, i / 3 * 3 + j / 3, num)) return false;
                }
        return true;
    }
}