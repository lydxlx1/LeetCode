import java.util.*;

/**
 * LeetCode 374 - Guess Number Higher or Lower
 *
 * Binary Search
 */
public class _374 {
    public int guessNumber(int n) {
        int left = 1, right = n;
        while(left <= right) {
            int mid = left + (right - left) / 2;
            int cmp = guess(mid);
            if (cmp < 0) right = mid - 1;
            else if (cmp > 0) left = mid + 1;
            else return mid;
        }
        return -1; // Will never get here
    }

    /**
     * Dummy...
     */
    private int guess(int x) {
        return -1;
    }
}
