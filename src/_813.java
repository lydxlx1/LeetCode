/**
 * LeetCode 813 - Largest Sum of Averages
 * <p>
 * DP
 * <p>
 * The problem says **at most K** adjacent (non-empty) groups.
 * But it is easy to see that the more groups and the larger the sum of averages, which means we are going to make
 * EXACTLY K groups.
 */
public class _813 {

    public double largestSumOfAverages(int[] A, int K) {
        double[] prefixSum = new double[A.length];
        for (int i = 0; i < A.length; i++) {
            prefixSum[i] = A[i] + (i > 0 ? prefixSum[i - 1] : 0);
        }

        double[][] f = new double[K + 1][A.length];
        for (int i = 1; i <= K; i++) {
            for (int j = 0; j < A.length; j++) {
                if (i == 1) {
                    f[i][j] = prefixSum[j] / (j + 1);
                } else {
                    for (int k = 1; k <= j; k++) {
                        double avg = (prefixSum[j] - prefixSum[k - 1]) / (j - k + 1);
                        f[i][j] = Math.max(f[i][j], f[i - 1][k - 1] + avg);
                    }
                }
            }
        }
        return f[K][A.length - 1];
    }
}
