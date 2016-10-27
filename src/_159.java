/**
 * LeetCode 159 - Longest Substring with At Most Two Distinct Characters
 * <p>
 * Sliding-window
 */
public class _159 {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        int ans = 0, distinct = 0;
        int[] cnt = new int[128];
        for (int r = 0, l = 0; r < s.length(); r++) {
            if (cnt[s.charAt(r)]++ == 0) distinct++;
            while (l < r && distinct > 2)
                if (--cnt[s.charAt(l++)] == 0) distinct--;
            ans = Math.max(ans, r - l + 1);
        }
        return ans;
    }
}