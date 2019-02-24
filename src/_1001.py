"""
LeetCode 1001 - Grid Illumination

Similar to the 8-queen question, we maintain 4 different visited arrays, for horizontal direction, vertical direction,
and two diagonals, respectively.
"""
from typing import *
from collections import defaultdict


class Solution:
    def gridIllumination(self, N: int, lamps: List[List[int]], queries: List[List[int]]) -> List[int]:
        dx = [0, 0, 1, 1, 1, -1, -1, -1]
        dy = [-1, 1, -1, 0, 1, -1, 0, 1]

        lamps = {(x, y) for (x, y) in lamps}
        hash1, hash2, hash3, hash4 = defaultdict(int), defaultdict(int), defaultdict(int), defaultdict(int)

        for x, y in lamps:
            hash1[x] += 1
            hash2[y] += 1
            hash3[x + y] += 1
            hash4[x - y] += 1

        res = [0] * len(queries)
        for i in range(len(queries)):
            x, y = queries[i]

            if hash1[x] or hash2[y] or hash3[x + y] or hash4[x - y]:
                res[i] = 1
            for k in range(len(dx)):
                xx, yy = (x + dx[k], y + dy[k])
                if (xx, yy) in lamps:
                    lamps.remove((xx, yy))
                    hash1[xx] -= 1
                    hash2[yy] -= 1
                    hash3[xx + yy] -= 1
                    hash4[xx - yy] -= 1

        return res
