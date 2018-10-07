import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * LeetCode 918 - Maximum Sum Circular Subarray
 *
 * Let's solve a harder version --- find the maximum subarray subject to a length limit.
 * And here is solution using Divide-and-Conquer.
 */
public class _918 {

    public int maxSubarraySumCircular(int[] A) {
        return dfs(IntStream.concat(IntStream.of(A), IntStream.of(A)).toArray(), A.length);
    }

    int dfs(int[] A, int maxSubarraySize) {
        if (A.length == 1) {
            return A[0];
        }
        int mid = A.length / 2;
        int[] left = Arrays.copyOfRange(A, 0, mid);
        int[] right = Arrays.copyOfRange(A, mid, A.length);
        int ans = Math.max(dfs(left.clone(), maxSubarraySize), dfs(right.clone(), maxSubarraySize));

        int leftSum = 0;
        for (int i = 1; i < right.length; i++) {
            right[i] += right[i - 1];
        }
        for (int i = 1; i < right.length; i++) {
            right[i] = Math.max(right[i - 1], right[i]);
        }

        for (int i = left.length - 1; i >= 0; i--) {
            leftSum += left[i];

            int cntLeft = left.length - i;
            if (cntLeft >= maxSubarraySize) {
                break;
            }
            int sum = leftSum + right[Math.min(right.length - 1, maxSubarraySize - cntLeft - 1)];
            ans = Math.max(ans, sum);
        }

        return ans;
    }
}

