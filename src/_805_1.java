/**
 * LeetCode 805 - Split Array With Same Average
 * <p>
 * Pruning + DP
 */
public class _805_1 {

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
                if (check(A, 0, firstN, firstSum)) {
                    return true;
                }
            } else {
                if (check(A, 0,secondN, secondSum)) {
                    return true;
                }
            }
        }

        return false;
    }

    boolean check(int[] A, int t, int nRemaining, int sumRemaining) {
        if (nRemaining == 0 && sumRemaining == 0) {
            return true;
        }
        if (t >= A.length || nRemaining <= 0 || sumRemaining <= 0) {
            return false;
        }
        return check(A, t + 1, nRemaining - 1, sumRemaining - A[t]) || check(A, t + 1, nRemaining, sumRemaining);
    }
}
