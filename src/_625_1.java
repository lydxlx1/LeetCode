import java.util.Arrays;

/**
 * LeetCode 625 - Minimum Factorization
 * <p>
 * A DP method to handle factors of two's and three's.
 */
public class _625_1 {
    public int smallestFactorization(int a) {
        if (a == 1)
            return 1;
        int[] cnt = new int[10];
        for (int i = 2; i < 10; i++)
            while (a % i == 0) {
                cnt[i]++;
                a /= i;
            }
        if (a > 1)
            return 0;

        long[][] dp = new long[cnt[2] + 1][cnt[3] + 1];
        for (int i = 0; i <= cnt[2]; i++)
            for (int j = 0; j <= cnt[3]; j++) {
                if (i == 0 && j == 0) continue;
                long res = Long.MAX_VALUE;
                if (i >= 1) res = Math.min(res, dp[i - 1][j] * 10 + 2);
                if (i >= 2) res = Math.min(res, dp[i - 2][j] * 10 + 4);
                if (i >= 3) res = Math.min(res, dp[i - 3][j] * 10 + 8);
                if (j >= 1) res = Math.min(res, dp[i][j - 1] * 10 + 3);
                if (j >= 2) res = Math.min(res, dp[i][j - 2] * 10 + 9);
                if (i >= 1 && j >= 1) res = Math.min(res, dp[i - 1][j - 1] * 10 + 6);
                dp[i][j] = res;
            }

        String res;
        if (dp[cnt[2]][cnt[3]] == 0)
            res = "";
        else
            res = "" + dp[cnt[2]][cnt[3]];
        for (int i = 0; i < cnt[5]; i++)
            res += '5';
        for (int i = 0; i < cnt[7]; i++)
            res += '7';
        char[] chars = res.toCharArray();
        Arrays.sort(chars);

        try {
            return Integer.parseInt(String.valueOf(chars));
        } catch (Exception e) {
            return 0;
        }
    }

    public static void main(String[] args) {
        System.out.println(new _625_1().smallestFactorization(48));
    }
}