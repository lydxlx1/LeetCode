/**
 * LeetCode 309 - Best Time to Buy and Sell Stock with Cooldown
 *
 * Previous, we have the recurrence relation as
 * f[i] = max(f[i - 1], max(f[j - 2] + price[i] - price[j])), for 0 <= j < i
 *      = max(f[i - 1], price[i] + max(f[j - 2] - price[j])), since price[i] is a constant w.r.t. to j,
 * and
 * f[i] = 0, for all i <= 1.
 *
 * If we define a new recurrence
 * g[i] = max(f[i - 2] - price[i]), 0 <= i < n,
 * then
 * f[i] = max(f[i - 1], price[i] + g[i - 1]).
 *
 * Now, it is clear that both g and f array can be computed simultaneously in O(n) time.
 */
public class _309_1 {
    public int maxProfit(int[] a) {
        int[] f = new int[a.length];
        int delta = Integer.MIN_VALUE / 2;
        for (int i=1; i<a.length; i++) {
            delta = Math.max(delta, -a[i - 1] + (i - 3 >= 0 ? f[i - 3] : 0));
            f[i] = Math.max(f[i - 1], a[i] + delta);
        }
        return f.length == 0 ? 0 : f[f.length - 1];
    }
}