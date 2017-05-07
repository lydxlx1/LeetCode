/**
 * LeetCode 573 - Squirrel Simulation
 * <p>
 * Greedy
 */
public class _573 {
    public int minDistance(int height, int width, int[] tree, int[] squirrel, int[][] nuts) {
        int ans = Integer.MAX_VALUE;
        int sum = 0;
        for (int[] nut : nuts)
            sum += 2 * dist(nut, tree);
        for (int[] nut : nuts)
            ans = Math.min(ans, sum - dist(nut, tree) + dist(nut, squirrel));
        return ans;
    }

    private int dist(int[] a, int[] b) {
        return Math.abs(a[0] - b[0]) + Math.abs(a[1] - b[1]);
    }
}
