import java.util.Arrays;

/**
 * LeetCode 945 - Minimum Increment to Make Array Unique
 *
 * Counting
 */
public class _945 {

    public int minIncrementForUnique(int[] A) {
        Arrays.sort(A);
        int ans = 0, next = Integer.MIN_VALUE;
        for (int i = 0; i < A.length; i++) {
            if (A[i] > next) {
                next = A[i] + 1;
            } else {
                ans += next - A[i];
                next++;
            }
        }
        return ans;
    }
}

