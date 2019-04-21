"""
LeetCode 1030 - Matrix Cells in Distance Order

Manhattan distance order  <==> BFS order
"""

from typing import *


class Solution:
    def allCellsDistOrder(self, R: int, C: int, r0: int, c0: int) -> List[List[int]]:
        queue = [(r0, c0)]
        visited = set(queue)
        head = 0

        dx = [0, 0, 1, -1]
        dy = [1, -1, 0, 0]

        while head < len(queue):
            x, y = queue[head]
            head += 1
            for k in range(4):
                xx = x + dx[k]
                yy = y + dy[k]
                if xx >= 0 and xx < R and yy >= 0 and yy < C and ((xx, yy) not in visited):
                    queue.append((xx, yy))
                    visited.add((xx, yy))

        return queue
