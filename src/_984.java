/**
 * LeetCode 984 - String without AAA or BBB
 * <p>
 * Greedy
 */
public class _984 {

    public String strWithout3a3b(int A, int B) {
        char[] ans = new char[A + B];
        int m = 0;
        while (A + B > 0) {
            char t = A > B ? 'a' : 'b';
            if (m >= 2 && ans[m - 1] == t && ans[m - 2] == t) {
                t = t == 'a' ? 'b' : 'a';
            }
            ans[m++] = t;

            if (t == 'a') {
                A--;
            } else {
                B--;
            }
        }
        return String.valueOf(ans);
    }
}

