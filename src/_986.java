import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode 986 - Interval List Intersections
 *
 * Linear Solution
 */
public class _986 {

    public Interval[] intervalIntersection(Interval[] a, Interval[] b) {
        List<Interval> res = new ArrayList<>();
        int i = 0, j = 0;
        while (i < a.length && j < b.length) {
            int start = Math.max(a[i].start, b[j].start);
            int end = Math.min(a[i].end, b[j].end);
            if (start <= end) {
                res.add(new Interval(start, end));
            }

            if (a[i].end <= end) {
                i++;
            }
            if (b[j].end <= end) {
                j++;
            }
        }
        return res.stream().toArray(Interval[]::new);
    }
}

