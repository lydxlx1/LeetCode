/**
 * LeetCode 396 - Rotate Function
 *
 * Just pay attention to the difference between two consecutive windows
 */
public class _396 {
    public int maxRotateFunction(int[] A) {
        long ans = Long.MIN_VALUE, sum = 0, current = 0;
        for (int i = 0; i < A.length; i++) {
            sum += A[i];
            current += i * A[i];
        }
        for (int i = 0; i < A.length; i++) {
            current = current - sum + A.length * A[i];
            ans = Math.max(ans, current);
        }
        return (int) ans;
    }
}