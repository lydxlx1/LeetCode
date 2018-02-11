/**
 * LeetCode 781 - Rabbits in Forest
 * <p>
 * Math
 */
public class _781 {

    public int numRabbits(int[] answers) {
        if (answers == null || answers.length == 0) {
            return 0;
        }

        int[] cnt = new int[1000];
        for (int i : answers) {
            cnt[i]++;
        }

        int ans = 0;
        for (int i = 0; i < 1000; i++) {
            ans += (cnt[i] + i) / (i + 1) * (i + 1);
        }
        return ans;
    }
}
