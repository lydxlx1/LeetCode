/**
 * LeetCode 44 - Wildcard Matching
 *
 * Greedy solution
 */
public class _44_1 {
    private int next(String s, int i, String p) {
        for (; i + p.length() <= s.length(); i++) {
            int j = 0;
            for (; j < p.length(); j++)
                if (p.charAt(j) != '?' && s.charAt(i + j) != p.charAt(j)) break;
            if (j == p.length()) return i + j;
        }
        return -1;
    }

    public boolean isMatch(String s, String p) {
        // '!' is some character that does not appear in either s or p.
        s = "!" + s + "!"; // This forces that p won't have '*' on either side.
        p = "!" + p + "!"; // It also forces the two ends of new_p must exactly match the two ends of new_s.
        int i = 0;
        for (String token : p.split("\\*+"))
            if ((i = next(s, i, token)) == -1) return false;
        return true;
    }
}