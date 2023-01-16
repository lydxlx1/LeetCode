/**
 * LeetCode 2537 - Count the Number of Good Subarrays
 *
 * Sliding window approach
 * O(n) time / space complexity
 */

class Solution {
public:
  long long countGood(vector<int> &nums, int k) {
    long long ans = 0;
    long long cur_good_pair = 0;
    unordered_map<int, long long> counter;

    // Enumerate each right boundary of the sliding window.
    // Find the smallest window [left, right] to satisfy the "good" condition.
    // Then, every subarray with left boundary no bigger than `left` will all satisfy the condition.
    for (int right = 0, left = 0; right < nums.size(); right++) {
      cur_good_pair += counter[nums[right]];
      counter[nums[right]]++;

      while (left <= right && cur_good_pair - (counter[nums[left]] - 1) >= k) {
        counter[nums[left]]--;  // Do this step first to exclude the number itself
        cur_good_pair -= counter[nums[left]];
        left++;
      }
      if (cur_good_pair >= k) {
        // [0, 1, ... left] are good left boundary candidates w.r.t. right
        ans += left + 1;
      }
    }
    return ans;
  }
};
