import java.util.Arrays;

/**
 * LeetCode 452 - Minimum Number of Arrows to Burst Balloons
 *
 * O(n log n) greedy algorithm via sweepline
 */
public class _452 {

    public int findMinArrowShots(int[][] a) {
        if (a == null || a.length <= 0) return 0;
        Arrays.sort(a, (u, v) -> Integer.compare(u[1], v[1])); // sort by end point
        int ans = 1, end = a[0][1];
        for (int i = 1; i < a.length; i++) {
            if (a[i][0] <= end) continue; // using the arrow at coordinate end
            else {
                ans++;
                end = a[i][1];
            }
        }
        return ans;
    }
}
