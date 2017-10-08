"""
LeetCode 695 Max Area of Island

DFS approach
"""
class Solution:
    DX = (0, 0, 1, -1)
    DY = (1, -1, 0, 0)

    def maxAreaOfIsland(self, grid):
        """
        :type grid: List[List[int]]
        :rtype: int
        """
        if len(grid) == 0 or len(grid[0]) == 0:
            return 0
        r = len(grid)
        c = len(grid[0])

        res = 0
        for i in range(0, r):
            for j in range(0, c):
                if grid[i][j] == 1:
                    self.cnt = 0
                    self.dfs(grid, i, j, r, c)
                    res = max(res, self.cnt)
        return res

    def dfs(self, grid, i, j, r, c):
        self.cnt += 1
        grid[i][j] = -1
        for k in range(0, 4):
            x = i + self.DX[k]
            y = j + self.DY[k]
            if 0 <= x < r and 0 <= y < c and grid[x][y] == 1:
                self.dfs(grid, x, y, r, c)
