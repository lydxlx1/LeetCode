/**
 * LeetCode 2560 - House Robber IV
 * 
 * Bisect the minimum capability as it's monotone function.
 * For each fixed capability, we scan array from left to right and
 * use a greedy approach to decide whether the capability is feasible.
 *
 * Time complexity: O(n log M), where n = len(nums), M = max element of nums
 * Space complexity: O(1)
 */
class Solution {
public:
    int minCapability(vector<int>& nums, int k) {
        int left = 0, right = *max_element(nums.begin(), nums.end());
        while (left + 1 < right) {
            int mid = (left + right) / 2;
            int cnt = 0, prev = -2;
            for (int i=0; i<nums.size() && cnt < k; i++) {
                if (nums[i] <= mid && i > prev + 1) {
                    cnt++;
                    prev = i;
                }
            }
            
            if (cnt >= k) {
                right = mid;
            } else {
                left = mid;
            }
        }
        return right;
    }
};