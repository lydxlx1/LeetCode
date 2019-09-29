"""Minimum Moves to Reach Target with Rotations

BFS
Be careful of the following two cases.
- The snake can move one step to the right and to the bottom no matter whether it's currently horizontal or vertical.
- The snake can rotate only if the 2x2 square contains ALL zeros
"""

from typing import *


class Solution:
    def minimumMoves(self, grid: List[List[int]]) -> int:
        n = len(grid)
        dist = {}
        queue = Deque()
        queue.append((0, 0, 0))
        dist[0, 0, 0] = 0

        def try_enqueue(x, y, dir, previous_d):
            if dir == 0:
                if not (0 <= x < n and 0 <= y < y + 1 < n and grid[x][y] == grid[x][y + 1] == 0):
                    return
            else:
                if not (0 <= x < x + 1 < n and 0 <= y < n and grid[x][y] == grid[x + 1][y] == 0):
                    return
            if (x, y, dir) not in dist:
                dist[x, y, dir] = previous_d + 1
                queue.append((x, y, dir))

        while queue:
            x, y, dir = queue.popleft()
            d = dist[x, y, dir]

            if x == n - 1 and y == n - 2 and dir == 0:
                return dist[x, y, dir]

            try_enqueue(x, y + 1, dir, d)
            try_enqueue(x + 1, y, dir, d)
            if x + 1 < n and y + 1 < n and grid[x + 1][y + 1] == 0:
                try_enqueue(x, y, 1 - dir, d)

        return -1
