import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

/**
 * LeetCode 956 - Tallest Billboard
 *
 * A naive DP solution:
 * f[i][a][b]: Whether it is possible to achieve that left billboard = a && right billboard = b, using the first i boards.
 * But this will use too much space (and hence the run time).
 *
 * Alternatively, if we can dp on the difference, i.e., a - b, and maximize either a or b.
 * (Note that, then a - b is fixed, maximizing a is equivalent as maximizing b.)
 */
public class _956 {

    int offset = 5555;
    int min = Integer.MIN_VALUE / 3;

    public int tallestBillboard(int[] rods) {
        int n = rods.length;
        int[][] f = new int[n + 1][offset * 2];
        for (int[] each : f) {
            Arrays.fill(each, min);
        }

        int ans = 0;
        Queue<int[]> queue = new ArrayDeque<>();
        update(queue, f, 0, 0, 0);
        while (!queue.isEmpty()) {
            int i = queue.peek()[0];
            int diff = queue.poll()[1];
            int val = f[i][offset + diff];
            if (diff == 0) {
                ans = Math.max(ans, val);
            }

            if (i < n) {
                update(queue, f, i + 1, diff, val);
                update(queue, f, i + 1, diff + rods[i], val + rods[i]);
                update(queue, f, i + 1, diff - rods[i], val);
            }
        }
        return ans;
    }

    void update(Queue<int[]> queue, int[][] f, int i, int diff, int val) {
        if (f[i][diff + offset] == min) {
            queue.add(new int[]{i, diff});
        }
        f[i][diff + offset] = Math.max(f[i][diff + offset], val);
    }
}

