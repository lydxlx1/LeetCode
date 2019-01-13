import java.util.Arrays;

/**
 * LeetCode 976 - Largest Perimeter Triangle
 *
 * Greedy
 */
public class _976 {

    public int largestPerimeter(int[] A) {
        Arrays.sort(A);
        int ans = 0;
        for (int i = A.length - 1; i - 2 >= 0; i--) {
            if (A[i - 2] + A[i - 1] > A[i]) {
                return A[i - 2] + A[i - 1] + A[i];
            }
        }
        return 0;
    }
}
