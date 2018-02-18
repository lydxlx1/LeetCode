import java.util.Arrays;

/**
 * LeetCode 786 - K-th Smallest Prime Fraction
 * <p>
 * Young Tableau
 * O(n^2)-time, O(1)-space
 */
public class _786_1 {

    public int[] kthSmallestPrimeFraction(int[] A, int K) {
        int nu = 0, de = 1;
        while (true) {
            int rank = rank(A, nu, de);
            if (rank == K) {
                return new int[]{A[nu], A[de]};
            } else if (K <= rank) {
                de++;
            } else {
                nu++;
                if (nu == de) {
                    de++;
                }
            }
        }
    }

    int cmp(int[] A, int i, int j, int x, int y) {
        return A[i] * A[y] - A[j] * A[x];
    }

    int rank(int[] A, int p, int q) {
        int rank = 0;
        for (int nu = 0, de = 1; nu < A.length - 1 && de < A.length; ) {
            if (cmp(A, nu, de, p, q) < 0) {
                rank += A.length - de;
                nu++;
                if (nu > de) {
                    de++;
                }
            } else {
                de++;
            }
        }
        return rank + 1;
    }

    public static void main(String[] args) {
        _786_1 sol = new _786_1();
        int[] A = new int[]{1, 7, 23, 29, 47};
        for (int i = 1; i <= A.length * (A.length - 1) / 2; i++) {
            System.out.println(Arrays.toString(sol.kthSmallestPrimeFraction(A, i)));
        }
    }
}
