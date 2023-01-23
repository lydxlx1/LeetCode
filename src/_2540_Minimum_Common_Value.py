"""
LeetCode 2540 - Minimum Common Value
"""
class Solution:
    def getCommon(self, nums1: List[int], nums2: List[int]) -> int:
      intersection = set(nums1) & set(nums2)
      return min(intersection) if intersection else -1
