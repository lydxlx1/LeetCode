/**
 * LeetCode 410 - Split Array Largest Sum
 *
 * Bisect + Greedy
 */
public class _410 {
    private long split(int[] a, long limit) {
        long cnt = 0, sum = 0;
        for (int i : a) {
            if (sum + i > limit) {
                sum = 0;
                cnt++;
            }
            sum += i;
        }
        return cnt + Math.min(sum, 1);
    }

    public int splitArray(int[] nums, int m) {
        long max = Long.MIN_VALUE;
        for (int i : nums) max = Math.max(max, i);
        long left = max - 1, right = Long.MAX_VALUE / 2;
        while (left + 1 < right) {
            long mid = (left + right) / 2;
            if (split(nums, mid) <= m) right = mid;
            else left = mid;
        }
        return (int) right;
    }
}