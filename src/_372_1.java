/**
 * LeetCode 372 - Super Pow
 * <p>
 * Least significant bit -> most significant bit
 */
public class _372_1 {
    public int superPow(int a, int[] b) {
        final int MOD = 1337;
        int ans = 1;
        a %= MOD;
        for (int i = b.length - 1; i >= 0; i--) {
            for (int j = 0; j < b[i]; j++) ans = ans * a % MOD;
            for (int j = 0, aa = a; j < 9; j++) a = a * aa % MOD;
        }
        return ans;
    }
}
