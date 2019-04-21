"""
LeetCode 1029 - Two City Scheduling

DP
Only need to use O(2N * N) runtime and space.
"""

from typing import *


class Solution:
    def twoCitySchedCost(self, costs: List[List[int]]) -> int:
        N = len(costs) // 2
        f = {}
        inf = 1 << 29
        f[-1, 0] = 0

        for i in range(2 * N):
            # Consider people with index in [0, i], which is a total of i + 1 people.
            # So, need 0 <= j < i + 2
            for j in range(i + 2):
                f[i, j] = inf
                if (i - 1, j - 1) in f:
                    f[i, j] = min(f[i, j], f[i - 1, j - 1] + costs[i][0])
                if (i - 1, j) in f:
                    f[i, j] = min(f[i, j], f[i - 1, j] + costs[i][1])

        return f[2 * N - 1, N]
