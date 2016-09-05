/**
 * LeetCode 392 - Is Subsequence
 *
 * Simple solution
 */
public class _392 {
    public boolean isSubsequence(String s, String t) {
        int i = 0, j = 0;
        while (i < s.length() && j < t.length())
            if (s.charAt(i) == t.charAt(j)) {
                i++;
                j++;
            } else j++;
        return i == s.length();
    }
}
