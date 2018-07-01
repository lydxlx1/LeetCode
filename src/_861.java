/**
 * LeetCode 861 - Score After Flipping Matrix
 * <p>
 * Greedy+Math
 */
public class _861 {

    public int matrixScore(int[][] A) {
        for (int i = 0; i < A.length; i++) {
            if (A[i][0] == 0) {
                for (int j = 0; j < A[i].length; j++) {
                    A[i][j] = 1 - A[i][j];
                }
            }
        }

        int ans = 0;
        for (int j = 0; j < A[0].length; j++) {
            int zero = 0, one = 0;
            for (int i = 0; i < A.length; i++) {
                if (A[i][j] == 0) {
                    zero++;
                } else {
                    one++;
                }
            }
            // This works for the first column too, as it is guaranteed to be all ones.
            ans += Math.max(zero, one) * (1 << (A[0].length - j - 1));
        }
        return ans;
    }
}

