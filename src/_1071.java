/**
 * LeetCode 1071 - Greatest Common Divisor of Strings
 *
 * O(n^1.5)- time solution as there can be at most O(n^0.5) factors.
 */
public class _1071 {

    public String gcdOfStrings(String str1, String str2) {
        for (int i = Math.min(str1.length(), str2.length()); i >= 1; i--) {
            if (ok(str1, str2, i)) {
                return str1.substring(0, i);
            }
        }
        return "";
    }

    boolean ok(String a, String b, int len) {
        if (a.length() % len != 0
                || b.length() % len != 0
                || !a.substring(0, len).equals(b.substring(0, len))) {
            return false;
        }
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != a.charAt(i % len)) {
                return false;
            }
        }
        for (int i = 0; i < b.length(); i++) {
            if (b.charAt(i) != b.charAt(i % len)) {
                return false;
            }
        }
        return true;
    }
}
