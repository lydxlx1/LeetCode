"""
LeetCode 1035 - Uncrossed Lines

DP
Quite similar to LCS problem
"""

from typing import *


class Solution:
    def maxUncrossedLines(self, A: List[int], B: List[int]) -> int:
        def dfs(i, j, memo):
            if i < 0 or j < 0:
                return 0
            if (i, j) in memo:
                return memo[i, j]
            if A[i] == B[j]:
                ans = dfs(i - 1, j - 1, memo) + 1
            else:
                ans = max(dfs(i, j - 1, memo), dfs(i - 1, j, memo))
            memo[i, j] = ans
            return ans

        return dfs(len(A) - 1, len(B) - 1, {})
