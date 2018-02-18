import java.util.Arrays;
import java.util.Random;

/**
 * LeetCode 786 - K-th Smallest Prime Fraction
 * <p>
 * Partition method
 * O(n^2)-time/space
 * <p>
 * This gets TLE for java, but I do see C++ solution using the same method got accepted, though.
 */
public class _786 {

    public int[] kthSmallestPrimeFraction(int[] A, int K) {
        final int N = A.length;
        int[][] fractions = new int[N * (N - 1) / 2][2];
        for (int i = 0, ptr = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                fractions[ptr][0] = A[i];
                fractions[ptr][1] = A[j];
                ptr++;
            }
        }

        int l = 0, r = fractions.length - 1;
        Random rand = new Random(3);
        while (true) {
            int i = l, j = r;
            int[] x = fractions[rand.nextInt(r - l + 1) + l];

            do {
                while (cmp(fractions[i], x) < 0) {
                    i++;
                }
                while (cmp(fractions[j], x) > 0) {
                    j--;
                }
                if (i <= j) {
                    int[] tmp = fractions[i];
                    fractions[i] = fractions[j];
                    fractions[j] = tmp;
                    i++;
                    j--;
                }
            }
            while (i <= j);

            if (K <= j - l + 1) {
                r = j;
            } else {
                K -= j - l + 1;

                if (K <= (i - 1) - (j + 1) + 1) {
                    return fractions[j + 1];
                } else {
                    K -= (i - 1) - (j + 1) + 1;
                    l = i;
                }
            }
        }
    }

    int cmp(int[] a, int[] b) {
        return a[0] * b[1] - a[1] * b[0];
    }

    public static void main(String[] args) {
        _786 sol = new _786();
        int[] A = new int[]{1, 7, 23, 29, 47};
        for (int i = 1; i <= A.length * (A.length - 1) / 2; i++) {
            System.out.println(Arrays.toString(sol.kthSmallestPrimeFraction(A, i)));
        }
    }
}
