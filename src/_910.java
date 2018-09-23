import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * LeetCode 910 - Smallest Range II
 *
 * Math
 * Basically, you always want to add K to smaller numbers and subtract K from bigger numbers.
 */
public class _910 {

    public int smallestRangeII(int[] A, int K) {
        Arrays.sort(A);
        int n = A.length;
        int ans = A[n - 1] - A[0];
        for (int i = 0; i < n - 1; i++) {
            int a = A[0] + K;
            int b = A[i] + K;
            int c = A[i + 1] - K;
            int d = A[n - 1] - K;
            int gap = IntStream.of(a, b, c, d).max().getAsInt() - IntStream.of(a, b, c, d).min().getAsInt();
            ans = Math.min(ans, gap);
        }
        return ans;
    }

    public static void main(String[] args) {
        _910 sol = new _910();
    }
}

