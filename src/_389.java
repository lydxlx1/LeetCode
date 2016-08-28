/**
 * LeetCode 389 - Find the Difference
 *
 * Easy problem
 */
public class _389 {
    public char findTheDifference(String s, String t) {
        int[] cnt = new int[128];
        for (char ch : t.toCharArray()) cnt[ch]++;
        for (char ch : s.toCharArray()) cnt[ch]--;
        for (char ch = 0; ch < 128; ch++) if (cnt[ch] > 0) return ch;
        return 0;
    }
}