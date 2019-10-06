"""Path with Maximum Gold

Backtracking"""

from typing import *
from collections import *


class Solution:
    def getMaximumGold(self, grid: List[List[int]]) -> int:
        dx = [0, 0, 1, -1]
        dy = [1, -1, 0, 0]

        def dfs(i: int, j: int, visited: Set) -> int:
            visited.add((i, j))
            best = 0
            for k in range(4):
                ii, jj = i + dx[k], j + dy[k]
                if 0 <= ii < len(grid) and 0 <= jj < len(grid[0]) and grid[ii][jj] > 0 and (ii, jj) not in visited:
                    best = max(best, dfs(ii, jj, visited))
            visited.remove((i, j))
            return grid[i][j] + best

        return max(dfs(i, j, set()) for i in range(len(grid)) for j in range(len(grid[0])) if grid[i][j] > 0)
