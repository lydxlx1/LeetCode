import java.util.Arrays;

/**
 * LeetCode 983 - Minimum Cost for Tickets
 *
 * DP
 */
public class _983 {

    public int mincostTickets(int[] days, int[] costs) {
        if (days == null || days.length == 0) return 0;
        int[] duration = {1, 7, 30};

        Arrays.sort(days);
        int[] f = new int[days.length];
        for (int i = 0; i < days.length; i++) {
            f[i] = Integer.MAX_VALUE;

            for (int j = 0; j < 3; j++) {
                int tmp = costs[j];
                // This can also be done via a binary search.
                for (int k = i - 1; k >= 0; k--) {
                    if (days[i] - days[k] >= duration[j]) {
                        tmp += f[k];
                        break;
                    }
                }
                f[i] = Math.min(f[i], tmp);
            }
        }
        return f[days.length - 1];
    }
}

