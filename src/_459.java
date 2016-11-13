/**
 * LeetCode 459 - Repeated Substring Pattern
 * <p>
 * O(n^1.5) solution since n can have at most O(sqrt(n)) factors.
 * In fact, this problem can be solved in O(n) time using KMP.
 */
public class _459 {
    public boolean repeatedSubstringPattern(String str) {
        for (int len = 1; len < str.length(); len++) {
            if (str.length() % len == 0) {
                boolean ok = true;
                for (int i = 0, j = 0; i < str.length(); i++, j = (j + 1) % len)
                    if (str.charAt(i) != str.charAt(j)) {
                        ok = false;
                        break;
                    }
                if (ok) return true;
            }
        }
        return false;
    }
}
