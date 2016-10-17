/**
 * LeetCode 413 - Arithmetic Slices
 * <p>
 * Compute the difference array for any two consecutive numbers in A.
 * Partition the diff array into subarrays such that each subarray contains the unique number only.
 * <p>
 * Assume one subarray has length x, then it contributes (x+1)*x/2 - x arithmetic slices.
 * Summing them up gives us the final answer.
 */
public class _413 {
    public int numberOfArithmeticSlices(int[] A) {
        if (A.length <= 2) return 0;
        int[] diff = new int[A.length - 1];
        for (int i = 0; i < diff.length; i++) diff[i] = A[i + 1] - A[i];
        int ans = 0;
        for (int i = 0, j = 0; i < diff.length; i = j) {
            for (j = i + 1; j < diff.length && diff[i] == diff[j]; j++) ;
            long cnt = j - i;
            ans += (int) ((cnt + 1) * cnt / 2 - cnt);
        }
        return ans;
    }
}
