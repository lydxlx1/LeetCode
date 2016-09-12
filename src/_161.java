/**
 * LeetCode 161 - One Edit Distance
 *
 * Short Java code
 */
public class _161 {
    public boolean isOneEditDistance(String s, String t) {
        if (s.length() > t.length()) return isOneEditDistance(t, s);
        for (int i = 0; i < s.length(); i++)
            if (s.charAt(i) != t.charAt(i))
                return i + 1 <= t.length() && s.substring(s.length() < t.length() ? i : i + 1).equals(t.substring(i + 1));
        return t.length() - s.length() == 1;
    }
}