/**
 * LeetCode 796 - Rotate String
 */
public class _796 {

    public boolean rotateString(String A, String B) {
        return A.length() == B.length() && (A + A).contains(B);
    }
}
