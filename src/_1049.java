import java.util.stream.IntStream;

/**
 * LeetCode 1049 - Last Stone Weight II
 *
 * Knapsack
 * This problem is equivalent to find a subset of stones with sum closest to half of the total sum.
 */
public class _1049 {

    public int lastStoneWeightII(int[] stones) {
        int sum = IntStream.of(stones).sum();
        boolean[] f = new boolean[sum + 1];
        f[0] = true;
        int ans = sum;
        for (int stone : stones) {
            for (int j = sum; j - stone >= 0; j--) {
                f[j] = f[j] || f[j - stone];
                if (f[j]) {
                    ans = Math.min(ans, Math.abs(j - (sum - j)));
                }
            }
        }
        return ans;
    }
}
