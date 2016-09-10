/**
 * LeetCode 37 - Sudoku Solver
 *
 * Greedy Backtracking
 */
public class _37_1 {
    boolean[][] check1;
    boolean[][] check2;
    boolean[][] check3;

    private boolean dfs(int remaining, char[][] board) {
        if (remaining == 0) return true;
        int x = 0, y = 0, min = Integer.MAX_VALUE;
        for (int i = 0; i < 9; i++)
            for (int j = 0; j < 9; j++)
                if (board[i][j] == '.') {
                    int cnt = 0;
                    for (int k = 0; k < 9; k++)
                        if (!check1[i][k] && !check2[j][k] && !check3[i / 3 * 3 + j / 3][k]) cnt++;
                    if (cnt < min) {
                        min = cnt;
                        x = i;
                        y = j;
                    }
                }
        if (min == Integer.MAX_VALUE) return false;

        for (int k = 0; k < 9; k++)
            if (!check1[x][k] && !check2[y][k] && !check3[x / 3 * 3 + y / 3][k]) {
                board[x][y] = (char) (k + '1');
                check1[x][k] = check2[y][k] = check3[x / 3 * 3 + y / 3][k] = true;
                if (dfs(remaining - 1, board)) return true;
                check1[x][k] = check2[y][k] = check3[x / 3 * 3 + y / 3][k] = false;
                board[x][y] = '.';
            }
        return false;
    }

    public void solveSudoku(char[][] board) {
        check1 = new boolean[9][9];
        check2 = new boolean[9][9];
        check3 = new boolean[9][9];
        int remaining = 9 * 9;
        for (int i = 0; i < 9; i++)
            for (int j = 0; j < 9; j++)
                if (board[i][j] != '.') {
                    remaining--;
                    int k = board[i][j] - '1';
                    check1[i][k] = check2[j][k] = check3[i / 3 * 3 + j / 3][k] = true;
                }
        dfs(remaining, board);
    }
}

