/**
 * LeetCode 307 - Range Sum Query - Mutable
 *
 * Binary Indexed Tree (Fenwick Tree)
 * O(log n) update/query
 *
 * See below for the tutorials of BIT.
 * [1] https://www.topcoder.com/community/data-science/data-science-tutorials/binary-indexed-trees/
 * [2] https://en.wikipedia.org/wiki/Fenwick_tree
 */
public class _307_1 {

    int[] a;
    int[] bit;

    private void add(int i, int val) {
        for (; i<bit.length; i += i & -i) bit[i] += val;
    }

    private int sum(int i) {
        int ans = 0;
        for (; i>0; i -= i & -i) ans += bit[i];
        return ans;
    }

    public _307_1(int[] nums) {
        a = nums;
        bit = new int[nums.length + 1];
        for (int i=0; i<nums.length; i++) add(i + 1, nums[i]);
    }

    void update(int i, int val) {
        add(i + 1, -a[i]);
        add(i + 1, val);
        a[i] = val;
    }

    public int sumRange(int i, int j) {
        return sum(j + 1) - sum(i);
    }
}