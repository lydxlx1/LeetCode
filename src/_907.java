import java.util.Arrays;

/**
 * LeetCode 907 - Sub of Subarray Minimums
 *
 * Divide-and-Conquer approach
 */
public class _907 {

    int mod = 1000000007;

    public int sumSubarrayMins(int[] A) {
        if (A.length == 1) {
            return A[0];
        }

        int mid = A.length / 2;
        int[] left = Arrays.copyOfRange(A, 0, mid);
        int[] right = Arrays.copyOfRange(A, mid, A.length);
        long ans = 0;

        ans += sumSubarrayMins(left.clone());
        ans += sumSubarrayMins(right.clone());

        long localSum = 0;
        for (int i = left.length - 2; i >= 0; i--) {
            left[i] = Math.min(left[i], left[i + 1]);
        }
        for (int j = 1; j < right.length; j++) {
            right[j] = Math.min(right[j], right[j - 1]);
        }

        int i = left.length - 1, j = 0;
        // We are essentially merge left and right in non-increasing order.
        while (i >= 0 && j < right.length) {
            if (left[i] > right[j]) {
                localSum += 1L * left[i] * j; // Right boundaries covered by this: right[0], right[1], ..., right[j-1].
                i--;
            } else {
                localSum += 1L * right[j] * (left.length - i - 1);  // Left boundaries covered by this: left[i+1], left[i+2], ..., left[left.length - 1].
                j++;
            }
            localSum %= mod;
        }
        for (; i >= 0; i--) {
            localSum += 1L * left[i] * right.length;
            localSum %= mod;
        }
        for (; j < right.length; j++) {
            localSum += 1L * right[j] * left.length;
            localSum %= mod;
        }

        ans += localSum;
        ans %= mod;

        return (int) ans;
    }
}

