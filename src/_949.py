"""
LeetCode 949 - Largest Time for Given Digits
"""

from itertools import permutations


class Solution:
    def largestTimeFromDigits(self, A):
        """
        :type A: List[int]
        :rtype: str
        """
        ans = ""
        for (a, b, c, d) in permutations(A):
            hour = a * 10 + b
            minute = c * 10 + d
            if 0 <= hour < 24 and 0 <= minute < 60:
                current = "{:02d}:{:02d}".format(hour, minute)
                if ans == "" or current > ans:
                    ans = current
        return ans
