import java.util.Arrays;

/**
 * LeetCode 435 - Non-overlapping Intervals
 * <p>
 * O(n log n) greedy
 * <p>
 * Sort all the intervals by increasing start points.
 * Under such ordering, we just need to worry about the end point of each interval.
 * <p>
 * If two intervals are non-overlapping, we simply move on.
 * Otherwise, we must eliminate one interval. Obviously, it is always better to keep the one with the smaller end point
 * and eliminate the other.
 */
public class _435 {
    public int eraseOverlapIntervals(Interval[] intervals) {
        if (intervals == null || intervals.length <= 0) return 0;
        int cnt = 0;
        Arrays.sort(intervals, (u, v) -> Integer.compare(u.start, v.start));
        Interval current = intervals[0];
        for (int i = 1; i < intervals.length; i++)
            if (current.end <= intervals[i].start) current = intervals[i];
            else {
                cnt++;
                if (intervals[i].end < current.end) current = intervals[i];
            }
        return cnt;
    }
}