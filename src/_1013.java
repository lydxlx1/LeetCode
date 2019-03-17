/**
 * LeetCode 1013 - Pairs of Songs With Total Durations Divisible by 60
 *
 * Counting
 */
public class _1013 {

    public int numPairsDivisibleBy60(int[] time) {
        int ans = 0;
        int[] cnt = new int[60];
        for (int i : time) {
            ans += cnt[(60 - (i % 60)) % 60];
            cnt[i % 60]++;
        }
        return ans;
    }
}

