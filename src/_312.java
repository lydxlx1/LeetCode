/**
 * LeetCode 312 - Burst Balloons
 *
 * O(n^3) DP
 *
 * Let f(i, j) denote the max coins we can gain when given balloon a[i..j].
 * The trick here is to think backwards.
 * Assume the last balloon we burst in a[i..j] is k (i <= k <= j), then
 * 1) we gain a[i - 1] * a[k] * a[j + 1] coins, and
 * 2) f(i, j) is split into two sub-problems f(i, k - 1) and f(k + 1, j).
 * Therefore, f(i, j) = max(a[i - 1] * a[k] * a[j + 1] + f(i, k - 1) + f(k + 1, j)), i <= k <= j.
 * And f(i, j) = 0 if i > j.
 *
 * Remark. If we enumerate the first balloon to burst instead, we won't have the second property any more!
 */
public class _312 {
    Integer[][] f;

    private int F(int[] a, int i, int j) {
        if (i > j) return 0;
        if (f[i][j] != null) return f[i][j];
        int ans = 0;
        for (int k = i; k <= j; k++) {
            int left = i - 1 < 0 ? 1 : a[i - 1];
            int right = j + 1 >= a.length ? 1 : a[j + 1];
            ans = Math.max(ans, left * a[k] * right + F(a, i, k - 1) + F(a, k + 1, j));
        }
        f[i][j] = ans;
        return ans;
    }

    public int maxCoins(int[] nums) {
        f = new Integer[nums.length][nums.length];
        return F(nums, 0, nums.length - 1);
    }
}