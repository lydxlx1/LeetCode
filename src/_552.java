/**
 * LeetCode 552 - Student Attendance Record II
 * <p>
 * Counting problem
 * Define:
 * f[i][0]: # of valid sequences of length i where no A is allowed
 * f[i][1]: # of valid sequences of length i where at most one A is allowed
 * <p>
 * The recurrence is embedded in the code, which should be self-explanatory.
 */
public class _552 {

    int[][] f;

    public int checkRecord(int n) {
        final int MOD = 1000000007;
        int[][] f = new int[n + 1][2];

        f[0][0] = f[0][1] = 1;
        for (int i = 1; i <= n; i++) {
            // Last bit is not L
            f[i][0] = f[i - 1][0]; // ...P
            f[i][1] = (f[i - 1][0] + f[i - 1][1]) % MOD; // ...P or ...A

            for (int numL = 1; numL <= 2; numL++) {
                if (i < numL) continue;
                else if (i == numL) {
                    // L or LL
                    f[i][0] = (f[i][0] + 1) % MOD;
                    f[i][1] = (f[i][1] + 1) % MOD;
                } else {
                    // PL or PLL
                    f[i][0] = (f[i][0] + f[i - numL - 1][0]) % MOD;

                    // PL or PLL
                    f[i][1] = (f[i][1] + f[i - numL - 1][1]) % MOD;
                    // AL or ALL
                    f[i][1] = (f[i][1] + f[i - numL - 1][0]) % MOD;
                }
            }
        }

        return f[n][1];
    }


    public static void main(String[] args) {
        System.out.println(new _552().checkRecord(100));
    }
}