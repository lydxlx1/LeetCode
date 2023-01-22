/**
 * Leetcode 2542 - Maximum Subsequence Score
 *
 * Greedy approach
 * Sort indices in non-decreasing order of nums2, then maintain
 * those k indices with largest values in nums1, which can achieved
 * by either a min-heap or multiset.
 *
 * Time complexity: O(n log n + n log k) = O(n log n)
 * Space complexity: O(n)
 */
class Solution {
public:
    long long maxScore(vector<int>& nums1, vector<int>& nums2, int k) {
      int n = nums1.size();
      vector<int> rank(n);
      for (int i=0; i<n; i++) {
        rank[i] = i;
      }
      sort(rank.begin(), rank.end(), [&](int i, int j) { return nums2[i] > nums2[j]; });
      multiset<int> topk;
      long long ans = 0;
      long long sum = 0;
      for (int i : rank) {
        sum += nums1[i];
        topk.insert(nums1[i]);
        if (topk.size() > k) {
          sum -= *topk.begin();
          topk.erase(topk.begin());
        }
        if (topk.size() == k) {
          ans = max(ans, sum * nums2[i]);
        }
      }
      return ans;
    }
};
