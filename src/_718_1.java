import java.util.HashSet;
import java.util.Set;

/**
 * LeetCode 718 - Maximum Length of Repeated Subarray
 * <p>
 * Binary search +  rolling hash
 * Time: O(log(min(A, B)) * (A + B))
 * Space: O(min(A, B))
 */
public class _718_1 {
    static long MOD = 1000000007;
    static int M = 103; // Each number is within the range of [0, 100]. Pick a relatively small prime > 100 + 1.

    public int findLength(int[] A, int[] B) {
        int left = 0, right = Math.min(A.length, B.length) + 1;
        while (left + 1 < right) {
            int mid = (left + right) / 2;
            if (isOk(A, B, mid)) left = mid;
            else right = mid;
        }
        return left;
    }

    private boolean isOk(int[] a, int[] b, int len) {
        if (len == 0) return true;
        if (a.length > b.length) return isOk(b, a, len); // An optimization for the space complexity
        Set<Long> set = new HashSet<>();
        long hash = 0, high = pow(M, len - 1);
        for (int i = 0; i < a.length; i++) {
            if (i >= len) {
                hash = hash - (a[i - len] + 1) * high % MOD + MOD;
            }
            hash = (hash * M + a[i] + 1) % MOD;
            if (i >= len - 1) {
                set.add(hash);
            }
        }

        hash = 0;
        for (int i = 0; i < b.length; i++) {
            if (i >= len) {
                hash = hash - (b[i - len] + 1) * high % MOD + MOD;
            }
            hash = (hash * M + (b[i] + 1)) % MOD;
            if (i >= len - 1 && set.contains(hash)) {
                return true;
            }
        }
        return false;
    }

    private long pow(long a, long n) {
        long ans = 1;
        while (n > 0) {
            if (n % 2 == 1) ans = ans * a % MOD;
            a = a * a % MOD;
            n /= 2;
        }
        return ans;
    }


    public static void main(String[] args) {
        _718_1 sol = new _718_1();
        System.out.println(sol.findLength(new int[]{1, 2, 3, 2, 1}, new int[]{3, 2, 1, 4, 7}));
    }
}
