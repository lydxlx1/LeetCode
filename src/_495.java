/**
 * LeetCode 495 - Teemo Attaching
 * <p>
 * Sweepline algorithm
 */
public class _495 {
    public int findPosisonedDuration(int[] timeSeries, int duration) {
        if (timeSeries.length == 0 || duration == 0) return 0;
        int ans = duration, end = timeSeries[0] + duration - 1;
        for (int i = 1; i < timeSeries.length; i++) {
            int left = timeSeries[i], right = left + duration - 1;
            ans += Math.min(right - end, duration);
            end = right;
        }
        return ans;
    }
}

