import java.util.HashSet;
import java.util.Set;

/**
 * LeetCode 939 - Minimum Area Rectangle
 *
 * Just need to enumerate the two opposite corners
 * Time = O(n^2)
 * Space = O(n)
 */
public class _939 {

    public int minAreaRect(int[][] points) {
        Set<String> hash = new HashSet<>();
        for (int[] point : points) {
            hash.add(point[0] + "," + point[1]);
        }

        int area = Integer.MAX_VALUE;
        for (int[] p : points) {
            for (int[] q : points) {
                int x1 = p[0], y1 = p[1];
                int x2 = q[0], y2 = q[1];

                if (x1 < x2 && y1 < y2 && hash.contains(x1 + "," + y2) && hash.contains(x2 + "," + y1)) {
                    area = Math.min(area, (x2 - x1) * (y2 - y1));
                }
            }
        }

        return area == Integer.MAX_VALUE ? 0 : area;
    }
}

