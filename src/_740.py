"""
LeetCode 740 - Delete and Earn

DP
"""


class Solution:
    def deleteAndEarn(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        n = 10001
        cnt, f = [0] * n, [0] * n
        for num in nums:
            cnt[num] += 1
        for i in range(n):
            f[i] = max(f[i - 1] if i - 1 >= 0 else 0, i * cnt[i] + (f[i - 2] if i - 2 >= 0 else 0))
        return max(f)
