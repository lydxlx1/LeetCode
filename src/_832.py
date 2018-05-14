"""
LeetCode 832 - Flipping an Image
"""


class Solution:
    def flipAndInvertImage(self, A):
        """
        :type A: List[List[int]]
        :rtype: List[List[int]]
        """
        return [[1 - i for i in reversed(a)] for a in A]
