/**
 * LeetCode 849 - Maximize Distance to Closest Person
 * <p>
 * Linear Scan
 */
public class _849 {

    public int maxDistToClosest(int[] seats) {
        int ans = 0;
        int pos = -1;
        for (int i = 0; i < seats.length; i++) {
            if (seats[i] == 1) {
                if (pos == -1) {
                    ans = Math.max(ans, i);
                } else {
                    ans = Math.max(ans, (i - pos) / 2);
                }
                pos = i;
            }
        }
        if (seats[seats.length - 1] == 0) {
            ans = Math.max(ans, seats.length - 1 - pos);
        }
        return ans;
    }
}

