/**
 * LeetCode 795 - Number of Subarrays with Bounded Maximum
 * <p>
 * O(n)-time solution, using O(1) space.
 */
public class _795_1 {

    public int numSubarrayBoundedMax(int[] A, int L, int R) {

        return count(A, R) - count(A, L - 1);
    }

    private int count(int[] A, int max) {
        int cnt = 0, acc = 0;
        for (int i : A) {
            if (i <= max) {
                acc++;
                cnt += acc;
            } else {
                acc = 0;
            }
        }
        return cnt;
    }
}
