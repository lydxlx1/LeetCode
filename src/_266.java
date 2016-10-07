/**
 * LeetCode 266 - Palindrome Permutation
 * <p>
 * Counting
 */
public class _266 {
    public boolean canPermutePalindrome(String s) {
        int[] cnt = new int[128];
        for (char ch : s.toCharArray()) cnt[ch]++;
        int odd = 0;
        for (int i : cnt) if (i % 2 == 1) odd++;
        return odd <= 1;
    }
}