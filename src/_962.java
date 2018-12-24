import java.util.Arrays;

/**
 * LeetCode 962 - Maximum Width Ramp
 *
 * Sweep-line + Binary Indexed Tree
 */
public class _962 {

    int[] bit;
    int inf = Integer.MAX_VALUE;

    void add(int i, int val) {
        for (; i < bit.length; i += Integer.lowestOneBit(i)) {
            bit[i] = Math.min(bit[i], val);
        }
    }

    int query(int i) {
        int ans = inf;
        while (i > 0) {
            ans = Math.min(ans, bit[i]);
            i -= Integer.lowestOneBit(i);
        }
        return ans;
    }

    public int maxWidthRamp(int[] A) {
        for (int i = 0; i < A.length; i++) {
            A[i]++;
        }
        bit = new int[55555];
        Arrays.fill(bit, inf);

        int ans = 0;
        for (int i = 0; i < A.length; i++) {
            int q = query(A[i]);
            if (q != inf) {
                ans = Math.max(ans, i - q);
            }
            add(A[i], i);
        }
        return ans;
    }
}

