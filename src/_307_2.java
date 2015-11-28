/**
 * LeetCode 307 - Range Sum Query - Mutable
 *
 * Segment Tree
 * O(log n) update/query
 */
public class _307_2 {

    int[] a;
    int[] tree;

    private void build(int i, int left, int right) {
        if (left == right) tree[i] = a[left];
        else {
            int mid = (left + right) / 2;
            build(2 * i, left, mid);
            build(2 * i + 1, mid + 1, right);
            tree[i] = tree[2 * i] + tree[2 * i + 1];
        }
    }

    private void update(int i, int left, int right, int index, int val) {
        if (left == index && right == index) tree[i] = val;
        else if (left > index || right < index) return;
        else {
            int mid = (left + right) / 2;
            update(2 * i, left, mid, index, val);
            update(2 * i + 1, mid + 1, right, index, val);
            tree[i] = tree[2 * i] + tree[2 * i + 1];
        }
    }

    private int query(int i, int left, int right, int begin, int end) {
        if (left > end || right < begin) return 0;
        else if (begin <= left && right <= end) return tree[i];
        else {
            int mid = (left + right) / 2;
            return query(2 * i, left, mid, begin, end) + query(2 * i + 1, mid + 1, right, begin, end);
        }
    }

    public _307_2(int[] nums) {
        a = nums;
        tree = new int[4 * a.length + 1];
        if (nums.length > 0) build(1, 0, nums.length - 1);
    }

    void update(int i, int val) {
        a[i] = val;
        update(1, 0, a.length - 1, i, val);
    }

    public int sumRange(int i, int j) {
        return query(1, 0, a.length - 1, i, j);
    }
}