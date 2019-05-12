import java.util.HashSet;
import java.util.Set;

/**
 * LeetCode 1044 - Longest Duplicate Substring
 *
 * Bisection + Sliding window + Rolling hash
 */
public class _1044 {

    long b = 29;
    long mod = 67280421310721L; // A sufficient large prime number s.t. mod * b is not overflowing long.
    int ptr;

    public String longestDupSubstring(String S) {
        int left = 0, right = S.length();
        while (left + 1 < right) {
            int mid = (left + right) / 2;
            if (ok(S, mid)) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return left == 0 ? "" : S.substring(ptr, ptr + left);
    }

    boolean ok(String S, int len) {
        Set<Long> set = new HashSet<>();
        long pow = 1;
        for (int i = 0; i < len - 1; i++) {
            pow = pow * b % mod;
        }

        long val = 0;
        for (int i = 0; i < S.length(); i++) {
            if (i - len >= 0) {
                long sub = (S.charAt(i - len) - 'a' + 1) * pow % mod;
                val = (val - sub + mod) % mod;
            }
            val = (val * b + S.charAt(i) - 'a' + 1) % mod;

            if (i >= len - 1) {
                if (set.contains(val)) {
                    ptr = i - len + 1;
                    return true;
                } else {
                    set.add(val);
                }
            }
        }
        return false;
    }
}
