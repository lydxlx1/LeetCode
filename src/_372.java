/**
 * LeetCode 372 - Super Pow
 * <p>
 * Most significant bit -> Least significant bit
 */
public class _372 {
    public int superPow(int a, int[] b) {
        final int MOD = 1337;
        a %= MOD;
        int ans = 1;
        for (int i = 0; i < b.length; i++) {
            for (int tmp = ans, j = 0; j < 9; j++) ans = ans * tmp % MOD;
            for (int j = 0; j < b[i]; j++) ans = ans * a % MOD;
        }
        return ans;
    }
}
