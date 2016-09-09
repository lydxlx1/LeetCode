import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * LeetCode 289 - Game of Life
 * <p>
 * Infinitely board
 */
public class _289_1 {
    private int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
    private int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};

    static class Pair {
        int x, y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int hashCode() {
            int hash = 29;
            hash = hash * 31 + x;
            hash = hash * 31 + y;
            return hash;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Pair)) return false;
            Pair other = (Pair) o;
            return x == other.x && y == other.y;
        }
    }

    public void gameOfLife(int[][] board) {
        Set<Pair> set = new HashSet<>();
        for (int i = 0; i < board.length; i++)
            for (int j = 0; j < board[i].length; j++)
                if (board[i][j] == 1)
                    set.add(new Pair(i, j));
        System.out.println(set);
        Pair tmp = new Pair(0, 0);
        for (int i = 0; i < board.length; i++)
            for (int j = 0; j < board[i].length; j++) {
                int cnt = 0;
                for (int k = 0; k < 8; k++) {
                    int x = i + dx[k];
                    int y = j + dy[k];
                    tmp.x = x;
                    tmp.y = y;
                    if (set.contains(tmp)) cnt++;
                }
                if (board[i][j] == 1 && 2 <= cnt && cnt <= 3 || board[i][j] == 0 && cnt == 3) board[i][j] = 1;
                else board[i][j] = 0;
            }
    }
}