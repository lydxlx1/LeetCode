/**
 * LeetCode 552 - Student Attendance Record II
 * <p>
 * A more elegant method
 * <p>
 * Let f[i][j][k] denote the # of valid sequences of length i where:
 * 1) there can be at most j A's in the entire sequence.
 * 2) there can be at most k trailing L's.
 * <p>
 * The final answer is f[n][1][2].
 */
public class _552_1 {

    public int checkRecord(int n) {
        final int MOD = 1000000007;
        int[][][] f = new int[n + 1][2][3];

        f[0] = new int[][]{{1, 1, 1}, {1, 1, 1}};
        for (int i = 1; i <= n; i++)
            for (int j = 0; j < 2; j++)
                for (int k = 0; k < 3; k++) {
                    int val = f[i - 1][j][2]; // ...P
                    if (j > 0) val = (val + f[i - 1][j - 1][2]) % MOD; // ...A
                    if (k > 0) val = (val + f[i - 1][j][k - 1]) % MOD; // ...L
                    f[i][j][k] = val;
                }

        return f[n][1][2];
    }


    public static void main(String[] args) {
        System.out.println(new _552_1().checkRecord(100));
    }
}