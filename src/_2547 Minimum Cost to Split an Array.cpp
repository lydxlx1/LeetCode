/**
 * LeetCode 2547 - Minimum Cost to Split an Array
 *
 * 2D-DP
 * Let f[i] be the minimum cost to split subarray nums[i .. ].
 * To transit, we numerate every possible first split, i.e., nums[i .. j],
 * and then recursively solve the problem for the sub-proble nums[j + 1 .. ],
 * which is f[j + 1].
 *
 * Base case is that f[n + 1] = 0.
 * Also note that for each i, while we are enumerating all the j's, we only
 * need to maintain one counter to compute the "trimmed" cost since the way
 * we enumerate j's is continuous.
 *
 * Time complexity: O(n^2)
 * Space complexity: O(n)
 */

class Solution {
public:
  int minCost(vector<int> &nums, int k) {
    vector<int> f(nums.size() + 1, 0);
    vector<int> cnt(nums.size(), 0);

    for (int i = nums.size() - 1; i >= 0; i--) {
      fill(cnt.begin(), cnt.end(), 0);

      // Pay attention to this number as k can be as large as 10^9.
      // So, in the extreme case, answer can be 10^9 + nums.length,
      // when k = 10^9, and all numbers in nums are identical.
      f[i] = 1 << 30;
      int unique_cnt = 0;
      for (int j = i; j < nums.size(); j++) {
        if (cnt[nums[j]] == 0)
          unique_cnt++;
        else if (cnt[nums[j]] == 1)
          unique_cnt--;
        cnt[nums[j]]++;

        f[i] = min(f[i], k + (j - i + 1 - unique_cnt) + f[j + 1]);
      }
    }
    return f[0];
  }
};
