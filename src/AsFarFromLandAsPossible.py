"""
As Far from Land as Possible

BFS with multiple source enqueued
"""
from typing import *


class Solution:
    def maxDistance(self, grid: List[List[int]]) -> int:
        dx = [0, 0, 1, -1]
        dy = [1, -1, 0, 0]
        r, c = len(grid), len(grid[0])

        max_water_dist = {}

        dist = {}
        queue = Deque()
        for i in range(r):
            for j in range(c):
                if grid[i][j] == 1:
                    dist[i, j] = 0
                    queue.append((i, j))
        while queue:
            i, j = queue.popleft()
            if grid[i][j] == 0:
                if (i, j) not in max_water_dist:
                    max_water_dist[i, j] = dist[i, j]
                else:
                    max_water_dist[i, j] = max(max_water_dist[i, j], dist[i, j])

            for k in range(4):
                ii = i + dx[k]
                jj = j + dy[k]
                if 0 <= ii < r and 0 <= jj < c and (ii, jj) not in dist:
                    dist[ii, jj] = dist[i, j] + 1
                    queue.append((ii, jj))

        return -1 if not max_water_dist else max(max_water_dist.values())
