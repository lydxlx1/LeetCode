/**
 * LeetCode 370 Range Addition
 *
 * Using Binary Indexed Tree (or Fenwick Tree) to achieve fast
 * 1) range addition and
 * 2) point query.
 */
public class _370 {

    int[] bit;

    private void add(int i, int delta) {
        for (; i < bit.length; i += Integer.lowestOneBit(i)) bit[i] += delta;
    }

    private int sum(int i) {
        int ans = 0;
        for (; i > 0; i -= Integer.lowestOneBit(i)) ans += bit[i];
        return ans;
    }

    public int[] getModifiedArray(int length, int[][] updates) {
        bit = new int[length + 1];
        for (int[] update : updates) {
            add(update[1] + 1, update[2]);
            if (update[0] > 0) add(update[0], -update[2]);
        }
        int[] ans = new int[length];
        for (int i = 0; i < ans.length; i++) ans[i] = sum(ans.length) - sum(i);
        return ans;
    }
}