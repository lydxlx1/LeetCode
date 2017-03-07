/**
 * LeetCode 459 - Repeated Substring Pattern
 * <p>
 * 1-Liner via Regex
 */
public class _459_2 {
    public boolean repeatedSubstringPattern(String s) {
        return s.matches("(.+)\\1+");
    }
}