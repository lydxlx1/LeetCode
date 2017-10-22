/**
 * LeetCode 714 - Best Time to Buy and Sell Stock with Transaction Fee
 * <p>
 * O(n)-DP
 * The transaction fee concept is actually not bringing anything new.
 * <p>
 * Start from a naive O(n^2)-time DP.
 * Let f[i] denote the maximum money one can earn for prices[0..i].
 * Then, f[i] = max(f[i-1], max(f[j-1] + price[i] - price[j] - fee), 0 <= j < i), and let f[-1] = 0.
 * <p>
 * To optimize the time for the inner max(), note that at the i-th iteration, the inner max can be rewritten as
 * price[i] + max(f[j-1] - price[j] - fee).
 * Then, we can maintain this max(.) instead, and thus, each f[i] can be computed in O(1) time.
 */
public class _714 {
    public static void main(String[] args) {
        _714 sol = new _714();
        System.out.println(sol.maxProfit(new int[]{1, 3, 2, 8, 4, 9}, 2));
        System.out.println(sol.maxProfit(new int[]{1, 2}, 2));
        System.out.println(sol.maxProfit(new int[]{1, 32}, 2));
        System.out.println(sol.maxProfit(new int[]{4, 5, 2, 4, 3, 3, 1, 2, 5, 4}, 1));
    }


    public int maxProfit(int[] prices, int fee) {
        int ans = 0;
        int n = prices.length;
        if (n < 2) return 0;

        int[] f = new int[n];
        int innerMax = -prices[0] - fee;
        for (int i = 1; i < n; i++) {
            f[i] = Math.max(f[i - 1], prices[i] + innerMax);
            innerMax = Math.max(innerMax, f[i - 1] - prices[i] - fee);
            ans = Math.max(ans, f[i]);
        }

        return ans;
    }
}
