import java.util.Arrays;

/**
 * LeetCode 289 - Game of Life
 *
 * Use the second least significant bit to store the result for next round
 */
public class _289 {
    private int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
    private int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};

    public void gameOfLife(int[][] board) {
        for (int i = 0; i < board.length; i++)
            for (int j = 0; j < board[i].length; j++) {
                int cnt = 0;
                for (int k = 0; k < 8; k++) {
                    int x = i + dx[k];
                    int y = j + dy[k];
                    if (x >= 0 && x < board.length && y >= 0 && y < board[i].length && (board[x][y] & 1) == 1) cnt++;
                }
                if (board[i][j] == 1 && 2 <= cnt && cnt <= 3 || board[i][j] == 0 && cnt == 3) board[i][j] |= 2;
            }
        for (int i = 0; i < board.length; i++)
            for (int j = 0; j < board[i].length; j++)
                board[i][j] >>= 1;
    }
}