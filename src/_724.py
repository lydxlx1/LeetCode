"""
LeetCode 724 - Find Pivot Index

Just use prefix-sum
"""
class Solution:
    def pivotIndex(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """

        prefix_sum = [0] * len(nums)
        for i in range(len(nums)):
            prefix_sum[i] = prefix_sum[i - 1] + nums[i]
        for i in range(len(nums)):
            left = prefix_sum[i - 1] if i - 1 >= 0 else 0
            right = prefix_sum[-1] - prefix_sum[i]
            if left == right:
                return i
        return -1
