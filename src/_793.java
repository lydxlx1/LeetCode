/**
 * LeetCode 793 - Preimage Size of Factorial Zeroes Function
 * <p>
 * Binary Search + Math
 */
public class _793 {


    public int preimageSizeFZF(int K) {
        if (K == 0) {
            return 5;
        }
        return (int) (search(K) - search(K - 1));
    }

    /**
     * Find the largest x such that f(x) <= K.
     */
    long search(long K) {
        long left = 0, right = 10L * Integer.MAX_VALUE;
        while (left + 1 < right) {
            long mid = (left + right) / 2;
            if (f(mid) <= K) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return left;
    }

    long f(long n) {
        long cnt = 0;
        while (n > 0) {
            cnt += n / 5;
            n /= 5;
        }
        return cnt;
    }
}
