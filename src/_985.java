import java.util.stream.IntStream;

/**
 * LeetCode 985 - Sum of Even Numbers After Queries
 */
public class _985 {

    public int[] sumEvenAfterQueries(int[] A, int[][] queries) {
        int[] res = new int[queries.length];
        int sum = IntStream.of(A).filter(i -> i % 2 == 0).sum();
        for (int i = 0; i < queries.length; i++) {
            int val = queries[i][0], idx = queries[i][1];
            if (A[idx] % 2 == 0) {
                sum -= A[idx];
            }
            A[idx] += val;
            if (A[idx] % 2 == 0) {
                sum += A[idx];
            }
            res[i] = sum;
        }
        return res;
    }
}

