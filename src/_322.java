import java.util.Arrays;

/**
 * LeetCode 322 - Coin Change
 *
 * Traditional Knapsack Problem
 */
public class _322 {
    public int coinChange(int[] coins, int amount) {
        int[] f = new int[amount + 1];
        Arrays.fill(f, Integer.MAX_VALUE / 2);
        f[0] = 0;
        for (int coin : coins)
            for (int j=coin; j<f.length; j++)
                f[j] = Math.min(f[j], f[j - coin] + 1);
        return f[amount] == Integer.MAX_VALUE / 2 ? -1 : f[amount];
    }
}