import java.util.HashMap;

/**
 * LeetCode 447 - Number of Boomerangs
 * <p>
 * O(n^2) solution
 * Enumerate the head (i.e., i) of each boomerangs, then count the number of ordered pair of tails (i.e., j and k).
 */
public class _447 {
    public int numberOfBoomerangs(int[][] points) {
        if (points == null || points.length <= 0) return 0;

        int ans = 0, n = points.length;
        for (int i = 0; i < n; i++) {
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int j = 0; j < n; j++) {
                if (i == j) continue;
                int d = sqr(points[i][0] - points[j][0]) + sqr(points[i][1] - points[j][1]);
                map.putIfAbsent(d, 0);
                ans += 2 * map.put(d, map.get(d) + 1);
            }
        }
        return ans;
    }

    private int sqr(int i) {
        return i * i;
    }
}
