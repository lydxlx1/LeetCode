/**
 * LeetCode 837 - New 21 Game
 * <p>
 * DP + Sliding window
 */
public class _837 {

    public double new21Game(int N, int K, int W) {
        if (K == 0) {
            return 1;
        }

        double[] f = new double[N + K + 1];

        f[0] = 1;
        double acc = 1.0 / W;
        for (int i = 1; i < f.length; i++) {
            if (i - W - 1 >= 0 && i - W - 1 < K) {
                acc -= f[i - W - 1] / W;
            }
            f[i] = acc;
            if (i < K) {
                acc += f[i] / W;
            }
        }

        double ans = 0;
        for (int i = K; i <= N; i++)
            ans += f[i];
        return ans;
    }
}

