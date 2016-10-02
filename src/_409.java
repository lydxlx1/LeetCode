/**
 * LeetCode 409 - Longest Palindrome
 *
 * Counting
 */
public class _409 {
    public int longestPalindrome(String s) {
        int[] cnt = new int[128];
        for (char ch : s.toCharArray()) cnt[ch]++;
        int ans = 0, odd = 0;
        for (int i : cnt) {
            if (i % 2 == 1) odd++;
            ans += i / 2 * 2;
        }
        return ans + Math.min(odd, 1);
    }
}