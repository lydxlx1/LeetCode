"""
Largest 1-Bordered Square

Brute-force & counting
"""

from typing import *


class Solution:
    def largest1BorderedSquare(self, grid: List[List[int]]) -> int:
        r, c = len(grid), len(grid[0])
        for i in range(r):
            for j in range(c):
                grid[i][j] += grid[i - 1][j] if i - 1 >= 0 else 0
                grid[i][j] += grid[i][j - 1] if j - 1 >= 0 else 0
                grid[i][j] -= grid[i - 1][j - 1] if i - 1 >= 0 and j - 1 >= 0 else 0

        def sum(i1, i2, j1, j2):
            ans = grid[i2][j2]
            ans -= grid[i2][j1 - 1] if j1 - 1 >= 0 else 0
            ans -= grid[i1 - 1][j2] if i1 - 1 >= 0 else 0
            ans += grid[i1 - 1][j1 - 1] if i1 - 1 >= 0 and j1 - 1 >= 0 else 0
            return ans

        for size in range(min(r, c), 0, -1):
            for i in range(r - size + 1):
                for j in range(c - size + 1):
                    i1, i2 = i, i + size - 1
                    j1, j2 = j, j + size - 1
                    if sum(i1, i1, j1, j2) == size and sum(i2, i2, j1, j2) == size and sum(i1, i2, j1, j1) == size and sum(i1, i2, j2, j2) == size:
                        return size ** 2
        return 0
