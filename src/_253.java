import java.util.Arrays;

/**
 * LeetCode 253 - Meeting Rooms II
 * <p>
 * O(n log n) Sweep-line Algorithm
 */
public class _253 {
    public int minMeetingRooms(Interval[] intervals) {
        int n = intervals.length;
        int[][] a = new int[2 * n][];
        for (int i = 0; i < n; i++) {
            a[i] = new int[]{intervals[i].start, 0};
            a[i + n] = new int[]{intervals[i].end, 1};
        }
        // right endpoint comes first before left endpoint when they share the same coordinate
        Arrays.sort(a, (u, v) -> u[0] != v[0] ? Integer.compare(u[0], v[0]) : -Integer.compare(u[1], v[1]));
        int ans = 0, cnt = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i][1] == 0) cnt++;
            else cnt--;
            ans = Math.max(ans, cnt);
        }
        return ans;
    }
}
