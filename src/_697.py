"""
LeetCode 697 - Degree of an Array
"""
from collections import defaultdict


class Solution:
    def findShortestSubArray(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        map = defaultdict(list)
        for i in range(len(nums)):
            map[nums[i]].append(i)
        return min((-len(list), list[-1] - list[0] + 1) for list in map.values())[1]


sol = Solution()
print(sol.findShortestSubArray((1, 2, 2, 3, 1)))
print(sol.findShortestSubArray((1, 2, 2, 3, 1, 4, 2)))
