"""
LeetCode 997 - Find the Town Judge

Essentially the "universal sink" problem
"""
from typing import *


class Solution:
    def findJudge(self, N: int, trust: List[List[int]]) -> int:
        in_deg, out_deg = [0] * (N + 1), [0] * (N + 1)
        for u, v in trust:
            out_deg[u] += 1
            in_deg[v] += 1

        judge = [i for i in range(1, N + 1) if in_deg[i] == N - 1]
        if len(judge) != 1 or out_deg[judge[0]] > 0:
            return -1
        return judge[0]


