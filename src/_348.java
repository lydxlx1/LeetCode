public class _348 {

    int[] row, col, diag1, diag2;
    int n;

    /**
     * Initialize your data structure here.
     */
    public _348(int n) {
        row = new int[n];
        col = new int[n];
        diag1 = new int[2 * n];
        diag2 = new int[2 * n];
        this.n = n;
    }

    /**
     * Player {player} makes a move at ({row}, {col}).
     *
     * @param r      The row of the board.
     * @param c      The column of the board.
     * @param player The player, can be either 1 or 2.
     * @return The current winning condition, can be either:
     * 0: No one wins.
     * 1: Player 1 wins.
     * 2: Player 2 wins.
     */
    public int move(int r, int c, int player) {
        int value = player == 1 ? 1 : -1;
        row[r] += value;
        col[c] += value;
        diag1[r + c] += value;
        diag2[r - c + n] += value;

        if (row[r] == n || col[c] == n || diag1[r + c] == n || diag2[r - c + n] == n) return 1;
        else if (row[r] == -n || col[c] == -n || diag1[r + c] == -n || diag2[r - c + n] == -n) return 2;
        else return 0;
    }
}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */