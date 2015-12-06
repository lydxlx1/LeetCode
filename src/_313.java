import java.util.Arrays;

/**
 * LeetCode 313 - Super Ugly Number
 *
 * Constructive Algorithm
 *
 * Maintain a pointer for each factor, and generate all the ugly numbers in sorted order.
 * Generating an ugly number takes O(k) time, and therefore the total time is O(nk).
 */
public class _313 {
    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] a = new int[n];
        a[0] = 1;
        int[] ptr = new int[primes.length];
        Arrays.fill(ptr, 0);

        for (int i = 1; i < n; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < primes.length; j++)
                if ((long) a[ptr[j]] * primes[j] < min) min = a[ptr[j]] * primes[j];
            a[i] = min;
            for (int j = 0; j < primes.length; j++)
                if ((long) a[ptr[j]] * primes[j] == min) ptr[j]++;
        }

        return a[n - 1];
    }
}