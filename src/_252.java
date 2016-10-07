import java.util.Arrays;

/**
 * LeetCode 252 - Meeting Rooms
 * <p>
 * Sweepline method
 */
public class _252 {
    public boolean canAttendMeetings(Interval[] intervals) {
        Arrays.sort(intervals, (u, v) -> Integer.compare(u.start, v.start));
        int rightBoundary = Integer.MIN_VALUE;
        for (Interval interval : intervals) {
            if (rightBoundary > interval.start) return false;
            rightBoundary = Math.max(rightBoundary, interval.end);
        }
        return true;
    }
}