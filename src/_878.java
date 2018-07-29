/**
 * LeetCode 878 - Nth Magical Number
 * <p>
 * Binary Search + Math
 */
public class _878 {

    int gcd(int i, int j) {
        return i == 0 ? j : gcd(j % i, i);
    }

    public int nthMagicalNumber(int N, int A, int B) {
        long lcm = 1L * A * B / gcd(A, B);
        long left = 0, right = 1L * N * A * B;
        while (left + 1 < right) {
            long mid = left + (right - left) / 2;
            long cnt = mid / A + mid / B - mid / lcm;
            if (cnt >= N) {
                right = mid;
            } else {
                left = mid;
            }
        }
        return (int) (right % 1000000007);
    }
}

