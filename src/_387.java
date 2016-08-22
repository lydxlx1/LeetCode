/**
 * LeetCode 387 - First Unique Character in a String
 *
 * Brute-force
 */
public class _387 {
    public int firstUniqChar(String s) {
        int[] cnt = new int[128];
        for (char ch : s.toCharArray()) cnt[ch]++;
        for (int i = 0; i < s.length(); i++)
            if (cnt[s.charAt(i)] == 1) return i;
        return -1;
    }
}
