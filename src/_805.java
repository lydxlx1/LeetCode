/**
 * LeetCode 805 - Split Array With Same Average
 * <p>
 * Pruning + DP
 */
public class _805 {

    public boolean splitArraySameAverage(int[] A) {
        if (A.length <= 1) {
            return false;
        }

        int sum = 0;
        for (int i : A) {
            sum += i;
        }

        for (int i = 1; i < A.length; i++) {
            int firstN = i;
            int secondN = A.length - i;
            if (firstN > secondN) {
                break;
            }

            int gcd = 1;
            for (gcd = i; gcd > 1; gcd--) {
                if (firstN % gcd == 0 && secondN % gcd == 0) {
                    break;
                }
            }

            // Make sure firstN : secondN does not contain any common factor that is greater than one.
            int cb = firstN / gcd;
            int wb = secondN / gcd;
            if (sum % (cb + wb) != 0) {
                continue;
            }


            int firstSum = sum / (cb + wb) * cb;
            int secondSum = sum / (cb + wb) * wb;

            // Heuristically choose the part with less space/time complexity.
            if (firstSum * firstN < secondSum * secondN) {
                if (check(A, firstN, firstSum)) {
                    return true;
                }
            } else {
                if (check(A, secondN, secondSum)) {
                    return true;
                }
            }
        }

        return false;
    }

    boolean check(int[] A, int n, int sum) {
        boolean[][] f = new boolean[n + 1][sum + 1];
        boolean[][] g = new boolean[n + 1][sum + 1];

        f[0][0] = true;
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j <= n; j++) {
                for (int k = 0; k <= sum; k++) {
                    g[j][k] = f[j][k];
                    if (j - 1 >= 0 && k >= A[i]) {
                        g[j][k] = g[j][k] || f[j - 1][k - A[i]];
                    }
                }
            }

            boolean[][] tmp = f;
            f = g;
            g = tmp;
        }
        return f[n][sum];
    }
}
