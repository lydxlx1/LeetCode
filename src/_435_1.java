import java.util.Arrays;

/**
 * LeetCode 435 - Non-overlapping Intervals
 * <p>
 * Alternative, we can compute the MAXIMUM set of intervals that are completely non-overlapping and subtract it from
 * the total number of intervals.
 * <p>
 * This is a traditional problem called "Activity Selection". See the Introduction to Algorithm.
 */
public class _435_1 {
    public int eraseOverlapIntervals(Interval[] intervals) {
        if (intervals == null || intervals.length <= 0) return 0;
        int survivalCnt = 0;
        Arrays.sort(intervals, (u, v) -> Integer.compare(u.end, v.end));
        int end = Integer.MIN_VALUE;
        for (Interval interval : intervals)
            if (interval.start >= end) {
                survivalCnt++;
                end = interval.end;
            }
        return intervals.length - survivalCnt;
    }
}