import java.util.TreeMap;

/**
 * LeetCode 862 - Shortest Subarray with Sum at Least K
 * <p>
 * - This problem cannot be solved by binary search as the answer does not satisfy monotonicity property.
 * - Let s[i] denote the prefix sum of A[0..i]. Then, let's consider all the subarrays ending at position i that has sum >= K.
 * - That is, when i is fixed, given an index j s.t. 0 <= j <= i, we want the subarray A[j..i] to have sum >= K.
 * - That is, s[i] - s[j] + A[j] >= K, which is
 * - s[j] - A[j] <= s[i] - K.
 * -
 * - Note that, s[i] - K is a constant when i is fixed. Then, we just want to find largest j s.t. s[j] - A[j] is no larger than some constant.
 * - Such a problem can be easily solved by a balanced augmented BST.
 */
public class _862 {

    public int shortestSubarray(int[] A, int K) {
        int ans = Integer.MAX_VALUE;
        final int n = A.length;
        int[] prefixSum = new int[n];
        for (int i = 0; i < n; i++) {
            prefixSum[i] = (i > 0 ? prefixSum[i - 1] : 0) + A[i];
        }
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < A.length; i++) {
            while (!map.isEmpty() && map.lastKey() >= prefixSum[i] - A[i]) {
                map.pollLastEntry();
            }
            map.put(prefixSum[i] - A[i], i);

            if (map.floorEntry(prefixSum[i] - K) != null) {
                ans = Math.min(ans, i - map.floorEntry(prefixSum[i] - K).getValue() + 1);
            }
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}

