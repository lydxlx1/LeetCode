"""
LeetCode 827 - Making a Large Island

Union-Find Set
"""


class Solution:
    def largestIsland(self, grid):
        """
        :type grid: List[List[int]]
        :rtype: int
        """
        parent = {}
        size = {}

        def find(pair):
            if parent[pair] != pair:
                parent[pair] = find(parent[pair])
            return parent[pair]

        def union(i, j):
            i = find(i)
            j = find(j)
            if find(i) != find(j):
                parent[i] = j
                size[j] += size[i]

        r, c = len(grid), len(grid[0])
        for i in range(r):
            for j in range(c):
                parent[(i, j)] = (i, j)
                size[(i, j)] = 1

        def in_range(i, j):
            return i >= 0 and i < r and j >= 0 and j < c

        ans = 0
        for i in range(r):
            for j in range(c):
                if grid[i][j] == 1:
                    for dx, dy in zip([0, 0, 1, -1], [1, -1, 0, 0]):
                        ii, jj = i + dx, j + dy
                        if in_range(ii, jj) and grid[ii][jj] == 1:
                            union((i, j), (ii, jj))
                    ans = max(ans, size[find((i, j))])

        for i in range(r):
            for j in range(c):
                if grid[i][j] == 0:
                    cand = set()
                    for dx, dy in zip([0, 0, 1, -1], [1, -1, 0, 0]):
                        ii, jj = i + dx, j + dy
                        if in_range(ii, jj) and grid[ii][jj] == 1:
                            cand.add(find((ii, jj)))
                    local = sum(size[each] for each in cand) + 1
                    ans = max(ans, local)

        return ans
