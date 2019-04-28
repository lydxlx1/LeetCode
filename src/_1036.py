"""
LeetCode 1036 - Escape a Large Maze

DFS

We only need to check whether source is completely contained inside a closed blocker region so it is isolated
from the target, or vice versa.

Although the maze is quite big, there are only at most 200 blockers. Therefore, we could just perform a DFS
on a grid that is slightly bigger than 400 * 400 and centered at source.

If we could reach target from source inside the grid, then there is clearly a solution.
If we could reach the boundary of this grid, that means source is not blocked these blockers.
Otherwise, source is blocked and isolated from target, so there is no solution.

We then do the same thing from target.
If both source and target are not blocked and isolated from each other, then it is not hard to construct
a path as the maze is sufficient large.
"""

from typing import *


class Solution:
    def isEscapePossible(self, blocked: List[List[int]], source: List[int], target: List[int]) -> bool:
        dx = [0, 0, 1, -1]
        dy = [1, -1, 0, 0]
        blocked = {tuple(each) for each in blocked}

        def is_blocked(i, j, source, target, visited):
            if i < 0 or i >= 10 ** 6 or j < 0 or j >= 10 ** 6:
                return True
            if (i, j) in blocked:
                return True
            if (i, j) in visited:
                return True
            if (i, j) == target:
                return False
            if abs(i - source[0]) > 250 or abs(j - source[1]) > 250:
                return False
            visited.add((i, j))

            for k in range(4):
                x = i + dx[k]
                y = j + dy[k]
                if not is_blocked(x, y, source, target, visited):
                    return False
            return True

        if is_blocked(*source, source, target, set()):
            return False
        if is_blocked(*target, source, target, set()):
            return False
        return True
