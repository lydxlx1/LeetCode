/**
 * LeetCode 400 - Nth Digit
 *
 * Counting + Bisect
 */
public class _400 {
    private long f(int x) {
        long ans = 0, pow = 1, len = 1;
        while (x >= 10 * pow) {
            ans += 9 * pow * len;
            pow *= 10;
            len++;
        }
        return ans + len * (x - pow + 1);
    }

    public int findNthDigit(int n) {
        int left = 0, right = n;
        while (left + 1 < right) {
            int mid = (left + right) / 2;
            if (f(mid) < n) left = mid;
            else right = mid;
        }
        return ("" + (left + 1)).charAt((int) (n - f(left) - 1)) - '0';
    }
}