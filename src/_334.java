/**
 * LeetCode 334 - Increasing Triplet Subsequence
 *
 * Indeed a Longest Increasing Subsequence problem
 *
 * Let us consider the general problem, i.e., determining whether there exists an increasing k-subsequence.
 * This problem is essentially equivalent to finding the Longest Increasing Subsequence.
 * The only difference is that we can just return true if an increasing subsequence of length k is found.
 * Below is an O(n log k)-time solution using O(k) space. For this particular problem, k = 3, so the runtime is O(n) and the space is O(1).
 *
 * // C++ Code
 * bool increasingTriplet(vector<int>& nums) {
 *     vector<int> ans;
 *     for (int a : nums) {
 *         if (ans.size() == 0 || a > ans.back()) ans.push_back(a);
 *         else *lower_bound(ans.begin(), ans.end(), a) = a;
 *         if (ans.size() >= 3) return true;
 *     }
 *     return false;
 * }
 *
 * See here also. https://leetcode.com/discuss/86706/o-n-log-k-time-o-k-space-alg-for-any-increasing-k-subsequence
 */
public class _334 {
    public boolean increasingTriplet(int[] nums) {
        for (int one=Integer.MAX_VALUE, two=one, i=0; i<nums.length; i++)
            if (nums[i] > two) return true;
            else if (nums[i] > one) two = nums[i];
            else one = nums[i];
        return false;
    }
}