import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * LeetCode 327 - Count of Range Sum
 *
 * O(n log n) by Fenwick Tree
 *
 * See here for the solution https://leetcode.com/discuss/79100/an-o-n-log-n-solution-via-fenwick-tree
 */
public class _327 {
    public int countRangeSum(int[] nums, int lower, int upper) {
        List<Long> cand = new ArrayList<>();
        cand.add(Long.MIN_VALUE); // make sure no number gets a 0-index.
        cand.add(0L);
        long[] sum = new long[nums.length + 1];
        for (int i = 1; i < sum.length; i++) {
            sum[i] = sum[i - 1] + nums[i - 1];
            cand.add(sum[i]);
            cand.add(lower + sum[i - 1] - 1);
            cand.add(upper + sum[i - 1]);
        }
        Collections.sort(cand);

        int[] bit = new int[cand.size()];
        for (int i = 0; i < sum.length; i++) plus(bit, Collections.binarySearch(cand, sum[i]), 1);
        int ans = 0;
        for (int i = 1; i < sum.length; i++) {
            plus(bit, Collections.binarySearch(cand, sum[i - 1]), -1);
            ans += query(bit, Collections.binarySearch(cand, upper + sum[i - 1]));
            ans -= query(bit, Collections.binarySearch(cand, lower + sum[i - 1] - 1));
        }
        return ans;
    }

    private void plus(int[] bit, int i, int delta) {
        for (; i < bit.length; i += i & -i) bit[i] += delta;
    }

    private int query(int[] bit, int i) {
        int sum = 0;
        for (; i > 0; i -= i & -i) sum += bit[i];
        return sum;
    }
}