/**
 * LeetCode 961 - N-Repeated Element in Size 2N Array
 *
 * Partition-based approach
 */
public class _961 {

    public int repeatedNTimes(int[] A) {
        int l = 0, r = A.length - 1, n = A.length / 2;
        while (true) {
            int less = l, equal = l, greater = l, pivot = A[(int) (l + (r - l) * 0.618)];
            // less than pivot: [l, less)
            // equal to pivot: [less, equal)
            // greater than pivot: [equal, greater)
            for (int i = l; i <= r; i++) {
                int cur = A[i];
                if (cur > pivot) {
                    A[greater++] = cur;
                } else if (cur == pivot) {
                    A[greater++] = A[equal];
                    A[equal++] = cur;
                } else {
                    A[greater++] = A[equal];
                    A[equal++] = A[less];
                    A[less++] = cur;
                }
            }
            if (equal - less == n) {
                return pivot;
            } else if (less - l >= n) {
                r = less - 1;
            } else {
                l = equal;
            }
        }
    }
}

