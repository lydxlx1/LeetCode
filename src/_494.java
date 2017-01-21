import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * LeetCode 494 - Target Sum
 * <p>
 * Knapsack
 */
public class _494 {

    public int findTargetSumWays(int[] nums, int S) {
        final int OFFSET = 1001;
        int[] f = new int[2 * OFFSET];
        f[0 + OFFSET] = 1;

        for (int num : nums) {
            int[] g = new int[2 * OFFSET];
            for (int i = 0; i < g.length; i++) {
                if (i + num < g.length) g[i] += f[i + num];
                if (i - num >= 0) g[i] += f[i - num];
            }
            f = g;
        }

        return -OFFSET <= S && S <= OFFSET ? f[S + OFFSET] : 0;
    }

    @Test
    public void test() {
        int[] nums = {1, 1, 1, 1, 1};
        int S = 3;
        int expected = 5;
        int actual = new _494().findTargetSumWays(nums, S);
        assertEquals(expected, actual);
    }

    @Test
    public void test1() {
        int[] nums = {};
        int S = 0;
        int expected = 1;
        int actual = new _494().findTargetSumWays(nums, S);
        assertEquals(expected, actual);
    }

    @Test
    public void test2() {
        int[] nums = {2, 107, 109, 113, 127, 131, 137, 3, 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 47, 53};
        int S = 2147483647;
        int expected = 0;
        int actual = new _494().findTargetSumWays(nums, S);
        assertEquals(expected, actual);
    }

    @Test
    public void test3() {
        int[] nums = {2, 107, 109, 113, 127, 131, 137, 3, 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 47, 53};
        int S = -2147483648;
        int expected = 0;
        int actual = new _494().findTargetSumWays(nums, S);
        assertEquals(expected, actual);
    }
}
