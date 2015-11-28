/**
 * Leetcode 307 - Range Sum Query - Mutable
 *
 * O(1) update, O(sqrt(n)) query
 *
 * Partition the origin array into roughly sqrt(n) chunks, and each chunk contains about sqrt(n) numbers.
 * Maintain the sum in each chunk.
 *
 * An update operation involves modifying one slot the origin array as well as the sum of the corresponding chunk.
 * Clearly, this step takes O(1) time.
 *
 * A range sum query is associated with an interval [i, j].
 * That interval can cover at most sqrt(n) whole chunks, i.e., O(sqrt(n)) time to add up the sum in these chunks.
 * There are at most two chunks, one on each side, which are partially covered.
 * We add the sum of these two parts by brute-force, which takes O(2 * sqrt(n)) = O(sqrt(n)) time.
 * Therefore, the range sum query can be computed in O(sqrt(n)) time.
 *
 *             i                               j
 *             |                               |
 *             v                               v
 * +-------+-------+-------+-------+-------+-------+-------+-------+
 * |       |   ....|*******|*******|*******|....   |       |       |
 * +-------+-------+-------+-------+-------+-------+-------+-------+
 *
 *    . --- computed by brute force
 *    * --- at most sqrt(n) whole chunks
 */
public class _307 {

    int[] bucket;
    int size;
    int[] a;

    public _307(int[] nums) {
        this.a = nums;
        size = (int)Math.sqrt(a.length) + 1;
        bucket = new int[nums.length / size + 2];
        for (int i=0; i<nums.length; i++) bucket[i / size] += nums[i];
    }

    void update(int i, int val) {
        bucket[i / size] += val - a[i];
        a[i] = val;
    }

    public int sumRange(int i, int j) {
        int ans = 0;
        while(i % size != 0 && i <= j) ans += a[i++];
        while(j % size != size - 1 && i <= j) ans += a[j--];
        if (i <= j) for (int k=i / size; k<(j+1)/size; k++) ans += bucket[k];
        return ans;
    }
}