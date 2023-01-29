/**
 * LeetCode 2552 - Count Increasing Quadruplets
 *
 * Counting Problem
 * One possible idea is to enumerate every pair of (j, k).
 * Then count two things and multiply them together.
 * (1) # of i's, 0 <= i < j, such that nums[i] < nums[k]
 * (2) # of l's, k <  l < n, such that nums[j] < nums[l]
 *
 * Binary indexed tree can be used here to speed up the counting process,
 * and the overall runtime is O(n^2 log n), using O(n) space.
 */
class Solution {
public:

    inline void add(vector<int>& bit, int i, int delta) {
        for (; i<bit.size(); i+=i&-i)
            bit[i] += delta;
    }

    inline int sum(vector<int>& bit, int i) {
        int ans = 0;
        for (; i > 0; i -= i&-i)
            ans += bit[i];
        return ans;
    }


    long long countQuadruplets(vector<int>& nums) {
        long long ans = 0;
        vector<int> bit1(nums.size() + 1);
        vector<int> bit2(nums.size() + 1);

        for (int j=0; j<nums.size(); j++) {
            if (j - 1 >= 0)
                add(bit1, nums[j - 1], 1);
            fill(bit2.begin(), bit2.end(), 0);
            for (int k=nums.size()-1; j<k; k--) {
                if (k + 1 < nums.size())
                    add(bit2, nums[k + 1], 1);
                if (nums[k] < nums[j]) {
                    long long left = sum(bit1, nums[k] - 1);
                    long long right = (nums.size() - k - 1) - sum(bit2, nums[j]);
                    assert (left >= 0 && right >= 0);
                    ans += left * right;
                }
            }
        }

        return ans;
    }
};
