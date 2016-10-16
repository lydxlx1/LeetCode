/**
 * LeetCode 424 - Longest Repeating Character Replacement
 * <p>
 * Binary Search
 * <p>
 * If x is the answer, then any substring satisfying the requirement with length <= x can also be constructed.
 * Therefore, we can binary search the answer.
 * <p>
 * Now, we just need to answer the following decision problem:
 * Is there a window of length x such that we can make it contain all unique letters with no more than k replacements?
 * <p>
 * For a particular window size x, we enumerate all possible windows.
 * Count the mode of the letters in the window. If x - mode <= k, then the window is valid.
 * <p>
 * Finding the mode in this problem can be done in O(26) time via brute-force since the string only contains uppercase letters.
 * We can use RMQ data structure to do better for the general case, though.
 * <p>
 * The total runtime is O(26 * n log n) = O(n log n).
 */
public class _424 {

    private boolean ok(char[] ch, int k, int len) {
        int[] cnt = new int[26];
        for (int i = 0; i < ch.length; i++) {
            if (i >= len) cnt[ch[i - len] - 'A']--;
            cnt[ch[i] - 'A']++;
            if (i >= len - 1) {
                int max = 0;
                for (int j : cnt) max = Math.max(max, j);
                if (len - max <= k) return true;
            }
        }
        return false;
    }

    public int characterReplacement(String s, int k) {
        if (s.length() == 0 || k >= s.length() - 1) return s.length();
        int left = 1, right = s.length() + 1;
        char[] ch = s.toCharArray();
        while (left + 1 < right) {
            int mid = (left + right) / 2;
            if (ok(ch, k, mid)) left = mid;
            else right = mid;
        }
        return left;
    }
}
