/**
 * LeetCode 541 - Reverse String II
 * <p>
 * Brute-force
 */
public class _541 {
    public String reverseStr(String s, int k) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < s.length(); i += 2 * k) {
            builder.append(new StringBuilder(s.substring(i, Math.min(i + k, s.length()))).reverse().toString());
            if (i + k < s.length()) {
                builder.append(new StringBuilder(s.substring(i + k, Math.min(s.length(), i + 2 * k))));
            }
        }
        return builder.toString();
    }
}
