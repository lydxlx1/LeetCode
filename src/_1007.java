/**
 * LeetCode 1007 - Minimum Domino Rotations For Equal Row
 *
 * Brute-force
 *
 * In fact, even if A[i] and B[i] have arbitrary range, we can still solve this problem in O(n) time due to the fact
 * that # of feasible solutions can be at most two. To see why:
 *
 * - In total we have 2N numbers.
 * - If there is a feasible solution, there must be at least N identical numbers.
 * - # of distinct numbers w.r.t. to some feasible solution is therefore <= 2.
 */
public class _1007 {

    int inf = 1 << 29;

    public int minDominoRotations(int[] A, int[] B) {
        int ans = inf;
        for (int i = 1; i <= 6; i++) {
            ans = Math.min(ans, doit(A, B, i));
            ans = Math.min(ans, doit(B, A, i));
        }
        return ans < inf ? ans : -1;

    }

    /**
     * Try to make values in A all equal to target
     */
    int doit(int[] A, int[] B, int target) {
        int cnt = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] != target) {
                if (B[i] == target) {
                    cnt++;
                } else {
                    return inf;
                }
            }
        }
        return cnt;
    }
}

