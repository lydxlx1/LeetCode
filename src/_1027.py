"""
LeetCode 1027 - Longest Arithmetic Sequence

O(n^2)-time DP
"""

from typing import *


class Solution:
    def longestArithSeqLength(self, A: List[int]) -> int:
        ans = 2
        f = {}
        for i in range(1, len(A)):
            for j in range(0, i):
                diff = A[i] - A[j]
                length = 1 + f[j, diff] if (j, diff) in f else 2
                f[i, diff] = length  # Technically, we need to f[i, diff] = max(f[i, diff], length), but this works.
                ans = max(ans, length)
        return ans
