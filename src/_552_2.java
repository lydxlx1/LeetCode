/**
 * LeetCode 552 - Student Attendance Record II
 * <p>
 * O(log n)-time solution
 */
public class _552_2 {

    final int MOD = 1000000007;

    void mul(int[][] A, int[][] B, int[][] C) {
        for (int i = 0; i < 6; i++)
            for (int j = 0; j < 6; j++)
                C[i][j] = 0;
        for (int i = 0; i < 6; i++)
            for (int j = 0; j < 6; j++)
                for (int k = 0; k < 6; k++)
                    C[i][j] = (int) ((C[i][j] + (long) A[i][k] * B[k][j]) % MOD);
    }


    int[][] pow(int[][] A, int n) {
        int[][] res = new int[6][6];
        int[][] tmp = new int[6][6];
        int[][] swap;
        for (int i = 0; i < 6; i++)
            res[i][i] = 1;
        while (n > 0) {
            if (n % 2 == 1) {
                mul(res, A, tmp);
                swap = res;
                res = tmp;
                tmp = swap;
            }

            mul(A, A, tmp);
            swap = A;
            A = tmp;
            tmp = swap;

            n /= 2;
        }
        return res;
    }

    public int checkRecord(int n) {
        int[][] A = {
                {0, 0, 1, 0, 0, 0},
                {1, 0, 1, 0, 0, 0},
                {0, 1, 1, 0, 0, 0},
                {0, 0, 1, 0, 0, 1},
                {0, 0, 1, 1, 0, 1},
                {0, 0, 1, 0, 1, 1},
        };
        A = pow(A, n);
        int ans = 0;
        for (int i = 0; i < 6; i++)
            ans = (ans + A[5][i]) % MOD;
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new _552_2().checkRecord(1000000000));
    }
}
