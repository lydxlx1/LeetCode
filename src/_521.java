/**
 * LeetCode 521 - Longest Uncommon Subsequence I
 * <p>
 * A really interesting problem that best fits April 1.
 */
public class _521 {
    public int findLUSlength(String a, String b) {
        return a.equals(b) ? -1 : Math.max(a.length(), b.length());
    }
}
