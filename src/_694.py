"""
LeetCode 694 - Number of Distinct Islands

DFS + Sorting + Hashing
"""


class Solution:
    DX = (0, 0, 1, -1)
    DY = (1, -1, 0, 0)

    def numDistinctIslands(self, grid):
        """
        :type grid: List[List[int]]
        :rtype: int
        """

        if len(grid) == 0 or len(grid[0]) == 0:
            return 0
        r = len(grid)
        c = len(grid[0])

        islands = set()
        for i in range(0, r):
            for j in range(0, c):
                if grid[i][j] == 1:
                    island_list = []
                    self.dfs(grid, i, j, r, c, island_list)

                    island_list.sort()
                    (min_x, min_y) = island_list[0]

                    islands.add(tuple([(x - min_x, y - min_y) for (x, y) in island_list]))
        return len(islands)

    def dfs(self, grid, i, j, r, c, island_list):
        grid[i][j] = -1
        island_list.append((i, j))
        for k in range(0, 4):
            x = i + self.DX[k]
            y = j + self.DY[k]
            if 0 <= x < r and 0 <= y < c and grid[x][y] == 1:
                self.dfs(grid, x, y, r, c, island_list)


sol = Solution()
grid = [
    [1, 1, 0, 0, 0],
    [1, 1, 0, 0, 0],
    [0, 0, 0, 1, 1],
    [0, 0, 0, 1, 1],
]
print(sol.numDistinctIslands(grid))
