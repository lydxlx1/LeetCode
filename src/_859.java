/**
 * LeetCode 859 - Buddy Strings
 * <p>
 * Some pitfalls:
 * - len(A) != len(B)
 * - len(.) < 2
 * - A == B, but all letters in A are distinct
 */
public class _859 {

    public boolean buddyStrings(String A, String B) {
        if (A.length() != B.length()) return false;
        if (A.length() < 2) return false;
        if (A.equals(B)) {
            return A.chars().distinct().count() < A.length();
        }

        for (int i = 0; i < A.length(); i++) {
            if (A.charAt(i) != B.charAt(i)) {
                for (int j = i + 1; j < A.length(); j++) {
                    if (A.charAt(j) != B.charAt(j)) {
                        StringBuilder builder = new StringBuilder();
                        char[] a = A.toCharArray();
                        char tmp = a[i];
                        a[i] = a[j];
                        a[j] = tmp;
                        return String.valueOf(a).equals(B);
                    }
                }
            }
        }
        return false;
    }
}

