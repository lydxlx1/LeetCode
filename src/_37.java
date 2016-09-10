import java.util.Arrays;

/**
 * LeetCode 37 - Sudoku Solver
 *
 * Greedy Backtracking using Bitmask
 */
public class _37 {

    static int[] bitCnt = new int[1 << 9];

    static {
        for (int i = 0; i < bitCnt.length; i++) bitCnt[i] = Integer.bitCount(i);
    }

    private int put(int[][] state, int[] buf, int i, int j, int val) {
        int cnt = 0, mask = 1 << val;
        for (int k = 0; k < 9; k++) {
            if ((state[i][k] & mask) != 0) {
                state[i][k] &= ~mask;
                buf[cnt++] = i * 9 + k;
            }
            if ((state[k][j] & mask) != 0) {
                state[k][j] &= ~mask;
                buf[cnt++] = k * 9 + j;
            }
            if ((state[i / 3 * 3 + k / 3][j / 3 * 3 + k % 3] & mask) != 0) {
                state[i / 3 * 3 + k / 3][j / 3 * 3 + k % 3] &= ~mask;
                buf[cnt++] = (i / 3 * 3 + k / 3) * 9 + j / 3 * 3 + k % 3;
            }
        }
        return cnt;
    }

    private boolean dfs(int remaining, char[][] board, int[][] state) {
        if (remaining == 0) return true;
        int x = 0, y = 0, min = Integer.MAX_VALUE;
        for (int i = 0; i < 9; i++)
            for (int j = 0; j < 9; j++)
                if (board[i][j] == '.' && bitCnt[state[i][j]] < min) {
                    min = bitCnt[state[i][j]];
                    x = i;
                    y = j;
                }
        if (min == Integer.MAX_VALUE) return false;

        int[] buf = new int[9 * 9];
        for (int bit = 0; bit < 9; bit++)
            if (((1 << bit) & state[x][y]) != 0) {
                board[x][y] = (char) (bit + '1');
                int cnt = put(state, buf, x, y, bit);
                if (dfs(remaining - 1, board, state)) return true;
                for (int i = 0; i < cnt; i++)
                    state[buf[i] / 9][buf[i] % 9] |= 1 << bit;
                board[x][y] = '.';
            }
        return false;
    }

    public void solveSudoku(char[][] board) {
        int[][] state = new int[9][9];
        for (int[] arr : state) Arrays.fill(arr, (1 << 9) - 1);
        int remaining = 9 * 9;
        int[] buf = new int[9 * 9];
        for (int i = 0; i < 9; i++)
            for (int j = 0; j < 9; j++)
                if (board[i][j] != '.') {
                    remaining--;
                    put(state, buf, i, j, board[i][j] - '1');
                }
        dfs(remaining, board, state);
    }
}