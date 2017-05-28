/**
 * LeetCode 598 - Range Addition II
 * <p>
 * An interesting problem...
 */
public class _598 {
    public int maxCount(int m, int n, int[][] ops) {
        int ans = m * n;
        int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
        for (int[] op : ops) {
            min1 = Math.min(min1, op[0]);
            min2 = Math.min(min2, op[1]);
            ans = Math.min(ans, min1 * min2);
        }
        return ans;
    }
}
