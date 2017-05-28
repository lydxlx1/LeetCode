/**
 * LeetCode 600 - Non-negative Integers without Consecutive Ones
 *
 * Counting problem
 */
public class _600 {
    public int findIntegers(int num) {
        // The answer for num = 2^k - 1 is just a Fibonacci number.
        int[] fib = new int[32];
        fib[0] = 1;
        fib[1] = 2;
        for (int i = 2; i < fib.length; i++)
            fib[i] = fib[i - 1] + fib[i - 2];

        int ans = 0;
        for (int i = 31; i >= 0; i--)
            if ((num & (1 << i)) != 0) {
                ans += fib[i]; // if the i-th bit is 0
                if (i - 1 >= 0 && (num & (1 << (i - 1))) != 0) {
                    return ans + fib[i - 1];
                }
            }
        return ans + 1; // also need to include num itself
    }
}
