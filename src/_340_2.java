/**
 * LeetCode 340 - Longest Substring with At Most K Distinct Characters
 *
 * O(n) sliding window
 */
public class _340_2 {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int max = 0, distinct = 0;
        int[] cnt = new int[128];
        for (int l = 0, r = 0; r < s.length(); r++) {
            if (cnt[s.charAt(r)]++ == 0) distinct++;
            while (distinct > k)
                if (--cnt[s.charAt(l++)] == 0) distinct--;
            max = Math.max(max, r - l + 1);
        }
        return max;
    }
}
