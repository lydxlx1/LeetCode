"""
LeetCode 994 - Rotting Oranges

BFS
"""
from typing import *


class Solution:
    def orangesRotting(self, grid: 'List[List[int]]') -> 'int':
        dx = [0, 0, 1, -1]
        dy = [1, -1, 0, 0]

        ans = 0
        r, c = (len(grid), len(grid[0]))
        cur = [(i, j) for i in range(r) for j in range(c) if grid[i][j] == 2]
        while cur:
            next = []

            for (i, j) in cur:
                for k in range(4):
                    ii, jj = (i + dx[k], j + dy[k])
                    if ii >= 0 and ii < r and jj >= 0 and jj < c and grid[ii][jj] == 1:
                        next.append((ii, jj))
                        grid[ii][jj] = 2

            if next: ans += 1
            cur = next

        has_fresh_orange = any(1 in row for row in grid)
        return -1 if has_fresh_orange else ans
