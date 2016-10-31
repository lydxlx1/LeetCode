/**
 * LeetCode 441 - Arranging Coins
 * <p>
 * O(1) Brute-force
 */
public class _441 {
    public int arrangeCoins(int n) {
        for (long k = (long) Math.sqrt(2.0 * n) + 5; k >= 0; k--)
            if (k * (k + 1) / 2 <= n) return (int) k;
        throw new RuntimeException("Failed...");
    }
}