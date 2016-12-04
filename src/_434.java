/**
 * LeetCode 434 - Number of Segments in a String
 * <p>
 * See the following from Java Doc.
 * If the expression does not match any part of the input then the resulting array has just one element, namely this string.
 */
public class _434 {
    public int countSegments(String s) {
        s = s.trim();
        if (s.length() <= 0) return 0;
        else return s.split("[ ]+").length;
    }
}