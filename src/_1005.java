import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * LeetCode 1005 - Maximize Sum of Array After K Negations
 *
 * Greedy
 */
public class _1005 {

    public int largestSumAfterKNegations(int[] A, int K) {
        Arrays.sort(A);
        for (int i = 0; i < A.length && A[i] < 0 && K > 0; i++) {
            A[i] = -A[i];
        }
        int ans = IntStream.of(A).sum();
        if (K % 2 == 1) {
            ans -= IntStream.of(A).min().getAsInt() * 2;
        }
        return ans;
    }
}

