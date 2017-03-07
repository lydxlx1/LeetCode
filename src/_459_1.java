/**
 * LeetCode 459 - Repeated Substring Pattern
 * <p>
 * 1-Liner
 * <p>
 * But still has an O(n^2) worst-case runtime.
 */
public class _459_1 {
    public boolean repeatedSubstringPattern(String s) {
        return s.length() > 0 && (s.substring(1) + s.substring(0, s.length() - 1)).contains(s);
    }
}