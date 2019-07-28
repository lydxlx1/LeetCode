"""
Stone Game II

Game Theory + DP
"""

from typing import *


class Solution:
    def stoneGameII(self, piles: List[int]) -> int:
        n = len(piles)
        piles = [0] + piles  # Convert into 1-index array
        for i in range(1, n + 1):
            piles[i] += piles[i - 1]  # Convert into prefix-sum array

        def f(m, i, memo):
            if i > n:
                return 0
            if (m, i) in memo:
                return memo[m, i]

            ans = 0
            for j in range(i, min(n + 1, i + 2 * m)):
                ans = max(ans, piles[j] - piles[i - 1] + (piles[n] - piles[j] - f(max(m, j - i + 1), j + 1, memo)))
            memo[m, i] = ans
            return ans

        return f(1, 1, {})
