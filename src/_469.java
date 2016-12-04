import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode 469 - Convex Polygon
 */
public class _469 {

    private int cross(List<Integer> a, List<Integer> b, List<Integer> c) {
        long x1 = b.get(0) - a.get(0), y1 = b.get(1) - a.get(1);
        long x2 = c.get(0) - b.get(0), y2 = c.get(1) - b.get(1);
        return Long.signum(x1 * y2 - x2 * y1);
    }

    public boolean isConvex(List<List<Integer>> points) {
        points.addAll(new ArrayList<>(points));
        int sign = 0;
        for (int i = 0; i + 3 <= points.size(); i++) {
            List<Integer> a = points.get(i);
            List<Integer> b = points.get(i + 1);
            List<Integer> c = points.get(i + 2);
            int cross = cross(a, b, c);
            if (cross != 0) {
                if (sign != 0 && cross != sign) return false;
                sign = cross;
            }

        }
        return true;
    }
}