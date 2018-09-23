import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

/**
 * LeetCode 909 - Snakes and Ladders
 *
 * BFS
 * Need to read the problem description carefully...
 */
public class _909 {

    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        int[] board1D = new int[n * n + 1];
        int idx = 0;

        for (int i = n - 1; i >= 0; i--) {
            if ((i - (n - 1)) % 2 == 0) {
                for (int j = 0; j < n; j++) {
                    idx++;
                    board1D[idx] = board[i][j];
                }
            } else {
                for (int j = n - 1; j >= 0; j--) {
                    idx++;
                    board1D[idx] = board[i][j];
                }
            }
        }

        Queue<Integer> queue = new ArrayDeque<>();
        Map<Integer, Integer> dist = new HashMap<>();
        queue.add(1);
        dist.put(1, 0);
        while (!queue.isEmpty()) {
            int u = queue.poll();
            for (int i = u + 1; i <= u + 6 && i <= n * n; i++) {
                int v = board1D[i] == -1 ? i : board1D[i];
                if (!dist.containsKey(v)) {
                    dist.put(v, dist.get(u) + 1);
                    if (v == n * n) {
                        return dist.get(v);
                    }
                    queue.add(v);
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        _909 sol = new _909();
        int[][] board = {
                {-1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1},
                {-1, 35, -1, -1, 13, -1},
                {-1, -1, -1, -1, -1, -1},
                {-1, 15, -1, -1, -1, -1},
        };
        System.out.println(sol.snakesAndLadders(board));
    }
}

