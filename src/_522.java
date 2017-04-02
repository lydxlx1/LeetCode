/**
 * LeetCode 522 - Longest Uncommon Subsequence II
 * <p>
 * Observe that the answer must be the whole length of some given string, or -1.
 * If the optimal string is a subsequence of some string, the its entire string must also be a feasible solution,
 * which is longer. --- A contradiction.
 */
public class _522 {
    private boolean isSubsequence(String origin, String pattern) {
        int i = 0, j = 0;
        while (i < origin.length() && j < pattern.length())
            if (origin.charAt(i) == pattern.charAt(j)) {
                i++;
                j++;
            } else {
                i++;
            }
        return j >= pattern.length();
    }

    public int findLUSlength(String[] strs) {
        int ans = -1;
        for (int i = 0; i < strs.length; i++) {
            boolean isok = true;
            for (int j = 0; j < strs.length; j++)
                if (i != j && isSubsequence(strs[j], strs[i])) {
                    isok = false;
                    break;
                }
            if (isok) ans = Math.max(ans, strs[i].length());
        }
        return ans;
    }
}
