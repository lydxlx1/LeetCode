/**
 * LeetCode 340 - Longest Substring with At Most K Distinct Characters
 * <p>
 * O(n log n) bisect method
 */
public class _340_1 {
    boolean isok(char[] s, int k, int len) {
        if (len == 0) return true;
        int[] cnt = new int[128];
        int distinct = 0;
        for (int r = 0, l = 0; r < s.length; r++) {
            if (cnt[s[r]]++ == 0) distinct++;
            if (r - l + 1 > len) // window too wide
                if (--cnt[s[l++]] == 0) distinct--;
            if (r >= len - 1 && distinct <= k) return true;
        }
        return false;
    }

    public int lengthOfLongestSubstringKDistinct(String ss, int k) {
        int ans = 0;
        char[] s = ss.toCharArray();
        int l = 0, r = s.length + 1;
        while (l + 1 < r) {
            int mid = (l + r) / 2;
            if (isok(s, k, mid)) l = mid;
            else r = mid;
        }
        return l;
    }
}
