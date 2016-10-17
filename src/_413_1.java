/**
 * LeetCode 413 - Arithmetic Slices
 * <p>
 * An in-place solution
 */
public class _413_1 {
    public int numberOfArithmeticSlices(int[] A) {
        int ans = 0, cnt = 0;
        Integer diff = null;
        for (int i = 1; i < A.length; i++)
            if (A[i] - A[i - 1] == diff) cnt++;
            else {
                ans += (cnt + 1) * cnt / 2 - cnt;
                cnt = 1;
                diff = A[i] - A[i - 1];
            }
        return ans + (cnt + 1) * cnt / 2 - cnt;
    }
}
