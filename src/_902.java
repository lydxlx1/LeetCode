/**
 * LeetCode 902 - Numbers At Most N Given Digit Set
 *
 * Math
 */
public class _902 {

    public int atMostNGivenDigitSet(String[] D, int N) {
        int cnt = 0;
        String strN = "" + N;

        // Length < |N|
        for (int len = 1; len < strN.length(); len++) {
            cnt += pow(D.length, len);
        }
        // Length == |N|
        cnt += dfs(0, strN, D);

        return cnt;
    }

    int dfs(int t, String strN, String[] D) {
        if (t >= strN.length()) {
            return 1;
        }

        int cnt = 0;
        for (String d : D) {
            if (d.charAt(0) < strN.charAt(t)) {
                cnt += pow(D.length, strN.length() - t - 1);
            } else if (d.charAt(0) == strN.charAt(t)) {
                cnt += dfs(t + 1, strN, D);
            } else {
                break;
            }
        }
        return cnt;
    }

    private int pow(int a, int n) {
        int pow = 1;
        while (n > 0) {
            if (n % 2 == 1) {
                pow *= a;
            }
            a *= a;
            n /= 2;
        }
        return pow;
    }
}

