/**
 * LeetCode 1031 - Maximum Sum of Two Non-Overlapping Subarrays
 *
 * Brute-force
 * Indeed, it is pretty easy to write an O(n) time and space solution, but I was just being lazy...
 */
public class _1031 {

    public int maxSumTwoNoOverlap(int[] A, int L, int M) {
        for (int i = 1; i < A.length; i++) {
            A[i] += A[i - 1];
        }
        int ans = 0;
        for (int i = 0; i + L + M <= A.length; i++) {
            for (int j = i + L; j + M <= A.length; j++) {
                int first = A[i + L - 1] - (i - 1 >= 0 ? A[i - 1] : 0);
                int second = A[j + M - 1] - A[j - 1];
                ans = Math.max(ans, first + second);
            }
            for (int j = i + M; j + L <= A.length; j++) {
                int first = A[i + M - 1] - (i - 1 >= 0 ? A[i - 1] : 0);
                int second = A[j + L - 1] - A[j - 1];
                ans = Math.max(ans, first + second);
            }
        }
        return ans;
    }
}
