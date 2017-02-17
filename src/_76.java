/**
 * LeetCode 76 - Minimum Window Substring
 * <p>
 * Sliding-window technique
 */
public class _76 {
    public String minWindow(String s, String t) {
        int l = -1, r = -1, total = 0;
        int[] actual = new int[128], expected = actual.clone();

        for (int i = 0; i < t.length(); i++) expected[t.charAt(i)]++;
        for (int i = 0, j = 0; j < s.length(); j++) {
            if (++actual[s.charAt(j)] <= expected[s.charAt(j)]) total++;
            while (i < j && actual[s.charAt(i)] > expected[s.charAt(i)]) --actual[s.charAt(i++)];
            if (total == t.length() && (l == -1 || j - i < r - l)) {
                l = i;
                r = j;
            }
        }
        return l == -1 ? "" : s.substring(l, r + 1);
    }
}
