"""1368. Minimum Cost to Make at Least One Valid Path in a Grid

Shortest Path

Build the graph
- For each grid cell, create four directed edges to its neighbors (if exist).
- The weight of the edge is 0 if the edge direction matches with the number in cell, otherwise the weight is 1.
  This means each cell will have exactly one outgoing edge with 0 weight, and two or three outgoing edges with weight equal to 1.o
- Then, the length of the shortest path from top-left to bottom-right will be the answer.

Correctness


Time: O(mn log (mn)), which can be further optimized to O(mn).
      This is because weights of edges in this graph are either 0 or 1, so we can compute the shortest path using BFS with a Deque.
      Formally, we insert to the head of the queue if the edge weight is 0 and insert to the tail of the queue if weight is 1.
Space: O(mn)


"""

from sortedcontainers import SortedList
from typing import List


class Solution:
    def minCost(self, grid: List[List[int]]) -> int:
        dx = [None, 0, 0, 1, -1]
        dy = [None, 1, -1, 0, 0]

        dist = {(0, 0): 0}
        queue = SortedList([(0, 0, 0)])
        while queue:
            d, i, j = queue.pop(0)
            if i == len(grid) - 1 and j == len(grid[0]) - 1:
                return d
            for k in [1, 2, 3, 4]:
                ii = i + dx[k]
                jj = j + dy[k]
                if 0 <= ii < len(grid) and 0 <= jj < len(grid[0]):
                    dd = d + (1 if grid[i][j] != k else 0)
                    if (ii, jj) not in dist or dd < dist[ii, jj]:
                        dist[ii, jj] = dd
                        queue.add((dd, ii, jj))
        return -1
