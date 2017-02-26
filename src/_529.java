/**
 * LeetCode 529 - Minesweeper
 * <p>
 * DFS
 */
public class _529 {

    int[] dx = {1, 1, 1, 0, 0, -1, -1, -1};
    int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};

    private void dfs(char[][] b, int i, int j) {
        if (b[i][j] != 'E') return;

        int num = 0;
        for (int k = 0; k < 8; k++) {
            int x = i + dx[k], y = j + dy[k];
            if (x >= 0 && x < b.length && y >= 0 && y < b[0].length && b[x][y] == 'M') num++;
        }
        b[i][j] = num == 0 ? 'B' : (char) ('0' + num);

        if (num == 0) {
            for (int k = 0; k < 8; k++) {
                int x = i + dx[k], y = j + dy[k];
                if (x >= 0 && x < b.length && y >= 0 && y < b[0].length) dfs(b, x, y);
            }
        }
    }

    public char[][] updateBoard(char[][] board, int[] click) {
        int x = click[0], y = click[1];
        if (board[x][y] == 'M') board[x][y] = 'X';
        else dfs(board, x, y);
        return board;
    }
}
