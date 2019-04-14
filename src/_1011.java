/**
 * LeetCode 1011 - Capacity To Ship Packages Within D Days
 *
 * Bisect on the final answer
 */
public class _1011 {

    public int shipWithinDays(int[] weights, int D) {
        int left = 0, right = 1 << 29;
        while (left + 1 < right) {
            int mid = (left + right) / 2;
            if (isok(weights, D, mid)) {
                right = mid;
            } else {
                left = mid;
            }
        }
        return right;
    }

    boolean isok(int[] weights, int D, int limit) {
        int free = 0;
        for (int i = 0; i < weights.length && D >= 0; i++) {
            if (weights[i] > limit) {
                return false;
            }
            if (free >= weights[i]) {
                free -= weights[i];
            } else {
                D--;
                free = limit - weights[i];
            }
        }
        return D >= 0;
    }
}

