/**
 * LeetCode 453 - Minimum Moves to Equal Array Elements
 * <p>
 * Incrementing n - 1 elements by 1 is equivalent to decrementing the remaining element by 1.
 */
public class _453 {
    public int minMoves(int[] nums) {
        if (nums == null || nums.length <= 1) return 0;
        int ans = 0, min = Integer.MAX_VALUE;
        for (int i : nums) min = Math.min(min, i);
        for (int i : nums) ans += i - min;
        return ans;
    }
}