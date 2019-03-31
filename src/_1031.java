/**
 * LeetCode 1031 - Number of Enclaves
 *
 * DFS
 * Surround the original board with a layer of lands, and then do a standard DFS.
 */
public class _1031 {

    int[] dx = {0, 0, 1, -1};
    int[] dy = {1, -1, 0, 0};
    int r, c;
    int[][] board;
    boolean[][] visited;

    public int numEnclaves(int[][] A) {
        r = A.length;
        c = A[0].length;
        r += 2;
        c += 2;

        board = new int[r][c];
        for (int i = 0; i < r - 2; i++)
            for (int j = 0; j < c - 2; j++)
                board[i + 1][j + 1] = A[i][j];
        for (int i = 0; i < r; i++)
            for (int j = 0; j < c; j++)
                if (i == 0 || i == r - 1 || j == 0 || j == c - 1) {
                    board[i][j] = 1;
                }


        visited = new boolean[r][c];
        dfs(0, 0);
        int cnt = 0;
        for (int i = 1; i < r - 1; i++)
            for (int j = 1; j < c - 1; j++)
                if (board[i][j] == 1 && !visited[i][j]) {
                    cnt++;
                }
        return cnt;
    }

    void dfs(int i, int j) {
        visited[i][j] = true;
        for (int k = 0; k < 4; k++) {
            int x = i + dx[k];
            int y = j + dy[k];
            if (x >= 0 && x < r && y >= 0 && y < c && board[x][y] == 1 && !visited[x][y]) {
                dfs(x, y);
            }
        }
    }
}

