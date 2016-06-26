/**
 * LeetCode 367 - Valid Perfect Square
 *
 * Binary Search
 */
public class _367 {
    public boolean isPerfectSquare(int num) {
        long l = 0, r = num;
        while (l <= r) {
            long mid = (l + r) / 2;
            if (mid * mid > num) r = mid - 1;
            else if (mid * mid < num) l = mid + 1;
            else return true;
        }
        return false;
    }
}