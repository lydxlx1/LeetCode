/**
 * LeetCode 978 - Longest Turbulent Subarray
 *
 * Solution
 */
public class _978 {

    public int maxTurbulenceSize(int[] A) {
        int ans = 1;
        for (int i = 0; i < A.length - 1; ) {
            int j = i;
            while (j + 2 < A.length && Integer.signum(A[j] - A[j + 1]) * Integer.signum(A[j + 1] - A[j + 2]) < 0) {
                j++;
            }
            ans = Math.max(ans, (j + 1) - i + 1);
            i = j + 1;
        }
        return ans;
    }
}

