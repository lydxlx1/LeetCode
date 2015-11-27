/**
 * LeetCode 309 - Best Time to Buy and Sell Stock with Cooldown
 *
 * Let us start with a simple DP solution.
 * Let f[i] be largest profit when given the stock price on day 0, 1, ..., i.
 * Consider the possible actions on day i, we have the following two choices.
 *
 * 1) Cooldown on at day, then f[i] = f[i - 1];
 * 2) Sell the stock, then we need to determine the best day to buy in.
 *    If we buy in on day j (j < i), then we must cooldown on day j - 1,
 *    and then the optimal structure property applies to day 0, 1, ..., j - 2.
 *    Therefore, f[i] = max(f[j - 2] + price[i] - price[j]), 0 <= j < i.
 * Note that buying in on day i is meaningless since we can never sell it out under the constrain [0, i].
 *
 * For the boundary case, define f[i] = 0 for all i <= 1.
 *
 * The final answer is f[n - 1], and the entire DP solution runs in O(n^2) time.
 * Question: How to improve the runtime to O(n)?
 */
public class _309 {
    public int maxProfit(int[] a) {
        int[] f = new int[a.length];
        for (int i=1; i<a.length; i++) {
            f[i] = f[i - 1];
            for (int j=0; j<i; j++)
                f[i] = Math.max(f[i], a[i] - a[j] + (j - 2 >= 0 ? f[j - 2] : 0));
        }
        return f.length == 0 ? 0 : f[f.length - 1];
    }
}