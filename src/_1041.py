"""
LeetCode 1041 - Robot Bounded In Circle

Brute-force
"""


class Solution:
    def isRobotBounded(self, instructions: str) -> bool:
        dx = [-1, 0, 1, 0]
        dy = [0, 1, 0, -1]

        x, y = 0, 0
        k = 0
        visited = {(0, 0)}
        for _ in range(1000):
            for i in range(len(instructions)):
                ch = instructions[i]
                if ch == 'G':
                    x += dx[k]
                    y += dy[k]
                elif ch == 'L':
                    k = (k + 3) % 4
                else:
                    k = (k + 1) % 4
                if (i, x, y) in visited:
                    return True
                else:
                    visited.add((i, x, y))
        return False
