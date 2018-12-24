import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode 963 - Minimum Area Recrangle II
 *
 * Geometry
 *
 * i.  All Arithmetic (except the last one to compute the area) are done in integers so it is 100% precise.
 * ii. Initially I was lazy and tried to form the hash key simply by (a[0] + "," + a[1]), and my submission got TLE.
 *     50 * 50 * 50 = 125K strings seem totally okay to me, so maybe there are just too many test cases.
 */
public class _963 {

    double inf = 1E300;
    long base = 44444;
    Map<Long, int[]> map = new HashMap<>();

    public double minAreaFreeRect(int[][] points) {
        double ans = inf;
        map = new HashMap<>();

        for (int[] p : points) {
            map.put(key(p), p);
        }

        for (int i = 0; i < points.length; i++) {
            for (int j = 0; j < points.length; j++) {
                for (int k = 0; k < points.length; k++) {
                    if (i == j || i == k || j == k) {
                        continue;
                    }
                    int[] a = points[i];
                    int[] b = points[j];
                    int[] c = points[k];
                    int[] d = {a[0] + b[0] - c[0], a[1] + b[1] - c[1]};
                    // Diagonal ab and cd share the same midpoint and have the same length <==> rectangle!
                    if (map.containsKey(key(d)) && dist2(a, b) == dist2(c, d)) {
                        double e1 = Math.sqrt(dist2(a, c));
                        double e2 = Math.sqrt(dist2(a, d));
                        ans = Math.min(ans, e1 * e2);
                    }
                }
            }
        }
        return ans < inf / 10 ? ans : 0;
    }

    long key(int[] a) {
        return a[0] * base + a[1];
    }

    long dist2(int[] a, int[] b) {
        long x = a[0] - b[0];
        long y = a[1] - b[1];
        return x * x + y * y;
    }
}

