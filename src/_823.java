import java.util.stream.IntStream;


/**
 * LeetCode 823 - Binary Trees with Factors
 * <p>
 * DP + Two pointers
 */
public class _823 {

    long mod = 1000000007;

    public int numFactoredBinaryTrees(int[] A) {
        A = IntStream.of(A).distinct().sorted().toArray();

        long ans = 0;
        long[] f = new long[A.length];
        for (int i = 0; i < f.length; i++) {
            f[i] = 1;

            int l = 0, r = i - 1;
            while (l <= r) {
                if ((long) A[l] * A[r] == A[i]) {
                    if (l == r) {
                        f[i] += f[l] * f[r] % mod;
                        f[i] %= mod;
                    } else {
                        f[i] += f[l] * f[r] % mod * 2;
                        f[i] %= mod;
                    }

                    l++;
                    r--;
                } else if ((long) A[l] * A[r] > A[i]) {
                    r--;
                } else {
                    l++;
                }
            }

            ans += f[i];
            ans %= mod;
        }

        return (int) ans;
    }
}

