/**
 * LeetCode 424 - Longest Repeating Character Replacement
 * <p>
 * I can even optimize the binary search approach to O(n) runtime via a global sliding window.
 * This relies on the following important observation:
 * <p>
 * Consider the longest window **terminating** at y. Assume the window is [x, y].
 * Then the left boundary for the longest window **terminating** at y + 1 must be no less than x.
 */
public class _424_1 {
    public int characterReplacement(String s, int k) {
        if (s.length() == 0 || k >= s.length() - 1) return s.length();
        int[] cnt = new int[128];
        int ans = 0;
        for (int begin = 0, end = 0; end < s.length(); end++) {
            cnt[s.charAt(end)]++;
            while (end - begin + 1 - max(cnt) > k) cnt[s.charAt(begin++)]--;
            ans = Math.max(ans, end - begin + 1);
        }
        return ans;
    }

    private int max(int[] cnt) {
        int max = 0;
        for (int i : cnt) max = Math.max(max, i);
        return max;
    }
}
