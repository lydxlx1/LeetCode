/**
 * LeetCode 1021 - Best Sightseeing Pair
 *
 * Greedy
 * O(n)-time solution
 */
public class _1021 {

    public int maxScoreSightseeingPair(int[] A) {
        int ans = Integer.MIN_VALUE;
        int max = A[0] + 0;
        for (int j = 1; j < A.length; j++) {
            ans = Math.max(ans, max + A[j] - j);
            max = Math.max(max, A[j] + j);
        }
        return ans;
    }
}

