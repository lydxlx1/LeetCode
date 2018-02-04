import java.util.Scanner;

/**
 * LeetCode 774 - Minimize Max Distance to Gas Station
 * <p>
 * Binary Search
 */
public class _774 {

    public double minmaxGasDist(int[] stations, int K) {
        double left = 0, right = 1e8;
        for (int i = 0; i < 100; i++) {
            double mid = (left + right) / 2;
            if (isok(stations, mid, K)) {
                right = mid;
            } else {
                left = mid;
            }
        }
        return left;
    }

    private boolean isok(int[] a, double gap, int k) {
        int cnt = 0;
        for (int i = 0; i < a.length - 1; i++) {
            cnt += Math.max(0, (int) Math.ceil((a[i + 1] - a[i]) / gap) - 1);
        }
        return cnt <= k;
    }

}
